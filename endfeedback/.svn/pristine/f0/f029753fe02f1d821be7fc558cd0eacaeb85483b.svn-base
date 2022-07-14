package org.vtop.CourseRegistration.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="FEEDBACK_GENERAL_ANSWERS", schema="ACADEMICS")
public class FeedbackGeneralAnswersModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    private FeedbackGeneralAnswersPKModel fbgaPkId;
	
	@ManyToOne
	@JoinColumn(name="SEMSTR_DETAILS_SEMESTER_SUB_ID", referencedColumnName="SEMESTER_SUB_ID", 
					insertable = false, updatable = false)
	private SemesterDetailsModel semesterDetailsModel;
	
	@Column(name="FBG_ANS01")
	private int fbgAns01;
	
	@Column(name="FBG_ANS02")
	private int fbgAns02;
	
	@Column(name="FBG_ANS03")
	private int fbgAns03;
	
	@Column(name="FBG_ANS04")
	private int fbgAns04;
	
	@Column(name="FBG_ANS05")
	private int fbgAns05;
	
	@Column(name="LOG_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date logTimestamp;
	
	@Column(name="LOG_IP_ADDRESS")
	private String logIpaddress;

	public FeedbackGeneralAnswersPKModel getFbgaPkId() {
		return fbgaPkId;
	}

	public void setFbgaPkId(FeedbackGeneralAnswersPKModel fbgaPkId) {
		this.fbgaPkId = fbgaPkId;
	}

	public SemesterDetailsModel getSemesterDetailsModel() {
		return semesterDetailsModel;
	}

	public void setSemesterDetailsModel(SemesterDetailsModel semesterDetailsModel) {
		this.semesterDetailsModel = semesterDetailsModel;
	}

	public int getFbgAns01() {
		return fbgAns01;
	}

	public void setFbgAns01(int fbgAns01) {
		this.fbgAns01 = fbgAns01;
	}

	public int getFbgAns02() {
		return fbgAns02;
	}

	public void setFbgAns02(int fbgAns02) {
		this.fbgAns02 = fbgAns02;
	}

	public int getFbgAns03() {
		return fbgAns03;
	}

	public void setFbgAns03(int fbgAns03) {
		this.fbgAns03 = fbgAns03;
	}

	public int getFbgAns04() {
		return fbgAns04;
	}

	public void setFbgAns04(int fbgAns04) {
		this.fbgAns04 = fbgAns04;
	}

	public int getFbgAns05() {
		return fbgAns05;
	}

	public void setFbgAns05(int fbgAns05) {
		this.fbgAns05 = fbgAns05;
	}
	
	public Date getLogTimestamp() {
		return logTimestamp;
	}

	public void setLogTimestamp(Date logTimestamp) {
		this.logTimestamp = logTimestamp;
	}

	public String getLogIpaddress() {
		return logIpaddress;
	}

	public void setLogIpaddress(String logIpaddress) {
		this.logIpaddress = logIpaddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fbgaPkId == null) ? 0 : fbgaPkId.hashCode());
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
		FeedbackGeneralAnswersModel other = (FeedbackGeneralAnswersModel) obj;
		if (fbgaPkId == null) {
			if (other.fbgaPkId != null)
				return false;
		} else if (!fbgaPkId.equals(other.fbgaPkId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FeedbackGeneralAnswersModel [fbgaPkId=" + fbgaPkId + ", semesterDetailsModel=" + semesterDetailsModel
				+ ", fbgAns01=" + fbgAns01 + ", fbgAns02=" + fbgAns02 + ", fbgAns03=" + fbgAns03 + ", fbgAns04="
				+ fbgAns04 + ", fbgAns05=" + fbgAns05 + ", logTimestamp=" + logTimestamp + ", logIpaddress="
				+ logIpaddress + "]";
	}	
}
