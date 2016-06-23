package com.example.hibernate.xml.mapping.OneToMany.set.example2.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.mapping.OneToMany.set.example2.model.Item;
import com.example.hibernate.xml.mapping.OneToMany.set.example2.model.QCHistory;

public class OneToManySetTest {

	public static void main(String[] args) 
	{
//		it refers the hibernate.cfg.xml from class path
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("HibernateMappingXML/OneToManySetTest/com11/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			
			QCHistory qcHistoryLog = new QCHistory("tarun");
			
			Item item = new Item();
			item.addQCHistoryLog(qcHistoryLog);
			
			Set<QCHistory> qcHistoryLogSet = new HashSet<QCHistory>();
			qcHistoryLogSet.add(new QCHistory("himanshu"));
			qcHistoryLogSet.add(new QCHistory("rohit"));
			qcHistoryLogSet.add(new QCHistory("gopal"));
			qcHistoryLogSet.add(new QCHistory("arun"));
			item.addQCHistoryLog(qcHistoryLogSet);
			
			
			hibernateTemplate.saveOrUpdate(item);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
