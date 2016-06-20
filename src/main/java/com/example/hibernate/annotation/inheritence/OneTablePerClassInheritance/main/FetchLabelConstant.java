package com.example.hibernate.annotation.inheritence.OneTablePerClassInheritance.main;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.annotation.inheritence.OneTablePerClassInheritance.model.LabelConstant;
import com.example.hibernate.annotation.inheritence.OneTablePerClassInheritance.model.QualityControlStatus;


public class FetchLabelConstant {

	public static void main(String[] args) 
	{
//		ClientUsingApplicationHibernateCtx
//		it refers the hibernate.cfg.xml from class path
		try
		{
			FetchLabelConstant fetchLabelConstant = new FetchLabelConstant();
			QualityControlStatus status = fetchLabelConstant.findCodeTextByCode("FAIL_LCD_WORK", QualityControlStatus.class);
			System.out.println(status.getCode());
			System.out.println(status.getText());
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		
	}
	 public <T extends LabelConstant> T findCodeTextByCode(String code,
	            Class<T> codeTextTypeClass) throws DataAccessException {
		 ApplicationContext context = new ClassPathXmlApplicationContext("com/example/hibernate/annotation/inheritence/OneTablePerClassInheritance/cfg/applicationContext.xml");
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
