package com.example.hibernate.annotation.EnumDemo.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.example.hibernate.annotation.EnumDemo.enums.RoleType;


@Entity
@Table(name = "CUSTOMER_INFO_NEW")
@AttributeOverride(name = "id", column = @Column(name = "CUSTOMER_ID"))
public class Customer extends PersistentEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "USER_ID", nullable = false, length = 20)
	private String userId;
	
	@Column(name = "FIRST_NAME", nullable = false, length = 20)
	private String firstname;
	
	@Column(name = "LAST_NAME", nullable = false, length = 20)
	private String lastname;
	
	@Column(name = "MOB_NUM", nullable = false, length = 20)
	private String mobnum;
	
	@Column(name = "OFFICE_NUM", nullable = true, length = 20)
	private String offphone;
	
	@Column(name="deleted", nullable=false, columnDefinition = "int default 0")
	private long deleted;
	
	@Column(name = "active", nullable=false, columnDefinition = "boolean default true")
	private Boolean active;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	@Type(type = "commonutil.userType.EnumUserType", parameters={
				@Parameter(name="enumClassName", value="HibernateMappingAnnotation.EnumDemo.com.enums.RoleType")})
	private RoleType type;
	
//	@AttributeOverrides({ @AttributeOverride(name = "lastupdateddate", column = @Column(name = "last_update_ddate")) })
	@Embedded
	private AuditInfo auditInfo;
	
	public Customer(){
		
	}
	public Customer(String userId,String firstname,String lastname,String mobnum,String offphone,AuditInfo auditInfo, RoleType type){
		this.offphone=offphone;
		this.mobnum=mobnum;
		this.userId=userId;
		this.firstname=firstname;
		this.lastname=lastname;
		this.auditInfo=auditInfo;
		this.active=Boolean.TRUE;
		this.type=type;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobnum() {
		return mobnum;
	}

	public void setMobnum(String mobnum) {
		this.mobnum = mobnum;
	}

	public String getOffphone() {
		return offphone;
	}

	public void setOffphone(String offphone) {
		this.offphone = offphone;
	}
	/**
	 * @return the auditInfo
	 */
	public AuditInfo getAuditInfo() {
		return auditInfo;
	}
	/**
	 * @param auditInfo the auditInfo to set
	 */
	public void setAuditInfo(AuditInfo auditInfo) {
		this.auditInfo = auditInfo;
	}
	
	/**
	 * @return the deleted
	 */
	public long getDeleted() {
		return deleted;
	}
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(long deleted) {
		this.deleted = deleted;
	}
	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	/**
	 * @return the type
	 */
	public RoleType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(RoleType type) {
		this.type = type;
	}
}
