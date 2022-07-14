package org.vtop.CourseRegistration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TEEARR_REGISTRATION", schema="academics")
public class TeeArrRegistrationModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    private TeeArrRegistrationModelPK teeArrRegistrationModelPK;
    		
	@Column(name="CLASSNBR")
	private Long classnbr;
		
	@Column(name="REGSTATUS")
	private Long regStatus;
	
	@Column(name="STUD_HIST_COURSETYPE")
	private Long HistCourseType;
	
	@Column(name="USERID")
	private String 	userID;
	
	@Column(name="TIMESTAMP")
	private String timeStamp;
	
	@Column(name="IPADDRESS")
	private String ipAddress;
	
	@Column(name="SUBCODE")
	private String subCode;
	
	@Column(name="SUBJECTS")
	private String subject;
	
	@Column(name="PAPERTYPE")
	private String paperType;
	
	@Column(name="FP_REFNO")
	private Long  fpRefno;

	public TeeArrRegistrationModelPK getTeeArrRegistrationModelPK() {
		return teeArrRegistrationModelPK;
	}

	public void setTeeArrRegistrationModelPK(TeeArrRegistrationModelPK teeArrRegistrationModelPK) {
		this.teeArrRegistrationModelPK = teeArrRegistrationModelPK;
	}

	public Long getClassnbr() {
		return classnbr;
	}

	public void setClassnbr(Long classnbr) {
		this.classnbr = classnbr;
	}

	public Long getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(Long regStatus) {
		this.regStatus = regStatus;
	}

	public Long getHistCourseType() {
		return HistCourseType;
	}

	public void setHistCourseType(Long histCourseType) {
		HistCourseType = histCourseType;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public Long getFpRefno() {
		return fpRefno;
	}

	public void setFpRefno(Long fpRefno) {
		this.fpRefno = fpRefno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teeArrRegistrationModelPK == null) ? 0 : teeArrRegistrationModelPK.hashCode());
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
		TeeArrRegistrationModel other = (TeeArrRegistrationModel) obj;
		if (teeArrRegistrationModelPK == null) {
			if (other.teeArrRegistrationModelPK != null)
				return false;
		} else if (!teeArrRegistrationModelPK.equals(other.teeArrRegistrationModelPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TeeArrRegistrationModel [teeArrRegistrationModelPK=" + teeArrRegistrationModelPK + ", classnbr="
				+ classnbr + ", regStatus=" + regStatus + ", HistCourseType=" + HistCourseType + ", userID=" + userID
				+ ", timeStamp=" + timeStamp + ", ipAddress=" + ipAddress + ", subCode=" + subCode + ", subject="
				+ subject + ", paperType=" + paperType + ", fpRefno=" + fpRefno + "]";
	}
	
}
