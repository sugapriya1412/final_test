package org.vtop.CourseRegistration.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.RegistrationLogModel;


@Repository
public interface RegistrationLogRepository extends JpaRepository<RegistrationLogModel,String> {

	@Modifying
	@Query("update RegistrationLogModel a set a.logstatus =1, a.activeTimestamp =systimestamp,"
			+ " a.loginTimestamp =systimestamp,  a.loginIpaddress =?1	where a.regNo =?2")
	public void UpdateLoginTimeStamp(String ipAddress, String registerNumber);
	
	
	@Modifying
	@Query("update RegistrationLogModel a set a.logstatus =2, a.logoutTimestamp =systimestamp,"
			+ " a.logoutIpaddress=?1 where a.regNo =?2")
	public void UpdateLogoutTimeStamp(String ipAddress, String registerNumber);
	
	@Modifying
	@Query(value="UPDATE ACADEMICS.REGISTRATION_LOG SET ACTIVE_TIMESTAMP=SYSTIMESTAMP where "+
					"REGNO=?1 AND LOG_STATUS=1", nativeQuery=true)
	void UpdateActiveTimeStamp(String registerNumber);
	
	@Modifying
	@Query(value="INSERT INTO ACADEMICS.ERROR_LOG (EXCEPTION_MESSAGE, ERROR_DATETIME, VERTICAL_NAME, "+
					"PACKAGE_NAME, PROGRAMME_NAME, LOG_USERID, LOG_IPADDRESS) VALUES (?1, SYSTIMESTAMP, "+
					"?2, ?3, ?4, ?5, ?6)", nativeQuery=true)
	void InsertErrorLog(String exceptionMessage, String verticalName, String packageName, String programName, 
							String userId, String ipAddress);
	
	
}
