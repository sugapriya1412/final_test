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
@Table(name="COURSE_REG_WITHDRAW_OTP", schema="ACADEMICS")
public class CourseRegistrationWithdrawOTPModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    private CourseRegistrationWithdrawOTPPKModel crwotpPkId;
	
	@ManyToOne
	@JoinColumn(name="SEMSTR_DETAILS_SEMESTER_SUB_ID", referencedColumnName="SEMESTER_SUB_ID", 
					insertable = false, updatable = false)
	private SemesterDetailsModel semesterDetailsModel;
	
	@ManyToOne
	@JoinColumn(name="STDNTSLGNDTLS_REGISTER_NUMBER", referencedColumnName="REG_NO", insertable = false, updatable = false)
	private StudentsLoginDetailsModel studentsLoginDetailsModel;
			
	@ManyToOne
	@JoinColumn(name="COURSE_CATALOG_COURSE_ID", referencedColumnName="COURSE_ID", insertable = false, updatable = false)
	private CourseCatalogModel courseCatalogModel;
			
	@Column(name="MAIL_OTP")
	private String mailOTP;
		
	@Column(name="MOBILE_OTP")
	private String mobileOTP;
	
	@Column(name="MAIL_OTP_STATUS")
	private int mailOTPStatus;
	
	@Column(name="MOBILE_OTP_STATUS")
	private int mobileOTPStatus;
	
	@Column(name="OTP_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date otpTimestamp;
		
	@Column(name="OTP_USERID")
	private String otpUserId;
		
	@Column(name="OTP_IPADDRESS")
	private String otpIpaddress;

	@Column(name="CONFIRM_OTP_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date confirmOTPTimestamp;
		
	@Column(name="CONFIRM_OTP_USERID")
	private String confirmOTPUserId;
		
	@Column(name="CONFIRM_OTP_IPADDRESS")
	private String confirmOTPIpaddress;

	public CourseRegistrationWithdrawOTPPKModel getCrwotpPkId() {
		return crwotpPkId;
	}

	public void setCrwotpPkId(CourseRegistrationWithdrawOTPPKModel crwotpPkId) {
		this.crwotpPkId = crwotpPkId;
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

	public CourseCatalogModel getCourseCatalogModel() {
		return courseCatalogModel;
	}

	public void setCourseCatalogModel(CourseCatalogModel courseCatalogModel) {
		this.courseCatalogModel = courseCatalogModel;
	}

	public String getMailOTP() {
		return mailOTP;
	}

	public void setMailOTP(String mailOTP) {
		this.mailOTP = mailOTP;
	}

	public String getMobileOTP() {
		return mobileOTP;
	}

	public void setMobileOTP(String mobileOTP) {
		this.mobileOTP = mobileOTP;
	}

	public int getMailOTPStatus() {
		return mailOTPStatus;
	}

	public void setMailOTPStatus(int mailOTPStatus) {
		this.mailOTPStatus = mailOTPStatus;
	}

	public int getMobileOTPStatus() {
		return mobileOTPStatus;
	}

	public void setMobileOTPStatus(int mobileOTPStatus) {
		this.mobileOTPStatus = mobileOTPStatus;
	}

	public Date getOtpTimestamp() {
		return otpTimestamp;
	}

	public void setOtpTimestamp(Date otpTimestamp) {
		this.otpTimestamp = otpTimestamp;
	}

	public String getOtpUserId() {
		return otpUserId;
	}

	public void setOtpUserId(String otpUserId) {
		this.otpUserId = otpUserId;
	}

	public String getOtpIpaddress() {
		return otpIpaddress;
	}

	public void setOtpIpaddress(String otpIpaddress) {
		this.otpIpaddress = otpIpaddress;
	}

	public Date getConfirmOTPTimestamp() {
		return confirmOTPTimestamp;
	}

	public void setConfirmOTPTimestamp(Date confirmOTPTimestamp) {
		this.confirmOTPTimestamp = confirmOTPTimestamp;
	}

	public String getConfirmOTPUserId() {
		return confirmOTPUserId;
	}

	public void setConfirmOTPUserId(String confirmOTPUserId) {
		this.confirmOTPUserId = confirmOTPUserId;
	}

	public String getConfirmOTPIpaddress() {
		return confirmOTPIpaddress;
	}

	public void setConfirmOTPIpaddress(String confirmOTPIpaddress) {
		this.confirmOTPIpaddress = confirmOTPIpaddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crwotpPkId == null) ? 0 : crwotpPkId.hashCode());
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
		CourseRegistrationWithdrawOTPModel other = (CourseRegistrationWithdrawOTPModel) obj;
		if (crwotpPkId == null) {
			if (other.crwotpPkId != null)
				return false;
		} else if (!crwotpPkId.equals(other.crwotpPkId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CourseRegistrationWithdrawOTPModel [crwotpPkId=" + crwotpPkId + ", semesterDetailsModel="
				+ semesterDetailsModel + ", studentsLoginDetailsModel=" + studentsLoginDetailsModel
				+ ", courseCatalogModel=" + courseCatalogModel + ", mailOTP=" + mailOTP + ", mobileOTP=" + mobileOTP
				+ ", mailOTPStatus=" + mailOTPStatus + ", mobileOTPStatus=" + mobileOTPStatus + ", otpTimestamp="
				+ otpTimestamp + ", otpUserId=" + otpUserId + ", otpIpaddress=" + otpIpaddress
				+ ", confirmOTPTimestamp=" + confirmOTPTimestamp + ", confirmOTPUserId=" + confirmOTPUserId
				+ ", confirmOTPIpaddress=" + confirmOTPIpaddress + "]";
	}
	
}
