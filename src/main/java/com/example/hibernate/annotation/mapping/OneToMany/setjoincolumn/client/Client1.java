package com.example.hibernate.annotation.mapping.OneToMany.setjoincolumn.client;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.annotation.mapping.OneToMany.setjoincolumn.model.Department;
import com.example.hibernate.annotation.mapping.OneToMany.setjoincolumn.model.Employee;



public class Client1 {

	public static void main(String[] args) 
	{
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("com/example/hibernate/annotation/mapping/OneToMany/setjoincolumn/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			
			Department department = new Department();
	        department.setDepartmentName("Sales");
	        hibernateTemplate.save(department);
	        Employee emp1 = new Employee("Nina", "Mayers", "111",department);
	        Employee emp2 = new Employee("Tony", "Almeida", "222",department);
	 
			hibernateTemplate.save(emp1);
			hibernateTemplate.save(emp2);
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
