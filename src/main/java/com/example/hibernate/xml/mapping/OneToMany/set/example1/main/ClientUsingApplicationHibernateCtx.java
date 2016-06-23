package com.example.hibernate.xml.mapping.OneToMany.set.example1.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.mapping.OneToMany.set.example1.model.Employee;
import com.example.hibernate.xml.mapping.OneToMany.set.example1.model.EmployeeAddress;
import com.example.hibernate.xml.mapping.OneToMany.set.example1.model.Name;

public class ClientUsingApplicationHibernateCtx {

	public static void main(String[] args) 
	{
//		it refers the hibernate.cfg.xml from class path
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("HibernateMappingXML/OneToManySetTest/com/util/applicationContext1.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			
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
			
			Name name = new Name();
			
			
			Set eAdrList = new HashSet();
			eAdrList.add(ldhadr);
			eAdrList.add(ldhadr);
			eAdrList.add(chenadr1);
			eAdrList.add(chenadr2);
			
			hibernateTemplate.save(emp);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
