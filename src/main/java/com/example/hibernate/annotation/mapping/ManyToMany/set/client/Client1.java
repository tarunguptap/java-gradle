package com.example.hibernate.annotation.mapping.ManyToMany.set.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.annotation.mapping.ManyToMany.set.model.Employee;
import com.example.hibernate.annotation.mapping.ManyToMany.set.model.EmployeeAddress;

public class Client1 {

	public static void main(String[] args) 
	{
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("com/example/hibernate/annotation/mapping/ManyToMany/set/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			
			EmployeeAddress chenadr1 =new EmployeeAddress();
			chenadr1.setAddress("sipcot park");
			chenadr1.setCity("chennai");
			
			EmployeeAddress chenadr2 =new EmployeeAddress();
			chenadr2.setAddress("ramaniyam apartments");
			chenadr2.setCity("chennai");
			
			Set<EmployeeAddress> eAdrList = new HashSet<EmployeeAddress>();
			eAdrList.add(chenadr1);
			eAdrList.add(chenadr2);
			
			Employee emp = new Employee();
			emp.setName("tarun");
			emp.setEmpaddr(eAdrList);
			
			Employee emp1 = new Employee();
			emp1.setName("varun");
			emp1.setEmpaddr(eAdrList);
			
			hibernateTemplate.save(emp);
			hibernateTemplate.save(emp1);
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
