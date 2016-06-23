package com.example.hibernate.xml.mapping.OneToMany.set.example1.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.hibernate.xml.mapping.OneToMany.set.example1.model.Employee;
import com.example.hibernate.xml.mapping.OneToMany.set.example1.model.EmployeeAddress;

public class ClientUsingApplicationSessionCtx {

	public static void main(String[] args) 
	{
//		it refers the hibernate.cfg.xml from class path
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("HibernateMappingXML/OneToManySetTest/com/util/applicationContext1.xml");
			SessionFactory sessFact=(SessionFactory)context.getBean("sessionFactory");
			Session sess = sessFact.openSession();
			
			Employee emp = new Employee();
			emp.setName("tarun");
			
			EmployeeAddress chenadr1 =new EmployeeAddress();
			chenadr1.setAddress("sipcot park");
			chenadr1.setCity("chennai");
			
			EmployeeAddress chenadr2 =new EmployeeAddress();
			chenadr2.setAddress("ramaniyam apartments");
			chenadr2.setCity("chennai");
			
			EmployeeAddress ldhadr = new EmployeeAddress();
			ldhadr.setAddress("naulakha colony");
			ldhadr.setCity("ludhiana");
			
			Set eAdrList = new HashSet();
			eAdrList.add(ldhadr);
			eAdrList.add(ldhadr);
			eAdrList.add(chenadr1);
			eAdrList.add(chenadr2);
			
			emp.setEmpaddr(eAdrList);
			
			Transaction tr = sess.beginTransaction();
			sess.save(emp);
			tr.commit();
			sess.close();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
	}
}
