/*
 * @(#)QCHistory.java May 15, 2012
 * 
 * Copyright (c)2005 Flipswap, Inc.
 * U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Flipswap, Inc.
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Flipswap, Inc.
 */

package com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model;
import java.util.Date;

import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.PersistentEntity;


public class QCHistory extends PersistentEntity {
	
	private static final long serialVersionUID = 1L;
	
	private Item item;
	private Date qcDate;
	private String userName;
	private QualityControlStatus qcStatus;
	
	public QualityControlStatus getQcStatus() {
		return qcStatus;
	}
	public void setQcStatus(QualityControlStatus qcStatus) {
		this.qcStatus = qcStatus;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public QCHistory(){
		
	}
	public QCHistory(QualityControlStatus qcStatus,String userName){
			this.qcStatus = qcStatus;
			this.userName = userName;
			this.qcDate = new Date();
		}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
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
