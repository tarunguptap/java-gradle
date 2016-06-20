package com.example.hibernate.annotation.mapping.OneToMany.map.client;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.hibernate.annotation.mapping.OneToMany.map.model.Customer;
import com.example.hibernate.annotation.mapping.OneToMany.map.model.Order;

public class Client {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/example/hibernate/annotation/mapping/OneToMany/map/cfg/applicationContext.xml");
		SessionFactory sessFactory=(SessionFactory)context.getBean("sessionFactory");
		HibernateTemplate hibernateTemplate=new HibernateTemplate(sessFactory);
		
		Order order = new Order("111");
		Map<String,Order> mp = new HashMap<String, Order>();
		mp.put("OIL", order);
		Customer customer = new Customer(mp);
		customer.addOrders(order);
//		mp.get("OIL").setCustomer(customer);
		hibernateTemplate.save(customer);
		
	}
}
