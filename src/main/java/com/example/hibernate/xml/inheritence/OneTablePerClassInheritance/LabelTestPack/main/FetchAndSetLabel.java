package com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.main;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.Device;
import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.LabelConstant;
import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.QCHistory;
import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.QualityCheckStatus;

public class FetchAndSetLabel {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("OneTablePerClassInheritance/LabelTestPack/cfg/applicationContext.xml");
		SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
		HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
		FetchAndSetLabel fetchLabelConstant = new FetchAndSetLabel();
//		fetchLabelConstant.insertLabel();
		QualityCheckStatus status = fetchLabelConstant.findCodeTextByCode("FAIL_BATTERY_CHARGE", QualityCheckStatus.class);
		QCHistory qcHistoryLog = new QCHistory(status,"tarun");
		Device item = new Device(status);
		item.addQCHistoryLog(qcHistoryLog);
		hibernateTemplate.save(item);
	}
	public void insertLabel(){
		ApplicationContext context = new ClassPathXmlApplicationContext("OneTablePerClassInheritance/LabelTestPack/cfg/applicationContext.xml");
		SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
		HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
		QualityCheckStatus qcs = new QualityCheckStatus("FAIL_BATTERY_Charge","Fail Battery Charge","Fail Battery Charge","Fail Battery Charge");
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
