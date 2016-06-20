package com.example.hibernate.annotation.dbsequence.SequenceGeneratorOverrideDemo.model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import org.apache.commons.lang.StringEscapeUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;
import org.springframework.beans.factory.annotation.Configurable;

import com.example.hibernate.annotation.dbsequence.SequenceGeneratorOverrideDemo.enums.RoundingType;
import com.example.hibernate.annotation.dbsequence.SequenceGeneratorOverrideDemo.exception.CurrencyMismatchException;


@Configurable(preConstruction = true)
public class Money implements Serializable, Comparable<Money> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal amount;

	private Currency currency;

	protected Money() {

	}

	public static final Money newZeroInstance(Currency currency) {
		return new Money(BigDecimal.ZERO, currency);
	}

	public static final Money newZeroInstance() {
		return new Money(BigDecimal.ZERO);
	}

	/**
	 * Creates a money object and does automatic conversion. If the currency
	 * passed in matches the system currency, it will convert the amount to the
	 * user's company's currency. If it does not match, it will convert the
	 * amount to the system currency
	 * 
	 * @param amount
	 *            The amount given to the money object
	 * @param currency
	 *            The currency of the money object
	 */
	public Money(BigDecimal amount, Currency currency) {
		this.amount = amount.setScale(2, RoundingMode.HALF_UP);
		this.currency = currency;
	}

	/**
	 * @see Money#Money(BigDecimal, Currency)
	 */
	public Money(double amount, Currency currency) {
		this(new BigDecimal(amount), currency);
	}

	/**
	 * Creates a money object with the user's default currency
	 * 
	 * @see Money#Money(BigDecimal, Currency)
	 * @param amount
	 *            The amount of the money object
	 */
	public Money(BigDecimal amount) {
		this(amount, null);
	}

	/**
	 * @see Money#Money(BigDecimal)
	 */
	public Money(double amount) {
		this(new BigDecimal(amount), null);
	}

	private static BigDecimal convertToSystemCurrency(BigDecimal amount,
			BigDecimal exchangeRate) {
		if (exchangeRate != null)
			return amount.divide(exchangeRate, 4, RoundingMode.HALF_UP);

		return null;
	}

	private static BigDecimal convertFromSystemCurrency(BigDecimal amount,
			BigDecimal exchangeRate) {
		if (exchangeRate != null)
			return amount.multiply(exchangeRate);

		return null;
	}



	/**
	 * @return the tradeInCurrency
	 */
	public Currency getCurrency() {
		return currency;
	}


	/**
	 * NOTE: IF YOU ARE USING THIS METHOD YOU MUST SEEK APPROVAL!
	 * 
	 * @return Amount in system currency
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param tradeInCurrency
	 *            the tradeInCurrency to set
	 */
	void setCurrency(Currency currency) {
		this.currency = currency;
	}


	/**
	 * @param amount
	 *            the amount to set
	 */
	void setAmount(BigDecimal amount) {
		this.amount = amount;
	}



	/**
	 * Compares amounts based on the System currency
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(BigDecimal amount) {
		return this.amount.compareTo(amount);
	}

	/**
	 * Compares amounts based on the System currency
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(double amount) {
		return compareTo(new BigDecimal(amount));
	}

	public int compareToZero() {
		return compareTo(BigDecimal.ZERO);
	}

	public boolean hasSameCurrency(Money money) {
		return this.getCurrency().equals(money.getCurrency());
	}

	public boolean hasSameCurrency(Currency currency) {
		return this.getCurrency().equals(currency);
	}


	/**
	 * Returns a string representation of the money object using the locale and
	 * currency set.
	 * 
	 * @param locale
	 *            The locale to display the money object in
	 * @param displayHTML
	 *            A boolean describing whether to return HTML or ASCII text
	 * @return A string representation of the money object
	 */
	public String toString(Locale locale, boolean displayHTML) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		nf.setCurrency(getCurrency());
		String s = nf.format(getAmount());

		if (displayHTML) {
			s = StringEscapeUtils.escapeHtml(s);
		}
		return s;
	}

	/**
	 * Negates the money amount
	 * 
	 * @return The money object with the negated amount
	 */
	public Money negate() {
		return new Money(getAmount().negate(), getCurrency());
	}

	public Money add(Money money) {
		if (!this.currency.equals(money.getCurrency()))
			throw new CurrencyMismatchException();

		BigDecimal newAmount = getAmount().add(money.getAmount());
		return new Money(newAmount, getCurrency());
	}

	public Money subtract(Money money) {
		if (!this.currency.equals(money.getCurrency()))
			throw new CurrencyMismatchException();

		BigDecimal newAmount = getAmount().subtract(money.getAmount());
		return new Money(newAmount, getCurrency());
	}

	public Money multiply(Money money) {
		if (!this.currency.equals(money.getCurrency()))
			throw new CurrencyMismatchException();

		BigDecimal newAmount = getAmount().multiply(money.getAmount());
		return new Money(newAmount, getCurrency());
	}

	public Money divide(Money money) {
		if (!this.currency.equals(money.getCurrency()))
			throw new CurrencyMismatchException();

		BigDecimal newAmount = getAmount().divide(money.getAmount(), 4,
				RoundingMode.HALF_UP);
		return new Money(newAmount, getCurrency());
	}

	Money multiply(int quantity) {
		BigDecimal newAmount = getAmount().multiply(new BigDecimal(quantity));
		return new Money(newAmount, getCurrency());
	}

	Money divide(int quantity) {
		BigDecimal newAmount = getAmount().divide(new BigDecimal(quantity), 4,
				RoundingMode.HALF_UP);
		return new Money(newAmount, getCurrency());
	}

	public static class MoneyCompositeUserType implements CompositeUserType,
			Serializable {

		private static final long serialVersionUID = 1L;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.hibernate.usertype.CompositeUserType#hashCode(java.lang.Object)
		 */
		public int hashCode(Object x) throws HibernateException {
			return x.hashCode();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.hibernate.usertype.CompositeUserType#replace(java.lang.Object,
		 * java.lang.Object, org.hibernate.engine.SessionImplementor,
		 * java.lang.Object)
		 */
		public Object replace(Object original, Object target,
				SessionImplementor session, Object owner)
				throws HibernateException {
			return original;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.hibernate.usertype.CompositeUserType#assemble(java.io.Serializable
		 * , org.hibernate.engine.SessionImplementor, java.lang.Object)
		 */
		public Object assemble(Serializable cached, SessionImplementor session,
				Object owner) throws HibernateException {
			return cached;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.hibernate.usertype.CompositeUserType#deepCopy(java.lang.Object)
		 */
		public Object deepCopy(Object value) throws HibernateException {
			return value;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.hibernate.usertype.CompositeUserType#disassemble(java.lang.Object
		 * , org.hibernate.engine.SessionImplementor)
		 */
		public Serializable disassemble(Object value, SessionImplementor session)
				throws HibernateException {
			return (Serializable) value;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.hibernate.usertype.CompositeUserType#equals(java.lang.Object,
		 * java.lang.Object)
		 */
		public boolean equals(Object x, Object y) throws HibernateException {
			if (x == y)
				return true;
			if (x == null || y == null)
				return false;
			return x.equals(y);
		}

		/**
		 * @return
		 */
		public String[] getPropertyNames() {
			return new String[] { "amount", "currency" };
		}

		/**
		 * @return
		 */
		public Type[] getPropertyTypes() {
			return new Type[] { Hibernate.BIG_DECIMAL, Hibernate.CURRENCY };
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.hibernate.usertype.CompositeUserType#getPropertyValue(java.lang
		 * .Object , int)
		 */
		public Object getPropertyValue(Object component, int property)
				throws HibernateException {
			Money money = (Money) component;
			if (property == 0)
				return money.getAmount();

			if (property == 1)
				return money.getCurrency();

			return money;
		}

		/**
		 * @return
		 */
		public boolean isMutable() {
			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.hibernate.usertype.CompositeUserType#nullSafeGet(java.sql.ResultSet
		 * , java.lang.String[], org.hibernate.engine.SessionImplementor,
		 * java.lang.Object)
		 */
		public Object nullSafeGet(ResultSet rs, String[] names,
				SessionImplementor session, Object owner)
				throws HibernateException, SQLException {
			BigDecimal amount = rs.getBigDecimal(names[0]);
			if (rs.wasNull())
				return null;
			Currency currency = Currency.getInstance(rs.getString(names[1]));
			return new Money(amount, currency);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @seeorg.hibernate.usertype.CompositeUserType#nullSafeSet(java.sql.
		 * PreparedStatement, java.lang.Object, int,
		 * org.hibernate.engine.SessionImplementor)
		 */
		public void nullSafeSet(PreparedStatement st, Object value, int index,
				SessionImplementor session) throws HibernateException,
				SQLException {
			if (value == null) {
				st.setNull(index, Types.NUMERIC);
				st.setNull(index + 1, Types.VARCHAR);
			} else {
				Money money = (Money) value;
				String currencyCode = money.getCurrency().getCurrencyCode();
				st.setBigDecimal(index, money.getAmount().setScale(2,
						RoundingMode.HALF_UP));
				st.setString(index + 1, currencyCode);
			}
		}

		/**
		 * @return
		 */
		public Class<?> returnedClass() {
			return Money.class;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.hibernate.usertype.CompositeUserType#setPropertyValue(java.lang
		 * .Object , int, java.lang.Object)
		 */
		public void setPropertyValue(Object component, int property,
				Object value) throws HibernateException {
			throw new UnsupportedOperationException("Money is immutable");
		}
	}
	
	/**
	 * Method will round the amount.
	 * 
	 * @return Money
	 */
	public Money round(RoundingType roundingType){
		
		if(amount!=null){
			amount= amount.setScale(0, roundingType.getRoundingKey());
			amount= amount.setScale(2, roundingType.getRoundingKey());
			 
		}
		
		return this;
	}

	@Override
	public int compareTo(Money arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
