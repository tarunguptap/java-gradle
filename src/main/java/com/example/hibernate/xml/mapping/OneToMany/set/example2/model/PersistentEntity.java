package com.example.hibernate.xml.mapping.OneToMany.set.example2.model;

import java.io.Serializable;

public abstract class PersistentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public Long id = new Long(-1);

	private Integer version;

	/**
	 * @return Returns the version.
	 * @hibernate.version column="VERSION" unsaved-value="null"
	 * 
	 */
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * @param version
	 *            The version to set.
	 */
	void setVersion(Integer versionID) {
		this.version = versionID;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public boolean isPersistent() {
		return version != null;
	}
}