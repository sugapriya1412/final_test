package org.vtop.CourseRegistration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FEEDBACK_QUESTIONS", schema="ACADEMICS")
public class FeedbackQuestionModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    private FeedbackQuestionPKModel fbqPkId;
	
	@Column(name="QUESTION_TEXT")
	private String questionText;
	
	@Column(name="QUESTION_CATEGORY")
	private String questionCategory;

	public FeedbackQuestionPKModel getFbqPkId() {
		return fbqPkId;
	}

	public void setFbqPkId(FeedbackQuestionPKModel fbqPkId) {
		this.fbqPkId = fbqPkId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
	public String getQuestionCategory() {
		return questionCategory;
	}

	public void setQuestionCategory(String questionCategory) {
		this.questionCategory = questionCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fbqPkId == null) ? 0 : fbqPkId.hashCode());
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
		FeedbackQuestionModel other = (FeedbackQuestionModel) obj;
		if (fbqPkId == null) {
			if (other.fbqPkId != null)
				return false;
		} else if (!fbqPkId.equals(other.fbqPkId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FeedbackQuestionModel [fbqPkId=" + fbqPkId + ", questionText=" + questionText + "]";
	}
	
}
