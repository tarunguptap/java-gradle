package com.example.hibernate.annotation.softdelete.onetomanyset.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "PHONE_NEW")
@SQLDelete(sql="UPDATE PHONE_NEW SET DELETED = '1' WHERE PHONE_ID = ?  and -1 != ?")
@Where(clause="deleted <> '1'")
public class Phone implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@org.hibernate.annotations.GenericGenerator( name = "increment", strategy = "increment" )
	@Column(name = "PHONE_ID")
	private long phoneId;
	@Version
	@Column(name = "version")
	private Integer version;
	@Column(name = "PHONE_TYPE", nullable = false, length=10)
	private String phoneType;
	@Column(name = "PHONE_NUMBER", nullable = false, length=15)
	private String phoneNumber;
	@Column(name = "DELETED", nullable = false, length=1)
	private char deleted;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STUDENT_ID", nullable = false)
	private Student student;

	public Phone() {
	}

	public Phone(String phoneType, String phoneNumber, Student student) {
		this.phoneType = phoneType;
		this.phoneNumber = phoneNumber;
		this.student=student;
		this.deleted='0';
	}
	
	
	public long getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}

	
	public String getPhoneType() {
		return this.phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the deleted
	 */
	public char getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

}
