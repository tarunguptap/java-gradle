package com.example.hibernate.annotation.softdelete.onetomanyset.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.annotation.softdelete.onetomanyset.model.Phone;
import com.example.hibernate.annotation.softdelete.onetomanyset.model.Student;

public class Client1 {

	public static void main(String[] args) 
	{
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("com/example/hibernate/annotation/softdelete/onetomanyset/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			Session session =sessFactory.openSession();
			
			Student student = new Student("Eswar");
			
			Set<Phone> phoneNumbers = new HashSet<Phone>();
			phoneNumbers.add(new Phone("house", "32354353",student));
			phoneNumbers.add(new Phone("mobile", "9889343423",student));
			phoneNumbers.add(new Phone("office", "12151313",student));
			phoneNumbers.add(new Phone("hut", "1889311111",student));

			student.setStudentPhoneNumbers(phoneNumbers);
			
			hibernateTemplate.save(student);
			
			session.close();
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
