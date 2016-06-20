package com.example.hibernate.annotation.dbsequence.SequenceGeneratorOverrideDemo.client;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.annotation.dbsequence.SequenceGeneratorOverrideDemo.model.Customer;
import com.example.hibernate.annotation.dbsequence.SequenceGeneratorOverrideDemo.model.User;


public class Client1 {

	public static void main(String[] args) 
	{
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("com/example/hibernate/annotation/dbsequence/SequenceGeneratorOverrideDemo/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			Customer cust = new Customer("1", "tarun","gupta", "87787","45545",true);
			hibernateTemplate.save(cust);
			
			User user = new User("tarun");
			hibernateTemplate.save(user);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
