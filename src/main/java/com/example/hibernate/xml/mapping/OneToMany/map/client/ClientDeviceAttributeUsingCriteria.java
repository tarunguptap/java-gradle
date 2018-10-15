package com.example.hibernate.xml.mapping.OneToMany.map.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.mapping.OneToMany.map.model.DeviceAttribute;

public class ClientDeviceAttributeUsingCriteria {


	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{

		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("/HibernateMappingXML/OneToManyMapTest/com/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			DetachedCriteria dc = DetachedCriteria.forClass(DeviceAttribute.class,"manu");
	    	dc.setFetchMode("manufacturerModel", FetchMode.JOIN);
	    	List list = new ArrayList();
	    	list =hibernateTemplate.findByCriteria(dc);
			System.out.println(list.size());
			Iterator<DeviceAttribute> itr = list.iterator();
			while(itr.hasNext()){
				DeviceAttribute deviceAttribute = itr.next();
				System.out.println(deviceAttribute.getId());
				System.out.println(deviceAttribute.getDeviceAttributeType());
				System.out.println(deviceAttribute.getValue());
				System.out.println(deviceAttribute.getManufacturerDevice());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
