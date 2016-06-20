package com.example.hibernate.annotation.inheritence.OneTablePerClassInheritance.main;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.annotation.inheritence.OneTablePerClassInheritance.model.LabelConstant;
import com.example.hibernate.annotation.inheritence.OneTablePerClassInheritance.model.QualityControlStatus;


public class InsertLabelConstant {

	public static void main(String[] args) 
	{
//		ClientUsingApplicationHibernateCtx
//		it refers the hibernate.cfg.xml from class path
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("com/example/hibernate/annotation/inheritence/OneTablePerClassInheritance/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
//			"FAIL_POWER_ON" "FAIL_LCD_WORK" "FAIL_BROKEN_CRACKED" "FAIL_CARRIER" "FAIL_COSMETIC_CONDITION"
//			"FAIL_COLOR" "FAIL_BATTERY_MISSING" "PASS_QUALITY_CONTROL"

			//Note :- we have given the discriminator-value in class tag of hbm so as to insert record using labelconstant.
			LabelConstant labelConstant = new LabelConstant("FAIL_LCD_WORK","Fail LCD work","Fail LCD work");
			hibernateTemplate.save(labelConstant);
			
			QualityControlStatus qcs = new QualityControlStatus("FAIL_CARRIER","Fail Carrier","Fail Carrier");
			hibernateTemplate.save(qcs);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}
}
