package com.example.hibernate.xml.mapping.OneToMany.map.client;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.mapping.OneToMany.map.model.ManufacturerModel;
import com.example.hibernate.xml.mapping.OneToMany.map.model.ModelAttribute;
import com.example.hibernate.xml.mapping.OneToMany.map.enums.ModelAttributeType;

public class InsertDataClient {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("HibernateMappingXML/OneToManyMapTest/com/cfg/applicationContext.xml");
		SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
		HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
		
		ModelAttribute modelAttribute = new ModelAttribute(ModelAttributeType.BLUETOOTH,"Yes");
		Map<ModelAttributeType, ModelAttribute> mp = new HashMap<ModelAttributeType, ModelAttribute>();
		mp.put(ModelAttributeType.BLUETOOTH, modelAttribute);
		ManufacturerModel epad = new ManufacturerModel("Bluetooth model","7633",true,mp,"abc",true);
		mp.get(ModelAttributeType.BLUETOOTH).setManufacturerModel(epad);
		hibernateTemplate.save(epad);
		
		ModelAttribute modelAttribute1 = new ModelAttribute(ModelAttributeType.CAMERA,"Yes");
		Map<ModelAttributeType, ModelAttribute> mp1 = new HashMap<ModelAttributeType, ModelAttribute>();
		mp1.put(ModelAttributeType.CAMERA, modelAttribute1);
		ManufacturerModel epad1 = new ManufacturerModel("CAMERA model","7633",true,mp1,"abc",true);
		mp1.get(ModelAttributeType.CAMERA).setManufacturerModel(epad1);
		hibernateTemplate.save(epad1);
	}
}
/*
 * ref_manufacurermodel (manufacturermodelid ,version, description,modelnumber,active,recycle,destination);
ref_modelattribute (modelattributeid,version,attributename,attributevalue,manufacturermodelid)

insert into ref_modelattribute values(1,0,'Push to talk','No',1);
insert into ref_modelattribute values(2,0,'Wi-Fi','No',1);
insert into ref_modelattribute values(3,0,'Bluetooth','Yes',1);
insert into ref_modelattribute values(4,0,'Battery Life','3.2 hours (192 mins) of Talk time',1);
insert into ref_modelattribute values(5,0,'Carrier','Sprint Nextel',1);
insert into ref_modelattribute values(6,0,'Smartphone','No',1);
insert into ref_modelattribute values(7,0,'Phonebook','600 numbers',1);
insert into ref_modelattribute values(8,0,'Camera','0.3 megapixels VGA Resolution',1);
insert into ref_modelattribute values(9,0,'Memory slot','No',1);
insert into ref_modelattribute values(10,0,'Network','CDMA',1);
insert into ref_modelattribute values(11,0,'Weight','3.3',1);
insert into ref_modelattribute values(12,0,'Secondary display','No',1);
insert into ref_modelattribute values(13,0,'Speakerphone','Yes',1);

insert into ref_manufacturermodel values(1,0,'Toshiba','Nokia-6233','true','true','test')
 * */