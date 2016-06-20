package com.example.hibernate.annotation.mapping.OneToMany.setjointable.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.annotation.mapping.OneToMany.setjointable.model.Phone;
import com.example.hibernate.annotation.mapping.OneToMany.setjointable.model.Student;


public class Client1 {

	public static void main(String[] args) 
	{
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("com/example/hibernate/annotation/mapping/OneToMany/setjointable/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			
Set<Phone> phoneNumbers = new HashSet<Phone>();
			
			Phone phone = new Phone();
			phone.setPhoneNumber("12151313");
			phone.setPhoneType("office");
			
			Phone phone1 = new Phone();
			phone1.setPhoneNumber("1889311111");
			phone1.setPhoneType("hut");
			
			phoneNumbers.add(phone);
			phoneNumbers.add(phone1);
			// using constructor
			phoneNumbers.add(new Phone("house", "32354353"));
			phoneNumbers.add(new Phone("mobile", "9889343423"));

			Student student = new Student("Eswar", phoneNumbers);
			
			hibernateTemplate.save(student);
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
