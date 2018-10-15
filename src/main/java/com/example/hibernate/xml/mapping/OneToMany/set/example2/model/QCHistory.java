package com.example.hibernate.xml.mapping.OneToMany.set.example2.model;
import java.util.Date;

import com.example.hibernate.xml.mapping.OneToMany.set.example2.model.PersistentEntity;


public class QCHistory extends PersistentEntity {
	
	private static final long serialVersionUID = 1L;
	
	private Device item;
	private Date qcDate;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public QCHistory(){
		
	}
	public QCHistory(String userName){
			this.userName = userName;
			this.qcDate = new Date();
		}

	/**
	 * @return the item
	 */
	public Device getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Device item) {
		this.item = item;
	}

	/**
	 * @return the qcStatus
	 */
	public Date getQcDate() {
		return qcDate;
	}

	/**
	 * @param qcDate the qcDate to set
	 */
	public void setQcDate(Date qcDate) {
		this.qcDate = qcDate;
	}
}
