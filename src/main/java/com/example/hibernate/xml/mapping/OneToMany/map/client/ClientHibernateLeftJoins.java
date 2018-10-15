package com.example.hibernate.xml.mapping.OneToMany.map.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.mapping.OneToMany.map.model.ManufacturerDevice;
import com.example.hibernate.xml.mapping.OneToMany.map.model.DeviceAttribute;
import com.example.hibernate.xml.mapping.OneToMany.map.enums.DeviceAttributeType;

public class ClientHibernateLeftJoins {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/HibernateMappingXML/OneToManyMapTest/com/cfg/applicationContext.xml");
		SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
		HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
		
		String carrierName = "testCarrier";
		DetachedCriteria dc = DetachedCriteria.forClass(ManufacturerDevice.class);
		//dc.createAlias("modelAttributes", "model", Criteria.LEFT_JOIN);
    dc.add(Restrictions.ilike("model.name",DeviceAttributeType.CARRIER));
    dc.add(Restrictions.ilike("model.value", carrierName));
    
    List list = new ArrayList<ManufacturerDevice>();
		list =hibernateTemplate.findByCriteria(dc);
		
		System.out.println(list.size());
		Iterator<ManufacturerDevice> itr = list.iterator();
		while(itr.hasNext()){
			ManufacturerDevice manufacturerDevice = itr.next();
			System.out.println(manufacturerDevice.getId());
			System.out.println(manufacturerDevice.getDescription());
			System.out.println(manufacturerDevice.getDestination());
			System.out.println(manufacturerDevice.getDeviceNumber());
			System.out.println(manufacturerDevice.getDeviceAttributes());
			Map<DeviceAttributeType,DeviceAttribute> model = manufacturerDevice.getDeviceAttributes();
			System.out.println("total attributes correponding to this model are "+model.size());
			String camera  =manufacturerDevice.getModelAttributeValue(DeviceAttributeType.CAMERA);
			System.out.println("camera is "+camera);
		}
		
	}
}
