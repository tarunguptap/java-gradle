package com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.main;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.WipeoutStatus;
import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.LabelConstant;
import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.QualityCheckStatus;

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
			//Note :- we have given the discriminator-value in class tag of hbm so as to insert record using labelconstant.
			LabelConstant labelConstant = new LabelConstant("FAIL_COLOR","Fail Color","Fail Color","Fail Color");
			hibernateTemplate.save(labelConstant);
			
			QualityCheckStatus qcs = new QualityCheckStatus("FAIL_BATTERY_CHARGE","Fail Battery Charge","Fail Battery Charge","Fail Battery Charge");
			hibernateTemplate.save(qcs);
			
			WipeoutStatus ds = new WipeoutStatus("FAIL_CARRIER", "Fail Carrier", "Fail Carrier", "Fail Carrier", true);
			hibernateTemplate.save(ds);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
	}
}
