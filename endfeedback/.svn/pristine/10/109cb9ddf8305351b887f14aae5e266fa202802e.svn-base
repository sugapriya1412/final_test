package org.vtop.CourseRegistration.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGISTRATION_CHECK", schema="academics")
public class RegistrationCheckModel  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="REGNO")
	private String regno;

	@Column(name="COURSECODE")
	private String courseCode;
	
	@Column(name="COURSETYPE")
	private String courseType;
	
	@Column(name="CRSOPTCODE")
	private String crsOptCode;

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getCrsOptCode() {
		return crsOptCode;
	}

	public void setCrsOptCode(String crsOptCode) {
		this.crsOptCode = crsOptCode;
	}

	@Override
	public String toString() {
		return "RegistrationCheckModel [regno=" + regno + ", courseCode=" + courseCode + ", courseType=" + courseType
				+ ", crsOptCode=" + crsOptCode + "]";
	}

	
	
}


