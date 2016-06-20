package com.example.hibernate.annotation.softdelete.onetomanyset.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "STUDENT_NEW")
@SQLDelete(sql="UPDATE STUDENT_NEW SET DELETED = '1' WHERE STUDENT_ID = ? and 0 != ?")
@Where(clause="deleted <> '1'")
public class Student implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID", unique = true, nullable = false)
	private long studentId;
	@Version
	@Column(name = "version")
	private Integer version;
	@Column(name = "STUDENT_NAME", nullable = false, length = 100)
	private String studentName;
	@Column(name = "DELETED", nullable = false, length=1)
	private char deleted;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student")
	@Where(clause="deleted <> '1'")
	private Set<Phone> studentPhoneNumbers = new HashSet<Phone>(0);

	public Student() {
	}

	public Student(String studentName, Set<Phone> studentPhoneNumbers) {
		this.studentName = studentName;
		this.studentPhoneNumbers = studentPhoneNumbers;
		this.deleted='0';
	}

	public Student(String studentName) {
		this.studentName = studentName;
		this.deleted='0';
	}
	
	public long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public Set<Phone> getStudentPhoneNumbers() {
		return this.studentPhoneNumbers;
	}

	public void setStudentPhoneNumbers(Set<Phone> studentPhoneNumbers) {
		this.studentPhoneNumbers = studentPhoneNumbers;
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
	
}
