package org.vtop.CourseRegistration.repository;


import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.CourseRegistrationWithdrawOTPModel;
import org.vtop.CourseRegistration.model.CourseRegistrationWithdrawOTPPKModel;

@Repository
public interface CourseRegistrationWithdrawOTPRepository extends 
	JpaRepository<CourseRegistrationWithdrawOTPModel, CourseRegistrationWithdrawOTPPKModel> {
	
	@Modifying
	@Transactional
	@Query("update CourseRegistrationWithdrawOTPModel a set a.mailOTPStatus=?4, a.mobileOTPStatus=?5, "+
			"a.confirmOTPTimestamp=?6, a.confirmOTPUserId=?7, a.confirmOTPIpaddress=?8 where "+
			"a.crwotpPkId.semesterSubId=?1 and a.crwotpPkId.registerNumber=?2 and a.crwotpPkId.courseId=?3")
	void updateStatusNoByRegisterNumberCourseId(String semesterSubId, String registerNumber, 
			String courseId, int mailOTPStatus, int mobileOTPStatus, Date cfmOTPTimestamp, 
			String cfmOTPUserId, String cfmOTPIPAddress);
	
	@Modifying
	@Transactional
	@Query(value="insert into academics.COURSE_REG_WITHDRAW_OTP_BACKUP (select SEMSTR_DETAILS_SEMESTER_SUB_ID, "+
					"STDNTSLGNDTLS_REGISTER_NUMBER, COURSE_CATALOG_COURSE_ID, MAIL_OTP, MOBILE_OTP, "+
					"MAIL_OTP_STATUS, MOBILE_OTP_STATUS, OTP_TIMESTAMP, OTP_USERID, OTP_IPADDRESS, "+
					"CONFIRM_OTP_TIMESTAMP, CONFIRM_OTP_USERID, CONFIRM_OTP_IPADDRESS, SYSTIMESTAMP, "+
					"?4, ?5 from academics.COURSE_REG_WITHDRAW_OTP where SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 "+
					"and STDNTSLGNDTLS_REGISTER_NUMBER=?2 and COURSE_CATALOG_COURSE_ID=?3)", nativeQuery=true)
	void insertCRWOTPBackup(String semesterSubId, String registerNumber, String courseId, String backUpUserId, 
					String backUpIPAddress);
	
}
