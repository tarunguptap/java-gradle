package com.example.hibernate.annotation.mapping.OneToMany.map.model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ref_customer")
public class Customer {
   @Id @GeneratedValue
   @Column(name = "customerid")
   private Integer id;
   @OneToMany(mappedBy="customer")//"customer" is the property defined in order class
   @MapKey(name="number")
   private Map<String,Order> orders;
   
   public Customer(){
	   
   }
   
   public Customer(Map<String,Order> orders){
	   this.orders=orders;
   }
   
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the orders
	 */
	public Map<String, Order> getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Map<String, Order> orders) {
		this.orders = orders;
	}
	public void addOrders(Order order) {
		order.setCustomer(this);
		orders.put(order.getNumber(), order);
	}
}
