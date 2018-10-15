package com.example.hibernate.xml.mapping.OneToMany.map.client;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.xml.mapping.OneToMany.map.enums.DeviceAttributeType;
import com.example.hibernate.xml.mapping.OneToMany.map.model.ManufacturerDevice;
import com.example.hibernate.xml.mapping.OneToMany.map.model.DeviceAttribute;

public class ClientManufacturerDevice {


	public static void main(String[] args) 
	{
		Configuration cfg = null;
		SessionFactory sessFact = null;
		Session sess =null;
		try
		{
//			cfg = new Configuration().configure(); // This is used when hibernate.cfg.xml is placed in src folder
			
			cfg = new Configuration().configure("HibernateMappingXML/OneToManyMapTest/com/cfg/hibernate.cfg.xml");
			sessFact = cfg.buildSessionFactory();
			sess= sessFact.openSession();
			Transaction tr = sess.beginTransaction();
			List<ManufacturerDevice> list = sess.createQuery("from ManufacturerModel").list();
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
			
			tr.commit();
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}


}
