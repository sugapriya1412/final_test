package org.vtop.CourseRegistration.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.vtop.CourseRegistration.model.CourseRegistrationWithdrawModel;
import org.vtop.CourseRegistration.model.CourseRegistrationWithdrawPKModel;


public interface CourseRegistrationWithdrawRepository extends JpaRepository
		<CourseRegistrationWithdrawModel, CourseRegistrationWithdrawPKModel> {
	
	//For previous semester course checking
	@Query("select distinct 'W' from CourseRegistrationWithdrawModel a where a.crwPKId.semesterSubId "+
			"in (?1) and a.crwPKId.registerNumber=?2 and a.courseCatalogModel.code=?3")
	String findStudentPrvSemRegCourseWdCheck(String[] semesterSubId, String registerNumber, String courseCode);
	
	@Query("select a from CourseRegistrationWithdrawModel a where a.crwPKId.semesterSubId=?1 "+
			"and a.crwPKId.registerNumber=?2 and a.courseAllocationModel.clsGrpMasterGroupId "+
			"in (?3) order by a.crwPKId.courseId, a.crwPKId.courseType desc")
	List<CourseRegistrationWithdrawModel> findByRegisterNumberAndClassGroup(String semesterSubId, 
			String registerNumber, String[] classGroupId);
	
	@Modifying
	@Transactional
	@Query(value="insert into academics.COURSE_REGISTRATION_WITHDRAW (select a.*, ?2, SYSTIMESTAMP, "+
				"?4 from academics.COURSE_REGISTRATION a where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+
				"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.COURSE_CATALOG_COURSE_ID=?3)", nativeQuery=true)
	void insertRegistrationToWithdraw(String semesterSubId, String registerNumber, String courseId, 
				String ipaddress);

}
