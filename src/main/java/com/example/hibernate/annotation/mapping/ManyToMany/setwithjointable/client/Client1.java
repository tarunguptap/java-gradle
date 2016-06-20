package com.example.hibernate.annotation.mapping.ManyToMany.setwithjointable.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.annotation.mapping.ManyToMany.setwithjointable.model.Phone;
import com.example.hibernate.annotation.mapping.ManyToMany.setwithjointable.model.Student;


public class Client1 {

	public static void main(String[] args) 
	{
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("com/example/hibernate/annotation/mapping/ManyToMany/setwithjointable/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			
			Set<Phone> phoneNumbers = new HashSet<Phone>();
			
			Phone phone = new Phone("office","12151313");
			Phone phone1 = new Phone("hut","1889311111");
			phoneNumbers.add(phone);
			phoneNumbers.add(phone1);
			phoneNumbers.add(new Phone("house", "32354353"));
			phoneNumbers.add(new Phone("mobile", "9889343423"));

			Student student = new Student("Eswar", phoneNumbers);
			
			/*Set<Student> studentSet = new HashSet<Student>();
			phone.setStudents(studentSet);
			phone1.setStudents(studentSet);*/
			
			hibernateTemplate.save(student);
			
			/*Set<Student> students = new HashSet<Student>();
			Student student1 = new Student("Eswar1");
			Student student2 = new Student("Eswar2");
			Student student3 = new Student("Eswar3");
			
			students.add(student1);
			students.add(student2);
			students.add(student3);
			
			Phone phoneRecord = new Phone("NEW", "464644645", students);
			hibernateTemplate.save(phoneRecord);*/
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
