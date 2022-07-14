package org.vtop.CourseRegistration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RgrArrRegistrationModelPK  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="SEMCODE")
	private String semCode;
	
	@Column(name="REGNO")
	private String regno;
	
	@Column(name="COURSECODE")
	private String courseCode;
	
	@Column(name="COURSETYPE")
	private String 	courseType;

	public String getSemCode() {
		return semCode;
	}

	public void setSemCode(String semCode) {
		this.semCode = semCode;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseCode == null) ? 0 : courseCode.hashCode());
		result = prime * result + ((courseType == null) ? 0 : courseType.hashCode());
		result = prime * result + ((regno == null) ? 0 : regno.hashCode());
		result = prime * result + ((semCode == null) ? 0 : semCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RgrArrRegistrationModelPK other = (RgrArrRegistrationModelPK) obj;
		if (courseCode == null) {
			if (other.courseCode != null)
				return false;
		} else if (!courseCode.equals(other.courseCode))
			return false;
		if (courseType == null) {
			if (other.courseType != null)
				return false;
		} else if (!courseType.equals(other.courseType))
			return false;
		if (regno == null) {
			if (other.regno != null)
				return false;
		} else if (!regno.equals(other.regno))
			return false;
		if (semCode == null) {
			if (other.semCode != null)
				return false;
		} else if (!semCode.equals(other.semCode))
			return false;
		return true;
	}
	
		
}
