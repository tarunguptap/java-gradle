package com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Configurable;

import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.PersistentEntity;
@Configurable
public class Item extends PersistentEntity {

	private static final long serialVersionUID = -6075537353308087951L;

	private QualityControlStatus status ;
	private Set<QCHistory> qcHistoryLogs =new HashSet<QCHistory>();
	
	public Item() {
	}
	public Item(QualityControlStatus status) {
		this.status = status;
	}
	
	public QualityControlStatus getStatus() {
		return status;
	}
	public void setStatus(QualityControlStatus status) {
		this.status = status;
	}
	public Set<QCHistory> getQcHistoryLogs() {
		return qcHistoryLogs;
	}

	public void setQcHistoryLogs(Set<QCHistory> qcHistoryLogs) {
		this.qcHistoryLogs = qcHistoryLogs;
	}
	
	public void addQCHistoryLog(QCHistory qcHistoryLog) {
		qcHistoryLog.setItem(this);
		this.qcHistoryLogs.add(qcHistoryLog);
	}
	
}