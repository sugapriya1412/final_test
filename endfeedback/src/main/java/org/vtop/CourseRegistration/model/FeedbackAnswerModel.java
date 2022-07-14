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
@Table(name="FEEDBACK_ANSWERS", schema="ACADEMICS")
public class FeedbackAnswerModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    private FeedbackAnswerPkModel fbaPkId;
		
	@ManyToOne
	@JoinColumn(name="SEMSTR_DETAILS_SEMESTER_SUB_ID", referencedColumnName="SEMESTER_SUB_ID", 
					insertable = false, updatable = false)
	private SemesterDetailsModel semesterDetailsModel;
	
	@ManyToOne
	@JoinColumn(name="COURSE_ALLOCATION_CLASS_ID", referencedColumnName="CLASS_ID", 
					insertable = false, updatable = false)
	private CourseAllocationModel courseAllocationModel;
	
	@Column(name="EMPLOYEE_PROFILE_EMPLOYEE_ID")
	private String employeeId;
	
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_PROFILE_EMPLOYEE_ID", referencedColumnName="EMPLOYEE_ID", 
					insertable = false, updatable = false)
	private EmployeeProfile employeeProfile;
	
	@Column(name="COURSE_CATALOG_COURSE_ID")
	private String courseId;
	
	@ManyToOne
	@JoinColumn(name="COURSE_CATALOG_COURSE_ID", referencedColumnName="COURSE_ID", 
					insertable = false, updatable = false)
	private CourseCatalogModel courseCatalogModel;
	
	@Column(name="COURSE_TYPE")
	private String courseType;
	
	@ManyToOne
	@JoinColumn(name="COURSE_TYPE", referencedColumnName="COURSE_TYPE", 
					insertable = false, updatable = false)
	private CourseTypeComponentModel courseTypeComponentModel;
	
	@Column(name="FBA01")
	private int fba01;
	
	@Column(name="FBA02")
	private int fba02;
	
	@Column(name="FBA03")
	private int fba03;
	
	@Column(name="FBA04")
	private int fba04;
	
	@Column(name="FBA05")
	private int fba05;
	
	@Column(name="FBA06")
	private int fba06;
	
	@Column(name="FBA07")
	private int fba07;
	
	@Column(name="FBA08")
	private int fba08;
	
	@Column(name="FBA09")
	private int fba09;
	
	@Column(name="FBA10")
	private int fba10;
	
	@Column(name="FBA11")
	private int fba11;
	
	@Column(name="FBA12")
	private int fba12;
	
	@Column(name="FBA13")
	private int fba13;
	
	@Column(name="FBA14")
	private int fba14;
	
	@Column(name="FBS01")
	private String fbs01;
	
	@Column(name="FBS02")
	private String fbs02;
	
	@Column(name="FBS03")
	private String fbs03;
	
	@Column(name="FBS04")
	private String fbs04;
	
	@Column(name="LOCK_STATUS")
	private int lockStatus;
		
	@Column(name="LOG_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date logTimestamp;
	
	@Column(name="LOG_IPADDRESS")
	private String logIpaddress;

	public FeedbackAnswerPkModel getFbaPkId() {
		return fbaPkId;
	}

	public void setFbaPkId(FeedbackAnswerPkModel fbaPkId) {
		this.fbaPkId = fbaPkId;
	}

	public SemesterDetailsModel getSemesterDetailsModel() {
		return semesterDetailsModel;
	}

	public void setSemesterDetailsModel(SemesterDetailsModel semesterDetailsModel) {
		this.semesterDetailsModel = semesterDetailsModel;
	}

	public CourseAllocationModel getCourseAllocationModel() {
		return courseAllocationModel;
	}

	public void setCourseAllocationModel(CourseAllocationModel courseAllocationModel) {
		this.courseAllocationModel = courseAllocationModel;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public EmployeeProfile getEmployeeProfile() {
		return employeeProfile;
	}

	public void setEmployeeProfile(EmployeeProfile employeeProfile) {
		this.employeeProfile = employeeProfile;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public CourseCatalogModel getCourseCatalogModel() {
		return courseCatalogModel;
	}

	public void setCourseCatalogModel(CourseCatalogModel courseCatalogModel) {
		this.courseCatalogModel = courseCatalogModel;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public CourseTypeComponentModel getCourseTypeComponentModel() {
		return courseTypeComponentModel;
	}

	public void setCourseTypeComponentModel(CourseTypeComponentModel courseTypeComponentModel) {
		this.courseTypeComponentModel = courseTypeComponentModel;
	}

	public int getFba01() {
		return fba01;
	}

	public void setFba01(int fba01) {
		this.fba01 = fba01;
	}

	public int getFba02() {
		return fba02;
	}

	public void setFba02(int fba02) {
		this.fba02 = fba02;
	}

	public int getFba03() {
		return fba03;
	}

	public void setFba03(int fba03) {
		this.fba03 = fba03;
	}

	public int getFba04() {
		return fba04;
	}

	public void setFba04(int fba04) {
		this.fba04 = fba04;
	}

	public int getFba05() {
		return fba05;
	}

	public void setFba05(int fba05) {
		this.fba05 = fba05;
	}

	public int getFba06() {
		return fba06;
	}

	public void setFba06(int fba06) {
		this.fba06 = fba06;
	}

	public int getFba07() {
		return fba07;
	}

	public void setFba07(int fba07) {
		this.fba07 = fba07;
	}

	public int getFba08() {
		return fba08;
	}

	public void setFba08(int fba08) {
		this.fba08 = fba08;
	}

	public int getFba09() {
		return fba09;
	}

	public void setFba09(int fba09) {
		this.fba09 = fba09;
	}

	public int getFba10() {
		return fba10;
	}

	public void setFba10(int fba10) {
		this.fba10 = fba10;
	}
	
	public int getFba11() {
		return fba11;
	}

	public void setFba11(int fba11) {
		this.fba11 = fba11;
	}

	public int getFba12() {
		return fba12;
	}

	public void setFba12(int fba12) {
		this.fba12 = fba12;
	}

	public int getFba13() {
		return fba13;
	}

	public void setFba13(int fba13) {
		this.fba13 = fba13;
	}

	public int getFba14() {
		return fba14;
	}

	public void setFba14(int fba14) {
		this.fba14 = fba14;
	}

	public String getFbs01() {
		return fbs01;
	}

	public void setFbs01(String fbs01) {
		this.fbs01 = fbs01;
	}

	public String getFbs02() {
		return fbs02;
	}

	public void setFbs02(String fbs02) {
		this.fbs02 = fbs02;
	}

	public String getFbs03() {
		return fbs03;
	}

	public void setFbs03(String fbs03) {
		this.fbs03 = fbs03;
	}

	public String getFbs04() {
		return fbs04;
	}

	public void setFbs04(String fbs04) {
		this.fbs04 = fbs04;
	}

	public int getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(int lockStatus) {
		this.lockStatus = lockStatus;
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
		result = prime * result + ((fbaPkId == null) ? 0 : fbaPkId.hashCode());
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
		FeedbackAnswerModel other = (FeedbackAnswerModel) obj;
		if (fbaPkId == null) {
			if (other.fbaPkId != null)
				return false;
		} else if (!fbaPkId.equals(other.fbaPkId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FeedbackAnswerModel [fbaPkId=" + fbaPkId + ", semesterDetailsModel=" + semesterDetailsModel
				+ ", courseAllocationModel=" + courseAllocationModel + ", employeeId=" + employeeId
				+ ", employeeProfile=" + employeeProfile + ", courseId=" + courseId + ", courseCatalogModel="
				+ courseCatalogModel + ", courseType=" + courseType + ", courseTypeComponentModel="
				+ courseTypeComponentModel + ", fba01=" + fba01 + ", fba02=" + fba02 + ", fba03=" + fba03 + ", fba04="
				+ fba04 + ", fba05=" + fba05 + ", fba06=" + fba06 + ", fba07=" + fba07 + ", fba08=" + fba08 + ", fba09="
				+ fba09 + ", fba10=" + fba10 + ", fba11=" + fba11 + ", fba12=" + fba12 + ", fba13=" + fba13 + ", fba14="
				+ fba14 + ", fbs01=" + fbs01 + ", fbs02=" + fbs02 + ", fbs03=" + fbs03 + ", fbs04=" + fbs04
				+ ", lockStatus=" + lockStatus + ", logTimestamp=" + logTimestamp + ", logIpaddress=" + logIpaddress
				+ "]";
	}
}
