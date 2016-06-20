package com.example.hibernate.annotation.mapping.OneToMany.map.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "ref_order")
public class Order {
   @Id @GeneratedValue
   @Column(name = "orderid")
   private Long id;
   @Column(name = "ordernumber")
   private String number;
   @ManyToOne
   private Customer customer;
   
   public Order(){
	   
   }
   
   public Order(String number){
	   this.number=number;
   }
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
   
}