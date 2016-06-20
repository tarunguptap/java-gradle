package com.example.hibernate.annotation.EnumDemo.client;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.annotation.EnumDemo.enums.RoleType;
import com.example.hibernate.annotation.EnumDemo.model.AuditInfo;
import com.example.hibernate.annotation.EnumDemo.model.Customer;


public class Client1 {

	public static void main(String[] args) 
	{
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("com/example/hibernate/annotation/EnumDemo/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			AuditInfo auditInfo = new AuditInfo();
			Customer cust = new Customer("1", "tarun","gupta", "87787","45545",auditInfo, RoleType.ROLE_API);
			hibernateTemplate.save(cust);
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
