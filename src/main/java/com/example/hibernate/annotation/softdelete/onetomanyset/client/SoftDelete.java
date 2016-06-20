package com.example.hibernate.annotation.softdelete.onetomanyset.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.annotation.softdelete.onetomanyset.model.Phone;
import com.example.hibernate.annotation.softdelete.onetomanyset.model.Student;

public class SoftDelete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/example/hibernate/annotation/softdelete/onetomanyset/cfg/applicationContext.xml");
		SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
		HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
		Session session =sessFactory.openSession();
		Student student = (Student)session.load(Student.class, 1L);
		hibernateTemplate.deleteAll(student.getStudentPhoneNumbers());
//		Set<Phone> previuosPhones =  new HashSet<Phone>();
//		previuosPhones = student.getStudentPhoneNumbers();
//		previuosPhones.clear();
		Set<Phone> phoneNumbers = new HashSet<Phone>();
		phoneNumbers.add(new Phone("house_num", "32354353",student));
		phoneNumbers.add(new Phone("mobile_num", "9889343423",student));
		phoneNumbers.add(new Phone("office_num", "12151313",student));
		phoneNumbers.add(new Phone("hut_num", "1889311111",student));

		student.setStudentPhoneNumbers(phoneNumbers);
		
		hibernateTemplate.save(student);
		session.close();
	}

}
