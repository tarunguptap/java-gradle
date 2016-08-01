package com.example.hibernate.xml.inheritence.OneTablePerSubClassInheritance.model;

public class CreditCard extends Payment{

	private static final long serialVersionUID = 1L;
	private String creditCardType;
	/**
	 * @return the creditCardType
	 */
	public String getCreditCardType() {
		return creditCardType;
	}
	/**
	 * @param creditCardType the creditCardType to set
	 */
	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}


}