package com.example.hibernate.xml.mapping.OneToMany.set.example2.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.mapping.OneToMany.set.example2.model.Item;

public class FetchOneToManySetTest {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("HibernateMappingXML/OneToManySetTest/com11/cfg/applicationContext.xml");
		SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
		HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
		List<Item> itemList = getItemList(hibernateTemplate);
		System.out.println(itemList);
	}
	public static List getItemList(HibernateTemplate hibernateTemplate){
		return hibernateTemplate.find("from Item");
	}
}
