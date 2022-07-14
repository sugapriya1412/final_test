package org.vtop.CourseRegistration.repository;

import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.UserDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailModel,String>{

	/*@Query("SELECT u FROM UserDetail u WHERE u.userId=?1")
	UserDetailModel findByuserId(String id);
	
		@Modifying
	  @Transactional
	  @Query("update UserDetail a set a.passwdStatus=?1, a.passwd=?2, a.passwdUpdateTimestamp=?3 where a.userId=?4")
	  void updateUserDetailsOnPwdReset(BigDecimal pwdStatus, String newEncyptedPwd, Date pwdUpdateTimeStamp, String userId);
	  
	 @Query(value="select e.userid,e.passwd from VTOPMASTER.USER_DETAILS e,ADMISSIONS.STUDENTS_LOGIN_DETAILS d,"
			      + "ADMISSIONS.STUDENT_BASE c,VTOPMASTER.PROGRAMME_SPECIALIZATION a,VTOPMASTER.PROGRAMME_GROUP b where "
			      + "a.PRGRM_GROUP_PROGRAMME_GROUP_ID=b.PROGRAMME_GROUP_ID and "
			      + "a.PROGRAMME_SPECIALIZATION_ID=c.PRGSPL_PRGRM_SPECIALIZATION_ID and d.APPLICATION_NO=c.APPLICATION_NUMBER "
			      + "and e.USERID=d.REG_NO and b.code in ('BTECH','MTECH') and e.userid=?1",nativeQuery=true)
		  List<Object[]> getUserStatus(String regno);
	  
	  @Modifying
	  @Transactional
	  @Query("update UserDetail a set a.passwdStatus=?1, a.numFailAttempt=?2,a.lastLoginTimestamp=?3 where a.userId=?4")
	  void updateUserDetailsFailAttemp(BigDecimal pwdStatus, BigDecimal failAttempt, Date lastLoginTimestamp, String userId);*/
}
