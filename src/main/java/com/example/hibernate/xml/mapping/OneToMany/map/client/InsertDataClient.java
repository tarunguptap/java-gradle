package com.example.hibernate.xml.mapping.OneToMany.map.client;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.mapping.OneToMany.map.model.ManufacturerDevice;
import com.example.hibernate.xml.mapping.OneToMany.map.model.DeviceAttribute;
import com.example.hibernate.xml.mapping.OneToMany.map.enums.DeviceAttributeType;

public class InsertDataClient {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("HibernateMappingXML/OneToManyMapTest/com/cfg/applicationContext.xml");
		SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
		HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
		
		DeviceAttribute deviceAttribute = new DeviceAttribute(DeviceAttributeType.BLUETOOTH,"Yes");
		Map<DeviceAttributeType, DeviceAttribute> mp = new HashMap<DeviceAttributeType, DeviceAttribute>();
		mp.put(DeviceAttributeType.BLUETOOTH, deviceAttribute);
		ManufacturerDevice epad = new ManufacturerDevice("Bluetooth model","7633",true,mp,"abc",true);
		mp.get(DeviceAttributeType.BLUETOOTH).setManufacturerDevice(epad);
		hibernateTemplate.save(epad);
		
		DeviceAttribute modelAttribute1 = new DeviceAttribute(DeviceAttributeType.CAMERA,"Yes");
		Map<DeviceAttributeType, DeviceAttribute> mp1 = new HashMap<DeviceAttributeType, DeviceAttribute>();
		mp1.put(DeviceAttributeType.CAMERA, modelAttribute1);
		ManufacturerDevice epad1 = new ManufacturerDevice("CAMERA model","7633",true,mp1,"abc",true);
		mp1.get(DeviceAttributeType.CAMERA).setManufacturerDevice(epad1);
		hibernateTemplate.save(epad1);
	}
}
/*
 * ref_manufacurerdevice (manufacturerdeviceid ,version, description,modelnumber,active,recycle,destination);
ref_deviceattribute (deviceattributeid,version,attributename,attributevalue,manufacturerdeviceid)

insert into ref_deviceattribute values(1,0,'Push to talk','No',1);
insert into ref_deviceattribute values(2,0,'Wi-Fi','No',1);
insert into ref_deviceattribute values(3,0,'Bluetooth','Yes',1);
insert into ref_deviceattribute values(4,0,'Battery Life','3.2 hours (192 mins) of Talk time',1);
insert into ref_deviceattribute values(5,0,'Carrier','Sprint Nextel',1);
insert into ref_deviceattribute values(6,0,'Smartphone','No',1);
insert into ref_deviceattribute values(7,0,'Phonebook','600 numbers',1);
insert into ref_deviceattribute values(8,0,'Camera','0.3 megapixels VGA Resolution',1);
insert into ref_deviceattribute values(9,0,'Memory slot','No',1);
insert into ref_deviceattribute values(10,0,'Network','CDMA',1);
insert into ref_deviceattribute values(11,0,'Weight','3.3',1);
insert into ref_deviceattribute values(12,0,'Secondary display','No',1);
insert into ref_deviceattribute values(13,0,'Speakerphone','Yes',1);

insert into ref_manufacturerdevice values(1,0,'Toshiba','Nokia-6233','true','true','test')
 * */