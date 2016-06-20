package com.example.hibernate.annotation.EmbaddedDemo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public final class AuditInfo implements Serializable {
	/**
     * 
     */
	private static final long serialVersionUID = -4999284044864759054L;
	
	public AuditInfo() {
		this.lastUpdatedDate = new Date();
		this.createdDate = new Date();
	}
	
	@Column(name = "lastupdateddate", nullable = false, length = 50)
	private Date lastUpdatedDate;

	@Column(name = "createddate", nullable = false, length = 50)
	private Date createdDate;

	@ManyToOne
    @JoinColumn(name="updatedby", 
                insertable=false, updatable=false, 
                nullable=false)
	private User updatedBy;

	@ManyToOne
    @JoinColumn(name="createdby", 
                insertable=false, updatable=false, 
                nullable=false)
	private User createdBy;

	public User getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	
	public User getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}
	

	/**
	 * @return Returns the createdDate.
	 * @hibernate.property column="created_date" not-null="true" insert="true"
	 *                     update="false"
	 */
	public Date getCreatedDate() {
		return this.createdDate;
	}

	/**
	 * @param createdDate
	 *            The createdDate to set.
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return Returns the lastUpdatedDate.
	 * @hibernate.property column="last_update_date"
	 */
	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	/**
	 * @param lastUpdatedDate
	 *            The lastUpdatedDate to set.
	 */
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

}
