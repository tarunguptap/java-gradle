package com.example.hibernate.xml.mapping.OneToMany.set.example1.main;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.mapping.OneToMany.set.example1.model.Contact;
import com.example.hibernate.xml.mapping.OneToMany.set.example1.model.Employee;
import com.example.hibernate.xml.mapping.OneToMany.set.example1.model.EmployeeAddress;
import com.example.hibernate.xml.mapping.OneToMany.set.example1.model.Name;

public class ClientUsingApplicationHibernateCtx1 {

	public static void main(String[] args) 
	{
//		it refers the hibernate.cfg.xml from class path
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("HibernateMappingXML/OneToManySetTest/com/util/applicationContext1.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			
			Name name = new Name("tarun","kumar","gupta");
			Contact contact = new Contact(name, "Dona-Pola", "S.K.Tarun");
			EmployeeAddress employeeAddress =new EmployeeAddress("sipcot park","chennai",contact);
			Employee emp = new Employee("Ajay");
			emp.addEmpAddr(employeeAddress);
			hibernateTemplate.save(emp);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
