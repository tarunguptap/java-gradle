package com.example.hibernate.xml.mapping.OneToMany.map.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.mapping.OneToMany.map.model.ManufacturerModel;
import com.example.hibernate.xml.mapping.OneToMany.map.model.ModelAttribute;
import com.example.hibernate.xml.mapping.OneToMany.map.enums.ModelAttributeType;

public class ClientManufacturerModelUsingCriteria {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("/HibernateMappingXML/OneToManyMapTest/com/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			DetachedCriteria dc = DetachedCriteria.forClass(ManufacturerModel.class,"manu");
			dc.setFetchMode("modelAttributes", FetchMode.JOIN);
			List list = new ArrayList();
			list =hibernateTemplate.findByCriteria(dc);
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
				Map<ModelAttributeType,String> modelTest = manufacturerModel.getModelAttributeTest();
				System.out.println("total attributes correponding to this model are "+modelTest.size());
				String camera  =manufacturerModel.getModelAttributeValue(ModelAttributeType.BLUETOOTH);
				System.out.println("camera is "+camera);
			}
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}
}
