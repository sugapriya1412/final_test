package org.vtop.CourseRegistration.model;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RGRARR_REGISTRATION", schema="academics")	
public class RgrArrRegistrationModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    private RgrArrRegistrationModelPK rgrArrRegistrationModelPK ;
		
	@Column(name="COURSETITLE")
	private String courseTitle;
		
	@Column(name="REGSTATUS")
	private Long regStatus;
	
	@Column(name="USERID")
	private String userID;
	
	@Column(name="TIMESTAMP")
	private String timeStamp;
	
	@Column(name="IPADDRESS")
	private String ipAddress;
	
	@Column(name="SUBCODE")
	private String subCode;
	
	@Column(name="CREDITS")
	private Long credits;
	
	@Column(name="FP_REFNO")
	private Long fpRefno;
	
	@Column(name="CLASSNBR")
	private Long classnbr;
	
	@Column(name="EXAMDATE")
	private Date examDate;
	
	@Column(name="EXAMTIME")
	private String examTime;

	public RgrArrRegistrationModelPK getRgrArrRegistrationModelPK() {
		return rgrArrRegistrationModelPK;
	}

	public void setRgrArrRegistrationModelPK(RgrArrRegistrationModelPK rgrArrRegistrationModelPK) {
		this.rgrArrRegistrationModelPK = rgrArrRegistrationModelPK;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public Long getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(Long regStatus) {
		this.regStatus = regStatus;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public Long getCredits() {
		return credits;
	}

	public void setCredits(Long credits) {
		this.credits = credits;
	}

	public Long getFpRefno() {
		return fpRefno;
	}

	public void setFpRefno(Long fpRefno) {
		this.fpRefno = fpRefno;
	}

	public Long getClassnbr() {
		return classnbr;
	}

	public void setClassnbr(Long classnbr) {
		this.classnbr = classnbr;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rgrArrRegistrationModelPK == null) ? 0 : rgrArrRegistrationModelPK.hashCode());
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
		RgrArrRegistrationModel other = (RgrArrRegistrationModel) obj;
		if (rgrArrRegistrationModelPK == null) {
			if (other.rgrArrRegistrationModelPK != null)
				return false;
		} else if (!rgrArrRegistrationModelPK.equals(other.rgrArrRegistrationModelPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RgrArrRegistrationModel [rgrArrRegistrationModelPK=" + rgrArrRegistrationModelPK + ", courseTitle="
				+ courseTitle + ", regStatus=" + regStatus + ", userID=" + userID + ", timeStamp=" + timeStamp
				+ ", ipAddress=" + ipAddress + ", subCode=" + subCode + ", credits=" + credits + ", fpRefno=" + fpRefno
				+ ", classnbr=" + classnbr + ", examDate=" + examDate + ", examTime=" + examTime + "]";
	}

}
