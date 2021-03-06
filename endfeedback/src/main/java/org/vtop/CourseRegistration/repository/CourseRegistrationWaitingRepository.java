package org.vtop.CourseRegistration.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.CourseRegistrationWaitingModel;
import org.vtop.CourseRegistration.model.CourseRegistrationWaitingPKModel;

@Repository
public interface CourseRegistrationWaitingRepository extends JpaRepository<CourseRegistrationWaitingModel, CourseRegistrationWaitingPKModel> {
	
	@Query("select a from CourseRegistrationWaitingModel a where a.courseRegistrationWaitingPKId.semesterSubId=?1 "+
			"order by a.courseRegistrationWaitingPKId.registerNumber, a.courseRegistrationWaitingPKId.courseId, "+
			"a.courseRegistrationWaitingPKId.courseType desc")
	List<CourseRegistrationWaitingModel> findBySemesterSubId(String semesterSubId);
	
	@Query("select a from CourseRegistrationWaitingModel a where a.courseRegistrationWaitingPKId.semesterSubId=?1 "+
			"and a.courseRegistrationWaitingPKId.registerNumber=?2 order by a.courseRegistrationWaitingPKId.courseId, "+
			"a.courseRegistrationWaitingPKId.courseType desc")
	List<CourseRegistrationWaitingModel> findByRegisterNumber(String semesterSubId, String registerNumber);
	
	@Query("select a from CourseRegistrationWaitingModel a where a.courseRegistrationWaitingPKId.semesterSubId=?1 "+
			"and a.courseRegistrationWaitingPKId.registerNumber=?2 and a.courseRegistrationWaitingPKId.courseId=?3 "+
			"and a.waitingStatus=0 order by a.courseRegistrationWaitingPKId.courseType desc")
	List<CourseRegistrationWaitingModel> findByRegisterNumberCourseId(String semesterSubId, 
			String registerNumber, String courseId);
	
	@Query("select a from CourseRegistrationWaitingModel a where a.courseRegistrationWaitingPKId.semesterSubId=?1 "+
			"and a.classId=?2 and a.waitingStatus=0 order by a.logTimestamp")
	List<CourseRegistrationWaitingModel> findByClassId(String semesterSubId, String classId);
	
	@Query("select a.courseAllocationModel.timeTableModel.slotName from CourseRegistrationWaitingModel a "+
			"where a.courseRegistrationWaitingPKId.semesterSubId=?1 and a.courseRegistrationWaitingPKId."+
			"registerNumber=?2 and a.courseRegistrationWaitingPKId.courseType not in ('EPJ','PJT','ECA') and "+
			"a.waitingStatus=0")
	List<String> findWaitingSlots(String semesterSubId, String registerNumber);
	
	@Query("select distinct a.courseRegistrationWaitingPKId.courseId from CourseRegistrationWaitingModel a "+
			"where a.courseRegistrationWaitingPKId.semesterSubId=?1 and a.courseRegistrationWaitingPKId."+
			"registerNumber=?2 and a.waitingStatus=0")
	List<String> findWaitingCourse(String semesterSubId, String registerNumber);
	
	@Query("select nvl(count(distinct a.courseRegistrationWaitingPKId.courseId),0) as wlcnt from "+
			"CourseRegistrationWaitingModel a where a.courseRegistrationWaitingPKId.semesterSubId=?1 "+
			"and a.courseRegistrationWaitingPKId.registerNumber=?2 and a.waitingStatus=0")
	Integer findRegisterNumberCRWCount(String semesterSubId, String registerNumber);
	
	@Query("select nvl(count(distinct a.courseRegistrationWaitingPKId.courseId),0) as wlcnt from "+
			"CourseRegistrationWaitingModel a where a.courseRegistrationWaitingPKId.semesterSubId=?1 "+
			"and a.courseRegistrationWaitingPKId.registerNumber=?2 and a.courseOptionCode='AUD' "+
			"and a.waitingStatus=0")
	Integer findRegisterNumberAudCount(String semesterSubId, String registerNumber);
	
	@Query("select nvl(count(distinct a.courseRegistrationWaitingPKId.courseId),0) as wlcnt from "+
			"CourseRegistrationWaitingModel a where a.courseRegistrationWaitingPKId.semesterSubId=?1 "+
			"and a.courseRegistrationWaitingPKId.registerNumber=?2 and a.courseOptionCode in ('GI','GICE') "+
			"and a.waitingStatus=0")
	Integer findRegisterNumberGICount(String semesterSubId, String registerNumber);
		
	@Modifying
	@Transactional
	@Query("update CourseRegistrationWaitingModel a set a.waitingStatus=?4 where "+
			"a.courseRegistrationWaitingPKId.semesterSubId=?1 and a.courseRegistrationWaitingPKId.registerNumber=?2 "+
			"and a.courseRegistrationWaitingPKId.courseId=?3 and a.waitingStatus=0")
	void updateStatusNoByRegisterNumberCourseId(String semesterSubId, String registerNumber, 
		String courseId, Integer waitingStatus);
	
	@Modifying
	@Query("delete from CourseRegistrationWaitingModel a where a.courseRegistrationWaitingPKId.semesterSubId=?1 "+
			"and a.courseRegistrationWaitingPKId.registerNumber=?2 and a.courseRegistrationWaitingPKId.courseId=?3")
	void deleteByRegisterNumberCourseId(String semesterSubId, String registerNumber, String courseId);
	
	//To get the Registered credit
	@Query(value="select nvl(sum(credit),0) as totalCredit from ("+
			"(select b.LECTURE_CREDITS as credit from academics.COURSE_REGISTRATION_WAITING a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.CRSTYPCMPNTMASTER_COURSE_TYPE='ETH' "+
			"and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID) union all "+
			"(select b.PRACTICAL_CREDITS as credit from academics.COURSE_REGISTRATION_WAITING a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.CRSTYPCMPNTMASTER_COURSE_TYPE='ELA' "+
			"and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID) union all "+
			"(select b.PROJECT_CREDITS as credit from academics.COURSE_REGISTRATION_WAITING a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.CRSTYPCMPNTMASTER_COURSE_TYPE='EPJ' "+
			"and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID) union all "+
			"(select b.CREDITS as credit from academics.COURSE_REGISTRATION_WAITING a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.CRSTYPCMPNTMASTER_COURSE_TYPE not "+
			"in ('ETH','ELA','EPJ') and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID))", nativeQuery=true)
	Integer findWLRegCreditsByRegisterNumber(String semesterSubId, String registerNumber);
	
	//To get the Registered List along with Rank
	@Query(value="select a.COURSE_ALLOCATION_CLASS_ID, a.COURSE_CATALOG_COURSE_ID, b.CODE as course_code, "+
				"b.TITLE, a.CRSTYPCMPNTMASTER_COURSE_TYPE, c.DESCRIPTION as course_type_desc, b.LECTURE_HOURS, "+
				"b.TUTORIAL_HOURS, b.PRACTICAL_HOURS, b.PROJECT_HOURS, decode(a.CRSTYPCMPNTMASTER_COURSE_TYPE,"+
				"'ETH',b.LECTURE_CREDITS,'ELA',b.PRACTICAL_CREDITS,'EPJ',b.PROJECT_CREDITS,b.CREDITS) as credits, "+
				"a.COURSE_OPTION_MASTER_CODE,d.DESCRIPTION as course_option_desc, e.TIME_TABLE_SLOT_ID, f.SLOT_NAME, "+
				"e.ROOM_MASTER_ROOM_NUMBER,e.ERP_ID, g.FIRST_NAME, h.wlno, decode(a.CRSTYPCMPNTMASTER_COURSE_TYPE,"+
				"'ETH',1,'ELA',2,'EPJ',3,4) as order_no from academics.COURSE_REGISTRATION_WAITING a left outer join "+
				"(select COURSE_ALLOCATION_CLASS_ID, STDNTSLGNDTLS_REGISTER_NUMBER, LOG_TIMESTAMP, rank() over "+
				"(partition by COURSE_ALLOCATION_CLASS_ID order by LOG_TIMESTAMP) wlno from academics.COURSE_REGISTRATION_WAITING "+
				"where SEMSTR_DETAILS_SEMESTER_SUB_ID=?1) h on (h.COURSE_ALLOCATION_CLASS_ID=a.COURSE_ALLOCATION_CLASS_ID "+
				"and h.STDNTSLGNDTLS_REGISTER_NUMBER=a.STDNTSLGNDTLS_REGISTER_NUMBER), academics.COURSE_CATALOG b, "+
				"academics.COURSE_TYPE_COMPONENT_MASTER c, academics.COURSE_OPTION_MASTER d, academics.COURSE_ALLOCATION e, "+
				"academics.TIME_TABLE f, HRMS.EMPLOYEE_PROFILE g where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 "+
				"and a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID and "+
				"a.CRSTYPCMPNTMASTER_COURSE_TYPE=c.COURSE_TYPE and a.COURSE_OPTION_MASTER_CODE=d.CODE and "+
				"a.COURSE_ALLOCATION_CLASS_ID=e.CLASS_ID and a.SEMSTR_DETAILS_SEMESTER_SUB_ID=e.SEMSTR_DETAILS_SEMESTER_SUB_ID "+
				"and a.COURSE_CATALOG_COURSE_ID=e.COURSE_CATALOG_COURSE_ID and "+
				"a.CRSTYPCMPNTMASTER_COURSE_TYPE=e.CRSTYPCMPNTMASTER_COURSE_TYPE and b.COURSE_ID=e.COURSE_CATALOG_COURSE_ID "+
				"and e.TIME_TABLE_SLOT_ID=f.SLOT_ID and e.ERP_ID=g.EMPLOYEE_ID "+
				"order by course_code, order_no", nativeQuery=true)
	List<Object[]> findWaitingCourseByRegNoWithRank(String semesterSubId, String registerNumber);

}
