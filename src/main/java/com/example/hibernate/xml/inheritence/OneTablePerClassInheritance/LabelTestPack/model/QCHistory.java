

package com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model;
import java.util.Date;

import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.PersistentEntity;


public class QCHistory extends PersistentEntity {
	
	private static final long serialVersionUID = 1L;
	
	private Device item;
	private Date qcDate;
	private String userName;
	private QualityCheckStatus qcStatus;
	
	public QualityCheckStatus getQcStatus() {
		return qcStatus;
	}
	public void setQcStatus(QualityCheckStatus qcStatus) {
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
	public QCHistory(QualityCheckStatus qcStatus,String userName){
			this.qcStatus = qcStatus;
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
