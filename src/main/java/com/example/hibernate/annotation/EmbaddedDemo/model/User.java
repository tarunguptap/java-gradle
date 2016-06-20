package com.example.hibernate.annotation.EmbaddedDemo.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER_INFO_NEW")
@AttributeOverride(name = "id", column = @Column(name = "userid"))
public class User extends PersistentEntity {
	
	private static final long serialVersionUID = 1L;
	public User() {
		
	}
	
	public User(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "username", nullable = false, length = 20)
	private String userName;
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
