package com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.main;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.DatawipeStatus;
import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.LabelConstant;
import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.QualityControlStatus;

public class FetchLabelConstant {

	public static void main(String[] args) 
	{
//		ClientUsingApplicationHibernateCtx
//		it refers the hibernate.cfg.xml from class path
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("HibernateMappingXML/OneTablePerClassInheritance/LabelTestPack/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
			FetchLabelConstant fetchLabelConstant = new FetchLabelConstant();
			QualityControlStatus status = fetchLabelConstant.findCodeTextByCode("FAIL_BATTERY_MISSING", QualityControlStatus.class);
			System.out.println(status.getCode());
			System.out.println(status.getText());
			System.out.println(status.getDiscriminatorValue());
			
			System.out.println("\n===============================\n");
			
			DatawipeStatus datawipeStatus = fetchLabelConstant.findCodeTextByCode("FAIL_CARRIER", DatawipeStatus.class);
			System.out.println(datawipeStatus.getCode());
			System.out.println(datawipeStatus.getText());
			System.out.println(datawipeStatus.getDiscriminatorValue());
			System.out.println(datawipeStatus.getDefaultLabel());
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}
	 public <T extends LabelConstant> T findCodeTextByCode(String code,
	            Class<T> codeTextTypeClass) throws DataAccessException {
		 ApplicationContext context = new ClassPathXmlApplicationContext("OneTablePerClassInheritance/LabelTestPack/cfg/applicationContext.xml");
			SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
			HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
	    	try{
	    		DetachedCriteria dc = DetachedCriteria.forClass(codeTextTypeClass).add(
	                    Restrictions.eq("code", code));
	    		return (T) DataAccessUtils.uniqueResult(hibernateTemplate
	                    .findByCriteria(dc));
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		return null;
	    	}
	        
	    }
}
