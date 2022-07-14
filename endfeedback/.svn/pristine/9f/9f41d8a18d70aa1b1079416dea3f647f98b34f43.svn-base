package org.vtop.CourseRegistration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FeedbackGeneralAnswersPKModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="SEMSTR_DETAILS_SEMESTER_SUB_ID")
	private String semesterSubId;
	
	@Column(name="FEEDBACK_TYPE")
	private String feedbackType;
			
	@Column(name="FB_SLNO")
	private Long fbSlNo;

	public String getSemesterSubId() {
		return semesterSubId;
	}

	public void setSemesterSubId(String semesterSubId) {
		this.semesterSubId = semesterSubId;
	}

	public String getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}

	public Long getFbSlNo() {
		return fbSlNo;
	}

	public void setFbSlNo(Long fbSlNo) {
		this.fbSlNo = fbSlNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fbSlNo == null) ? 0 : fbSlNo.hashCode());
		result = prime * result + ((feedbackType == null) ? 0 : feedbackType.hashCode());
		result = prime * result + ((semesterSubId == null) ? 0 : semesterSubId.hashCode());
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
		FeedbackGeneralAnswersPKModel other = (FeedbackGeneralAnswersPKModel) obj;
		if (fbSlNo == null) {
			if (other.fbSlNo != null)
				return false;
		} else if (!fbSlNo.equals(other.fbSlNo))
			return false;
		if (feedbackType == null) {
			if (other.feedbackType != null)
				return false;
		} else if (!feedbackType.equals(other.feedbackType))
			return false;
		if (semesterSubId == null) {
			if (other.semesterSubId != null)
				return false;
		} else if (!semesterSubId.equals(other.semesterSubId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FeedbackGeneralAnswersPKModel [semesterSubId=" + semesterSubId + ", feedbackType=" + feedbackType
				+ ", fbSlNo=" + fbSlNo + "]";
	}
	
}
