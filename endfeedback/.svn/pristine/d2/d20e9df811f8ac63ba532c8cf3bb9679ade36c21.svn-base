package org.vtop.CourseRegistration.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PROGRAM_DETAILS database table.
 * 
 */
@Entity
@Table(name="PROGRAM_DETAILS", schema="ACADEMICS")

public class ProgramDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProgramDetailPK id;

	private String acadnum;

	private String acadyear;

	@Column(name="DEGREE_PROG_BRANCH")
	private String degreeProgBranch;

	@Column(name="DEGREE_PROG_GROUP")
	private String degreeProgGroup;

	@Column(name="DEGREE_SHORT_DESC")
	private String degreeShortDesc;

	@Column(name="GRADE_GROUP")
	private String gradeGroup;

	private String ipaddress;

	@Column(name="PROG_DURATION")
	private BigDecimal progDuration;

	@Column(name="PROG_MODE")
	private String progMode;

	@Column(name="PROG_NAME")
	private String progName;

	@Column(name="PROG_SEM_DURATION")
	private BigDecimal progSemDuration;

	@Column(name="PROG_SHORT_DESC")
	private String progShortDesc;

	private String schoolcode;

	@Column(name="\"TIMESTAMP\"")
	private String timestamp;

	@Column(name="TO_DURATION")
	private BigDecimal toDuration;

	private String userid;

	//bi-directional one-to-one association to Studentslogin
	/*@OneToOne(mappedBy="programDetail")
	private Studentslogin studentslogin;*/

	//bi-directional one-to-one association to CourseEligible
	@OneToOne
	@JoinColumn(name="PROG_GROUP")
	private CourseEligibleModel courseEligible;

	public ProgramDetail() {
	}

	public ProgramDetailPK getId() {
		return this.id;
	}

	public void setId(ProgramDetailPK id) {
		this.id = id;
	}

	public String getAcadnum() {
		return this.acadnum;
	}

	public void setAcadnum(String acadnum) {
		this.acadnum = acadnum;
	}

	public String getAcadyear() {
		return this.acadyear;
	}

	public void setAcadyear(String acadyear) {
		this.acadyear = acadyear;
	}

	public String getDegreeProgBranch() {
		return this.degreeProgBranch;
	}

	public void setDegreeProgBranch(String degreeProgBranch) {
		this.degreeProgBranch = degreeProgBranch;
	}

	public String getDegreeProgGroup() {
		return this.degreeProgGroup;
	}

	public void setDegreeProgGroup(String degreeProgGroup) {
		this.degreeProgGroup = degreeProgGroup;
	}

	public String getDegreeShortDesc() {
		return this.degreeShortDesc;
	}

	public void setDegreeShortDesc(String degreeShortDesc) {
		this.degreeShortDesc = degreeShortDesc;
	}

	public String getGradeGroup() {
		return this.gradeGroup;
	}

	public void setGradeGroup(String gradeGroup) {
		this.gradeGroup = gradeGroup;
	}

	public String getIpaddress() {
		return this.ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public BigDecimal getProgDuration() {
		return this.progDuration;
	}

	public void setProgDuration(BigDecimal progDuration) {
		this.progDuration = progDuration;
	}

	public String getProgMode() {
		return this.progMode;
	}

	public void setProgMode(String progMode) {
		this.progMode = progMode;
	}

	public String getProgName() {
		return this.progName;
	}

	public void setProgName(String progName) {
		this.progName = progName;
	}

	public BigDecimal getProgSemDuration() {
		return this.progSemDuration;
	}

	public void setProgSemDuration(BigDecimal progSemDuration) {
		this.progSemDuration = progSemDuration;
	}

	public String getProgShortDesc() {
		return this.progShortDesc;
	}

	public void setProgShortDesc(String progShortDesc) {
		this.progShortDesc = progShortDesc;
	}

	public String getSchoolcode() {
		return this.schoolcode;
	}

	public void setSchoolcode(String schoolcode) {
		this.schoolcode = schoolcode;
	}

	public String getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public BigDecimal getToDuration() {
		return this.toDuration;
	}

	public void setToDuration(BigDecimal toDuration) {
		this.toDuration = toDuration;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	/*public Studentslogin getStudentslogin() {
		return this.studentslogin;
	}

	public void setStudentslogin(Studentslogin studentslogin) {
		this.studentslogin = studentslogin;
	}*/

	public CourseEligibleModel getCourseEligible() {
		return this.courseEligible;
	}

	public void setCourseEligible(CourseEligibleModel courseEligible) {
		this.courseEligible = courseEligible;
	}

}