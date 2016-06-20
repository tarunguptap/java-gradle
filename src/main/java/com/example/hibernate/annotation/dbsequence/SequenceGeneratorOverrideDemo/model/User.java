package com.example.hibernate.annotation.dbsequence.SequenceGeneratorOverrideDemo.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "USER_INFO_SEQ_GENERATOR")
@AttributeOverride(name = "id", column = @Column(name = "userid"))
@GenericGenerator (name = "demo_generator", strategy = "seqhilo", parameters = {@Parameter(name = "max_lo", value = "1"), @Parameter(name = "sequence", value = "user_seq")})
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
