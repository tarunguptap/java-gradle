package com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.main;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.Device;
import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.QCHistory;

public class DeviceQCHistoryInsert {

	public static void main(String[] args) 
	{
//		it refers the hibernate.cfg.xml from class path
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("HibernateMappingXML/OneTablePerClassInheritance/LabelTestPack/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			
//			QCHistory qcHistoryLog = new QCHistory("tarun");
			
//			Device device = new Device();
//			device.addQCHistoryLog(qcHistoryLog);
			
//			hibernateTemplate.save(item);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
