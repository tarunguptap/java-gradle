package com.example.hibernate.xml.mapping.OneToMany.set.example2.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.mapping.OneToMany.set.example2.model.Device;

public class FetchOneToManySetTest {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("HibernateMappingXML/OneToManySetTest/com11/cfg/applicationContext.xml");
		SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
		HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
		List<Device> deviceList = getDeviceList(hibernateTemplate);
		System.out.println(deviceList);
	}
	public static List getDeviceList(HibernateTemplate hibernateTemplate){
		return hibernateTemplate.find("from Device");
	}
}
