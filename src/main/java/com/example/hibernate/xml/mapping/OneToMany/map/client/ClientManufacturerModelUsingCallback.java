package com.example.hibernate.xml.mapping.OneToMany.map.client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.mapping.OneToMany.map.model.ManufacturerModel;
import com.example.hibernate.xml.mapping.OneToMany.map.model.ModelAttribute;
import com.example.hibernate.xml.mapping.OneToMany.map.enums.ModelAttributeType;

public class ClientManufacturerModelUsingCallback {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		try {
//			This is used when xml is placed in src folder
//			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			ApplicationContext context = new ClassPathXmlApplicationContext("/HibernateMappingXML/OneToManyMapTest/com/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
	    	List<ManufacturerModel> list = new ArrayList<ManufacturerModel>();
	    	list = (List<ManufacturerModel>)hibernateTemplate.execute(
					new HibernateCallback() {
						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Criteria criteria = session.createCriteria(
	                                ManufacturerModel.class, "customer");
							criteria.setFetchMode("modelAttributes", FetchMode.JOIN);
							List results = criteria.list();
							return results;
						}
					});
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
