package com.example.hibernate.annotation.dbsequence.SequenceGeneratorOverrideDemo.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@MappedSuperclass
public abstract class PersistentEntity implements Serializable
{
  private static final long serialVersionUID = 1L;
  /**
   * Currently, we can't extend multiple classes with this class. We have to find a way to override the sequence name for multiple classes
   */
  @Id 
  @GeneratedValue(generator="demo_generator" ,strategy = GenerationType.SEQUENCE)
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
