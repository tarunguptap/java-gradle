package com.hibernate.annotation.OneToManyList.client;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.hibernate.annotation.OneToManyList.model.Department;
import com.hibernate.annotation.OneToManyList.model.Employee;



public class Client1 {

	public static void main(String[] args) 
	{
		try
		{
            ApplicationContext context = new ClassPathXmlApplicationContext(
                    "com/hibernate/annotation/OneToManyList/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			
			Department department = new Department();
	        department.setDepartmentName("Sales");
	 
	        Employee emp1 = new Employee("Nina", "Mayers", "111");
	        Employee emp2 = new Employee("Tony", "Almeida", "222");
	         
	        department.setEmployees(new ArrayList<Employee>());
	        department.getEmployees().add(emp1);
	        department.getEmployees().add(emp2);
	        
	        hibernateTemplate.save(department);
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
