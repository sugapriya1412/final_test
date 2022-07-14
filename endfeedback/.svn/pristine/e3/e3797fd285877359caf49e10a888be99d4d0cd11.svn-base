package org.vtop.CourseRegistration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FEEDBACK_STUDENT_REFERENCE", schema="ACADEMICS")
public class FeedbackStudentReferenceModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    private FeedbackStudentReferencePKModel fbsrPkId;
		
	@ManyToOne
	@JoinColumn(name="SEMSTR_DETAILS_SEMESTER_SUB_ID", referencedColumnName="SEMESTER_SUB_ID", 
					insertable = false, updatable = false)
	private SemesterDetailsModel semesterDetailsModel;

	@ManyToOne
	@JoinColumn(name="STDNTSLGNDTLS_REGISTER_NUMBER", referencedColumnName="REG_NO", 
					insertable = false, updatable = false)
	private StudentsLoginDetailsModel studentsLoginDetailsModel;
	
	@ManyToOne
	@JoinColumn(name="COURSE_ALLOCATION_CLASS_ID", referencedColumnName="CLASS_ID", 
					insertable = false, updatable = false)
	private CourseAllocationModel courseAllocationModel;
	
	@Column(name="FEEDBACK_GIVEN")
	private int feedbackGiven;

	public FeedbackStudentReferencePKModel getFbsrPkId() {
		return fbsrPkId;
	}

	public void setFbsrPkId(FeedbackStudentReferencePKModel fbsrPkId) {
		this.fbsrPkId = fbsrPkId;
	}

	public SemesterDetailsModel getSemesterDetailsModel() {
		return semesterDetailsModel;
	}

	public void setSemesterDetailsModel(SemesterDetailsModel semesterDetailsModel) {
		this.semesterDetailsModel = semesterDetailsModel;
	}

	public StudentsLoginDetailsModel getStudentsLoginDetailsModel() {
		return studentsLoginDetailsModel;
	}

	public void setStudentsLoginDetailsModel(StudentsLoginDetailsModel studentsLoginDetailsModel) {
		this.studentsLoginDetailsModel = studentsLoginDetailsModel;
	}

	public CourseAllocationModel getCourseAllocationModel() {
		return courseAllocationModel;
	}

	public void setCourseAllocationModel(CourseAllocationModel courseAllocationModel) {
		this.courseAllocationModel = courseAllocationModel;
	}

	public int getFeedbackGiven() {
		return feedbackGiven;
	}

	public void setFeedbackGiven(int feedbackGiven) {
		this.feedbackGiven = feedbackGiven;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fbsrPkId == null) ? 0 : fbsrPkId.hashCode());
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
		FeedbackStudentReferenceModel other = (FeedbackStudentReferenceModel) obj;
		if (fbsrPkId == null) {
			if (other.fbsrPkId != null)
				return false;
		} else if (!fbsrPkId.equals(other.fbsrPkId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FeedbackStudentReferenceModel [fbsrPkId=" + fbsrPkId + ", semesterDetailsModel=" + semesterDetailsModel
				+ ", studentsLoginDetailsModel=" + studentsLoginDetailsModel + ", courseAllocationModel="
				+ courseAllocationModel + ", feedbackGiven=" + feedbackGiven + "]";
	}
	
}
