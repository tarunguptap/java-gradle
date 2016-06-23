package com.example.hibernate.annotation.ehcache.main;

import org.hibernate.Session;

import com.example.hibernate.annotation.ehcache.model.DepartmentEntity;
import com.example.hibernate.annotation.ehcache.util.HibernateUtil;

public class StoreData {
    public static void main(String[] args) {
        storeData();
    }

    private static void storeData() {
        /*
         * ApplicationContext context = new ClassPathXmlApplicationContext(
         * "CacheImplementation/comcache/cfg/applicationContext.xml"); SessionFactory sessFactory = (SessionFactory)
         * context.getBean("sessionFactory"); Session session = sessFactory.getCurrentSession();
         */
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        DepartmentEntity department = new DepartmentEntity();
        department.setName("Human Resource3");

        session.save(department);
        session.getTransaction().commit();
    }
}
