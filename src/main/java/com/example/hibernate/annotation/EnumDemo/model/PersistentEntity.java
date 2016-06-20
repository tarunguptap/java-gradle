package com.example.hibernate.annotation.EnumDemo.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class PersistentEntity implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  @Id 
  @GeneratedValue
  private Long id = new Long(-1L);
  @Version
  private Integer version;
  
  public Integer getVersion()
  {
    return this.version;
  }
  
  void setVersion(Integer versionID)
  {
    this.version = versionID;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
  
  public Long getId()
  {
    return this.id;
  }
  
  public boolean isPersistent()
  {
    return this.version != null;
  }
}
