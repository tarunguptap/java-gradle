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

import com.example.hibernate.xml.mapping.OneToMany.map.model.ManufacturerModel;
import com.example.hibernate.xml.mapping.OneToMany.map.model.ModelAttribute;
import com.example.hibernate.xml.mapping.OneToMany.map.enums.ModelAttributeType;

public class ClientHibernateLeftJoins {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/HibernateMappingXML/OneToManyMapTest/com/cfg/applicationContext.xml");
		SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
		HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
		
		String carrierName = "att";
		DetachedCriteria dc = DetachedCriteria.forClass(ManufacturerModel.class);
		//dc.createAlias("modelAttributes", "model", Criteria.LEFT_JOIN);
    dc.add(Restrictions.ilike("model.name",ModelAttributeType.CARRIER));
    dc.add(Restrictions.ilike("model.value", carrierName));
    
    List list = new ArrayList<ManufacturerModel>();
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
			String camera  =manufacturerModel.getModelAttributeValue(ModelAttributeType.CAMERA);
			System.out.println("camera is "+camera);
		}
		
	}
}
