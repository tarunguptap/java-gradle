package com.example.hibernate.xml.mapping.OneToMany.map.client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.hibernate.xml.mapping.OneToMany.map.model.DeviceAttribute;

public class ClientDeviceAttributeUsingSession {



	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		Session sess =null;
		try {
//			cfg = new Configuration().configure(); // This is used when hibernate.cfg.xml is placed in src folder
//			Otherwise we use as below
//			cfg = new Configuration().configure("OneToManyMapTest/com/cfg/hibernate.cfg.xml");
			ApplicationContext context = new ClassPathXmlApplicationContext("/HibernateMappingXML/OneToManyMapTest/com/cfg/applicationContext.xml");
			SessionFactory sessFact=(SessionFactory)context.getBean("sessionFactory");
			sess= sessFact.openSession();
	    	Query qry = sess.createQuery("from ModelAttribute");
	    	List<DeviceAttribute> list = qry.list();
//	    	If session is closed here then it will give lazy initializtion exception while getting the manufacuring model 
//	    	sess.close();
			System.out.println(list.size());
			Iterator<DeviceAttribute> itr = list.iterator();
			while(itr.hasNext()){
				DeviceAttribute deviceAttribute = itr.next();
				System.out.println(deviceAttribute.getId());
				System.out.println(deviceAttribute.getDeviceAttributeType());
				System.out.println(deviceAttribute.getValue());
				System.out.println(deviceAttribute.getManufacturerDevice());
			}
			sess.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
	}



}
