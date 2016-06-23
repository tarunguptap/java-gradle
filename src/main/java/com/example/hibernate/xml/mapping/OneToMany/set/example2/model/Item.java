package com.example.hibernate.xml.mapping.OneToMany.set.example2.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Configurable;

import com.example.hibernate.xml.mapping.OneToMany.set.example2.model.PersistentEntity;
@Configurable
public class Item extends PersistentEntity {

	private static final long serialVersionUID = -6075537353308087951L;

	
	private Set<QCHistory> qcHistoryLogs =new HashSet<QCHistory>();
	
	public Item() {
	}
	public Item(Set<QCHistory> qcHistoryLogs) {
		this.qcHistoryLogs = qcHistoryLogs;
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
	
	public void addQCHistoryLog(Set<QCHistory> qcHistoryLogSet) {
		for (QCHistory qcHistoryLog : qcHistoryLogSet) {
			qcHistoryLog.setItem(this);
			this.qcHistoryLogs.add(qcHistoryLog);
		}
	}
}