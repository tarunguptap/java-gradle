package com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Configurable;

import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.PersistentEntity;
@Configurable
public class Device extends PersistentEntity {

	private static final long serialVersionUID = -6075537353308087951L;

	private QualityCheckStatus status ;
	private Set<QCHistory> qcHistoryLogs =new HashSet<QCHistory>();
	
	public Device() {
	}
	public Device(QualityCheckStatus status) {
		this.status = status;
	}
	
	public QualityCheckStatus getStatus() {
		return status;
	}
	public void setStatus(QualityCheckStatus status) {
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