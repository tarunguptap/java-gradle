package com.example.hibernate.xml.mapping.OneToMany.map.client;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.xml.mapping.OneToMany.map.enums.ModelAttributeType;
import com.example.hibernate.xml.mapping.OneToMany.map.model.ManufacturerModel;
import com.example.hibernate.xml.mapping.OneToMany.map.model.ModelAttribute;

public class ClientManufacturerModel {


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
			List<ManufacturerModel> list = sess.createQuery("from ManufacturerModel").list();
			System.out.println(list.size());
			Iterator<ManufacturerModel> itr = list.iterator();
			while(itr.hasNext()){
				ManufacturerModel manufacturerModel = itr.next();
				System.out.println(manufacturerModel.getId());
				System.out.println(manufacturerModel.getDescription());
				System.out.println(manufacturerModel.getDestination());
				System.out.println(manufacturerModel.getModelNumber());
				System.out.println(manufacturerModel.getModelAttributes());
				Map<ModelAttributeType,ModelAttribute> model = manufacturerModel.getModelAttributes();
				System.out.println("total attributes correponding to this model are "+model.size());
				String camera  =manufacturerModel.getModelAttributeValue(ModelAttributeType.CAMERA);
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
