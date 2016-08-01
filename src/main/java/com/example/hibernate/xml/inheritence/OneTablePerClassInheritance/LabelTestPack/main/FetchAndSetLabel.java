package com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.main;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.Item;
import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.LabelConstant;
import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.QCHistory;
import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.QualityControlStatus;

public class FetchAndSetLabel {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("OneTablePerClassInheritance/LabelTestPack/cfg/applicationContext.xml");
		SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
		HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
		FetchAndSetLabel fetchLabelConstant = new FetchAndSetLabel();
//		fetchLabelConstant.insertLabel();
		QualityControlStatus status = fetchLabelConstant.findCodeTextByCode("FAIL_BATTERY_MISSING", QualityControlStatus.class);
		QCHistory qcHistoryLog = new QCHistory(status,"tarun");
		Item item = new Item(status);
		item.addQCHistoryLog(qcHistoryLog);
		hibernateTemplate.save(item);
	}
	public void insertLabel(){
		ApplicationContext context = new ClassPathXmlApplicationContext("OneTablePerClassInheritance/LabelTestPack/cfg/applicationContext.xml");
		SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
		HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
		QualityControlStatus qcs = new QualityControlStatus("FAIL_BATTERY_MISSING","Fail Battery Missing","Fail Battery Missing","Fail Battery Missing");
		hibernateTemplate.save(qcs);
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
