package com.example.hibernate.annotation.mapping.ManyToMany.setwithjointable.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.hibernate.annotation.mapping.ManyToMany.setwithjointable.model.Phone;
import com.example.hibernate.annotation.mapping.ManyToMany.setwithjointable.model.Student;


public class FetchClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/example/hibernate/annotation/mapping/ManyToMany/setwithjointable/cfg/applicationContext.xml");
		SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
		Session session = sessFactory.openSession();
		Query qry = session.createQuery("from Student");
		List<Student> studentList = qry.list();
		System.out.println(studentList.size());
		for (Student student : studentList) {
			System.out.println(student.getStudentId());
			System.out.println(student.getStudentName());
			System.out.println(student.getPhones() !=null? student.getPhones().size():"0");
		}
		System.out.println("=========================================");
		Query qryPhone = session.createQuery("from Phone");
		List<Phone> phoneList = qryPhone.list();
		System.out.println(phoneList.size());
		for (Phone phone : phoneList) {
			System.out.println(phone.getPhoneId());
			System.out.println(phone.getPhoneNumber());
			//System.out.println(phone.getStudents()!=null?phone.getStudents().size():"0");
		}
		session.close();
	}

}
