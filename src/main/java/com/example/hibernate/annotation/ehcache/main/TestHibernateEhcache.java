package com.example.hibernate.annotation.ehcache.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.annotation.ehcache.model.DepartmentEntity;
import com.example.hibernate.annotation.ehcache.util.HibernateUtil;

public class TestHibernateEhcache {
    public static void main(String[] args) {

        try {
            // Open the hibernate session
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // fetch the department entity from database first time
            DepartmentEntity department = (DepartmentEntity) session.load(DepartmentEntity.class, new Integer(1));
            System.out.println(department.getName());

            // fetch the department entity again; Fetched from first level cache
            department = (DepartmentEntity) session.load(DepartmentEntity.class, new Integer(1));
            System.out.println(department.getName());

            // Let's close the session
            session.getTransaction().commit();
            session.close();

            // Try to get department in new session
            Session anotherSession = HibernateUtil.getSessionFactory().openSession();
            anotherSession.beginTransaction();

            // Here entity is already in second level cache so no database query will be hit
            department = (DepartmentEntity) anotherSession.load(DepartmentEntity.class, new Integer(1));
            System.out.println(department.getName());

            anotherSession.getTransaction().commit();
            anotherSession.close();

            SessionFactory sessFactory = HibernateUtil.getSessionFactory();
            HibernateTemplate hibernateTemplate = new HibernateTemplate(sessFactory);
            department = (DepartmentEntity) hibernateTemplate.load(DepartmentEntity.class, new Integer(1));
            System.out.println(department.getName());
        } finally {
            System.out.println(HibernateUtil.getSessionFactory().getStatistics().getEntityFetchCount()); // Prints 1
            System.out.println(HibernateUtil.getSessionFactory().getStatistics().getSecondLevelCacheHitCount()); // Prints
                                                                                                                 // 1

            HibernateUtil.shutdown();
        }
    }
}
