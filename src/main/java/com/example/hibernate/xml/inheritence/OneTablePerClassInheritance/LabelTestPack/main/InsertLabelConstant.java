package com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.main;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.DatawipeStatus;
import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.LabelConstant;
import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.QualityControlStatus;

public class InsertLabelConstant {

	public static void main(String[] args) 
	{
//		ClientUsingApplicationHibernateCtx
//		it refers the hibernate.cfg.xml from class path
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("OneTablePerClassInheritance/LabelTestPack/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
//			"FAIL_POWER_ON" "FAIL_LCD_WORK" "FAIL_BROKEN_CRACKED" "FAIL_CARRIER" "FAIL_COSMETIC_CONDITION"
//			"FAIL_COLOR" "FAIL_BATTERY_MISSING" "PASS_QUALITY_CONTROL"

			//Note :- we have given the discriminator-value in class tag of hbm so as to insert record using labelconstant.
			LabelConstant labelConstant = new LabelConstant("FAIL_COLOR","Fail Color","Fail Color","Fail Color");
			hibernateTemplate.save(labelConstant);
			
			QualityControlStatus qcs = new QualityControlStatus("FAIL_BATTERY_MISSING","Fail Battery Missing","Fail Battery Missing","Fail Battery Missing");
			hibernateTemplate.save(qcs);
			
			DatawipeStatus ds = new DatawipeStatus("FAIL_CARRIER", "Fail Carrier", "Fail Carrier", "Fail Carrier", true);
			hibernateTemplate.save(ds);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
	}
}
