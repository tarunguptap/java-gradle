package com.example.hibernate.xml.inheritence.OneTablePerClassInheritanceTest.main;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.inheritence.OneTablePerClassInheritanceTest.model.LabelConstant;
import com.example.hibernate.xml.inheritence.OneTablePerClassInheritanceTest.model.QualityCheckStatus;


public class InsertLabelConstant {

	public static void main(String[] args) 
	{
//		ClientUsingApplicationHibernateCtx
//		it refers the hibernate.cfg.xml from class path
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("HibernateMappingXML/OneTablePerClassInheritanceTest/com/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			//Note :- we have given the discriminator-value in class tag of hbm so as to insert record using labelconstant.
			LabelConstant labelConstant = new LabelConstant("FAIL_COLOR","Fail Color","Fail Color","Fail Color");
			hibernateTemplate.save(labelConstant);
			
			QualityCheckStatus qcs = new QualityCheckStatus("FAIL_BATTERY_CHARGE","Fail Battery Charge","Fail Battery Charge","Fail Battery Charge");
			hibernateTemplate.save(qcs);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
	}
}
