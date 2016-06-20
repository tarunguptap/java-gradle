package com.example.hibernate.annotation.AttributeOverrideDemo.client;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.annotation.AttributeOverrideDemo.model.Customer;


public class Client1 {

	public static void main(String[] args) 
	{
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("com/example/hibernate/annotation/AttributeOverrideDemo/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			Customer cust = new Customer("1", "tarun","gupta", "87787","45545",true);
			hibernateTemplate.save(cust);
			// When we run this, below query is executed
			//insert into CUSTOMER_INFO_NEW (active, createdBy, createdDate, lastUpdatedDate, updatedBy, deleted, firstname, lastname, mobnum, offphone, userId, version, CUSTOMER_ID) values ('1', NULL, '2014-08-21 19:31:38.087000 +05:30:00', '2014-08-21 19:31:38.087000 +05:30:00', NULL, '0', 'tarun', 'gupta', '87787', '45545', '1', '0', '4')
			// In this query the value of active should be boolean due to which execution fails as the program is generating the string value for this.
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
