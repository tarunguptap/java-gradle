package com.example.hibernate.xml.inheritence.OneTablePerSubClassInheritance.main;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.inheritence.OneTablePerSubClassInheritance.model.CreditCard;

public class InsertClient {

	public static void main(String[] args) 
	{
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("HibernateMappingXML/OneTablePerClassInheritance/LabelTestPack/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			
			CreditCard creditCard = new CreditCard();
			creditCard.setAmount(1000);
			creditCard.setCreditCardType("VISA");
			hibernateTemplate.save(creditCard);
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
	}
}
