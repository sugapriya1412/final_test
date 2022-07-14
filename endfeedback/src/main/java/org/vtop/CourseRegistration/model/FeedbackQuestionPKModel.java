package org.vtop.CourseRegistration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FeedbackQuestionPKModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="FEEDBACK_PATTERN")
	private Integer feedbackPattern;
	
	@Column(name="COURSE_TYPE")
	private String courseType;
	
	@Column(name="QUESTION_NUMBER")
	private String questionNumber;

	public Integer getFeedbackPattern() {
		return feedbackPattern;
	}

	public void setFeedbackPattern(Integer feedbackPattern) {
		this.feedbackPattern = feedbackPattern;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(String questionNumber) {
		this.questionNumber = questionNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseType == null) ? 0 : courseType.hashCode());
		result = prime * result + ((feedbackPattern == null) ? 0 : feedbackPattern.hashCode());
		result = prime * result + ((questionNumber == null) ? 0 : questionNumber.hashCode());
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
		FeedbackQuestionPKModel other = (FeedbackQuestionPKModel) obj;
		if (courseType == null) {
			if (other.courseType != null)
				return false;
		} else if (!courseType.equals(other.courseType))
			return false;
		if (feedbackPattern == null) {
			if (other.feedbackPattern != null)
				return false;
		} else if (!feedbackPattern.equals(other.feedbackPattern))
			return false;
		if (questionNumber == null) {
			if (other.questionNumber != null)
				return false;
		} else if (!questionNumber.equals(other.questionNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FeedbackQuestionPKModel [feedbackPattern=" + feedbackPattern + ", courseType=" + courseType
				+ ", questionNumber=" + questionNumber + "]";
	}

}
