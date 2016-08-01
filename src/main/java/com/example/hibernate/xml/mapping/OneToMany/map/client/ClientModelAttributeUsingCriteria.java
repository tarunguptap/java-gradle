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

import com.example.hibernate.xml.mapping.OneToMany.map.model.ModelAttribute;

public class ClientModelAttributeUsingCriteria {


	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{

		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("/HibernateMappingXML/OneToManyMapTest/com/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			DetachedCriteria dc = DetachedCriteria.forClass(ModelAttribute.class,"manu");
	    	dc.setFetchMode("manufacturerModel", FetchMode.JOIN);
	    	List list = new ArrayList();
	    	list =hibernateTemplate.findByCriteria(dc);
			System.out.println(list.size());
			Iterator<ModelAttribute> itr = list.iterator();
			while(itr.hasNext()){
				ModelAttribute modelAttribute = itr.next();
				System.out.println(modelAttribute.getId());
				System.out.println(modelAttribute.getModelAttributeType());
				System.out.println(modelAttribute.getValue());
				System.out.println(modelAttribute.getManufacturerModel());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
