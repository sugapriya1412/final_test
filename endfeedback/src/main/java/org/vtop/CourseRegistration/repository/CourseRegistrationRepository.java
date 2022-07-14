package org.vtop.CourseRegistration.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.CourseRegistrationModel;
import org.vtop.CourseRegistration.model.CourseRegistrationPKModel;

@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistrationModel, CourseRegistrationPKModel> {
	
	@Query("select a from CourseRegistrationModel a where a.courseRegistrationPKId.semesterSubId=?1 "+
			"order by a.courseRegistrationPKId.registerNumber, a.courseRegistrationPKId.courseId, "+
			"a.courseRegistrationPKId.courseType desc")
	List<CourseRegistrationModel> findBySemesterSubId(String semesterSubId);
	
	@Query("select a from CourseRegistrationModel a where a.courseRegistrationPKId.semesterSubId=?1 "+
			"and a.courseRegistrationPKId.registerNumber=?2 order by a.courseRegistrationPKId.courseId, "+
			"a.courseRegistrationPKId.courseType desc")
	List<CourseRegistrationModel> findByRegisterNumber(String semesterSubId, String registerNumber);
	
	@Query("select a from CourseRegistrationModel a where a.courseRegistrationPKId.semesterSubId=?1 "+
			"and a.courseRegistrationPKId.registerNumber=?2 and a.courseAllocationModel.clsGrpMasterGroupId "+
			"in (?3) and a.courseRegistrationPKId.courseType in ('ETH','TH','ELA','LO','SS') "+
			"order by a.courseRegistrationPKId.courseId, a.courseRegistrationPKId.courseType desc")
	List<CourseRegistrationModel> findByRegisterNumberAndClassGroup(String semesterSubId, 
			String registerNumber, String[] classGroupId);
	
	@Query("select a.classId, a.courseAllocationModel.courseCatalogModel.code, "+
			"a.courseAllocationModel.courseCatalogModel.title, "+
			"a.courseAllocationModel.courseTypeComponentModel.description, "+
			"a.courseRegistrationPKId.courseType, a.courseCatalogModel.lectureHours, "+
			"a.courseCatalogModel.tutorialHours, a.courseCatalogModel.practicalHours, "+
			"a.courseCatalogModel.projectHours, a.courseCatalogModel.lectureCredits, "+
			"a.courseCatalogModel.practicalCredits, a.courseCatalogModel.projectCredits, "+
			"a.courseCatalogModel.credits, a.courseOptionModel.description, "+
			"a.courseAllocationModel.timeTableModel.slotName, a.courseAllocationModel.roomMasterRoomNumber, "+
			"a.courseAllocationModel.employeeProfile.firstName, a.registrationStatusMasterModel.color, "+
			"a.registrationStatusMasterModel.description, a.courseRegistrationPKId.courseId "+
			"from CourseRegistrationModel a where a.courseRegistrationPKId.semesterSubId=?1 "+
			"and a.courseRegistrationPKId.registerNumber=?2 and a.courseAllocationModel.clsGrpMasterGroupId "+
			"in (?3) and a.courseRegistrationPKId.courseType in ('ETH','TH','ELA','LO','SS') "+
			"order by a.courseRegistrationPKId.courseId, a.courseRegistrationPKId.courseType desc")
	List<Object[]> findByRegisterNumberAndClassGroup2(String semesterSubId, 
			String registerNumber, String[] classGroupId);
	
	@Query("select a from CourseRegistrationModel a where a.courseRegistrationPKId.semesterSubId=?1 "+
			"and a.courseRegistrationPKId.registerNumber=?2 and a.courseRegistrationPKId.courseId=?3 "+
			"order by a.courseRegistrationPKId.courseType desc")
	List<CourseRegistrationModel> findByRegisterNumberCourseId(String semesterSubId, String registerNumber, 
		String courseId);
	
	@Query("select a from CourseRegistrationModel a where a.courseRegistrationPKId.semesterSubId=?1 "+
			"and a.courseRegistrationPKId.registerNumber=?2 and a.courseCatalogModel.code=?3 "+
			"order by a.courseRegistrationPKId.courseType desc")
	List<CourseRegistrationModel> findByRegisterNumberCourseCode(String semesterSubId, 
			String registerNumber, String courseCode);
	
	@Query("select a.courseRegistrationPKId.courseId, a.courseRegistrationPKId.courseType, "+
			"a.courseCatalogModel.lectureCredits, a.courseCatalogModel.practicalCredits, "+
			"a.courseCatalogModel.projectCredits, a.courseCatalogModel.credits from "+
			"CourseRegistrationModel a where a.courseRegistrationPKId.semesterSubId=?1 "+
			"and a.courseRegistrationPKId.registerNumber=?2 order by a.courseRegistrationPKId.courseId, "+
			"a.courseRegistrationPKId.courseType desc")
	List<CourseRegistrationModel> findRegisterNumberCredits(String semesterSubId, String registerNumber);
	
	@Query("select a from CourseRegistrationModel a where a.courseRegistrationPKId.semesterSubId=?1 "+
			"and a.courseRegistrationPKId.registerNumber=?2 and a.courseRegistrationPKId.courseId=?3 "+
			"and a.courseRegistrationPKId.courseType=?4")
	CourseRegistrationModel findByRegisterNumberCourseIdAndType(String semesterSubId, String registerNumber, 
		String courseId, String courseType);
			
	/*@Modifying
	@Query("update CourseRegistrationModel a set a.classId=?5, a.logUserId=?6, logTimestamp=?7, "+
			"logIpaddress=?8 where a.courseRegistrationPKId.semesterSubId=?1 and "+
			"a.courseRegistrationPKId.registerNumber=?2 and a.courseRegistrationPKId.courseId=?3 "+
			"and a.courseRegistrationPKId.courseType=?4")
	void updateClassIdByRegisterNumberCourseIdType(String semesterSubId, String registerNumber, 
		String courseId, String courseType, String classId, String userId, Date timeStamp, 
		String ipAddress);*/
	
	@Modifying
	@Query("update CourseRegistrationModel a set a.classId=?5, a.logUserId=?6, a.logTimestamp=?7, "+
			"a.logIpaddress=?8 where a.courseRegistrationPKId.semesterSubId=?1 and "+
			"a.courseRegistrationPKId.registerNumber=?2 and a.courseRegistrationPKId.courseId=?3 "+
			"and a.courseRegistrationPKId.courseType=?4")
	void updateClassIdByRegisterNumberCourseIdType(String semesterSubId, String registerNumber, 
		String courseId, String courseType, String classId, String userId, Date timestamp, 
		String ipaddress);
	
	@Modifying
	@Query("update CourseRegistrationModel a set a.statusNumber=?4 where "+
			"a.courseRegistrationPKId.semesterSubId=?1 and a.courseRegistrationPKId.registerNumber=?2 "+
			"and a.courseRegistrationPKId.courseId=?3")
	void updateStatusNoByRegisterNumberCourseId(String semesterSubId, String registerNumber, 
		String courseId, Integer statusNumber);
	
	@Modifying
	@Query("delete from CourseRegistrationModel a where a.courseRegistrationPKId.semesterSubId=?1 "+
			"and a.courseRegistrationPKId.registerNumber=?2 and a.courseRegistrationPKId.courseId=?3")
	void deleteByRegisterNumberCourseId(String semesterSubId, String registerNumber, String courseId);
	
	@Query("select nvl(count(distinct a.courseRegistrationPKId.courseId),0) as regcnt from "+
			"CourseRegistrationModel a where a.courseRegistrationPKId.semesterSubId=?1 "+
			"and a.courseRegistrationPKId.registerNumber=?2")
	Integer findRegisterNumberTCCount(String semesterSubId, String registerNumber);
	
	@Query("select nvl(count(distinct a.courseRegistrationPKId.courseId),0) as regcnt from "+
			"CourseRegistrationModel a where a.courseRegistrationPKId.semesterSubId=?1 and "+
			"a.courseRegistrationPKId.registerNumber=?2 and a.courseAllocationModel.clsGrpMasterGroupId "+
			"in (?3) and a.courseRegistrationPKId.courseType not in ('ECA')")
	Integer findRegisteredCourseCountByRegisterNumberAndClassGroup(String semesterSubId, 
			String registerNumber, String[] classGroupId);
	
	@Query("select nvl(count(distinct a.classId),0) as classCount from "+
			"CourseRegistrationModel a where a.courseRegistrationPKId.semesterSubId=?1 and "+
			"a.courseRegistrationPKId.registerNumber=?2 and a.courseAllocationModel.clsGrpMasterGroupId "+
			"in (?3) and a.courseRegistrationPKId.courseType in ('ETH','TH','ELA','LO','SS')")
	Integer findRegisteredFeedbackClassCountByRegisterNumberAndClassGroup(String semesterSubId, 
			String registerNumber, String[] classGroupId);
	
	@Query("select nvl(count(distinct b.courseRegistrationPKId.courseId),0) as rgrcnt from "+
			"CourseRegistrationModel b where b.courseRegistrationPKId.semesterSubId=?1 "+
			"and b.courseRegistrationPKId.registerNumber=?2 and (b.courseOptionCode in "+
			"('RGR','RGA','AUD','RGP','DM') or (b.courseOptionCode like 'HON%') or "+
			"(b.courseOptionCode like 'MIN%'))")
	Integer findRegisterNumberRCCount(String semesterSubId, String registerNumber);
	
	@Query("select nvl(count(distinct c.courseRegistrationPKId.courseId),0) as invcnt from "+
			"CourseRegistrationModel c where c.courseRegistrationPKId.semesterSubId=?1 "+
			"and c.courseRegistrationPKId.registerNumber=?2 and (c.courseRegistrationPKId.courseId "+
			"like 'INV%')")
	Integer findRegisterNumbeICCCount(String semesterSubId, String registerNumber);
	
	@Query("select nvl(count(distinct c.courseRegistrationPKId.courseId),0) as invcnt from "+
			"CourseRegistrationModel c where c.courseRegistrationPKId.semesterSubId=?1 "+
			"and c.courseRegistrationPKId.registerNumber=?2 and c.courseOptionCode='AUD'")
	Integer findRegisterNumbeAudCount(String semesterSubId, String registerNumber);
	
	@Query("select nvl(count(distinct c.courseRegistrationPKId.courseId),0) as invcnt from "+
			"CourseRegistrationModel c where c.courseRegistrationPKId.semesterSubId=?1 "+
			"and c.courseRegistrationPKId.registerNumber=?2 and c.courseOptionCode in ('GI','GICE')")
	Integer findRegisterNumbeGICount(String semesterSubId, String registerNumber);
	
	@Query(value="select nvl(sum(credit),0) as totalCredit from ("+
			"(select b.LECTURE_CREDITS as credit from academics.COURSE_REGISTRATION a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.CRSTYPCMPNTMASTER_COURSE_TYPE='ETH' "+
			"and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID) union all "+
			"(select b.PRACTICAL_CREDITS as credit from academics.COURSE_REGISTRATION a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.CRSTYPCMPNTMASTER_COURSE_TYPE='ELA' "+
			"and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID) union all "+
			"(select b.PROJECT_CREDITS as credit from academics.COURSE_REGISTRATION a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.CRSTYPCMPNTMASTER_COURSE_TYPE='EPJ' "+
			"and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID) union all "+
			"(select b.CREDITS as credit from academics.COURSE_REGISTRATION a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.CRSTYPCMPNTMASTER_COURSE_TYPE not "+
			"in ('ETH','ELA','EPJ','ECA') and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID))", nativeQuery=true)
	Integer findRegisterNumberTotalCredits(String semesterSubId, String registerNumber);
	
	@Query(value="select nvl(sum(credit),0) as totalCredit from ("+
			"(select b.LECTURE_CREDITS as credit, a.COURSE_OPTION_MASTER_CODE from academics.COURSE_REGISTRATION a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID in (?1) and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.CRSTYPCMPNTMASTER_COURSE_TYPE='ETH' "+
			"and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID) union all "+
			"(select b.PRACTICAL_CREDITS as credit, a.COURSE_OPTION_MASTER_CODE from academics.COURSE_REGISTRATION a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID in (?1) and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.CRSTYPCMPNTMASTER_COURSE_TYPE='ELA' "+
			"and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID) union all "+
			"(select b.PROJECT_CREDITS as credit, a.COURSE_OPTION_MASTER_CODE from academics.COURSE_REGISTRATION a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID in (?1) and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.CRSTYPCMPNTMASTER_COURSE_TYPE='EPJ' "+
			"and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID) union all "+
			"(select b.CREDITS as credit, a.COURSE_OPTION_MASTER_CODE from academics.COURSE_REGISTRATION a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID in (?1) and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.CRSTYPCMPNTMASTER_COURSE_TYPE not "+
			"in ('ETH','ELA','EPJ') and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID)) where "+
			"COURSE_OPTION_MASTER_CODE not in ('AUD','GI','GICE')", nativeQuery=true)
	Integer findPSRegisteredTotalCreditsByRegisterNumber(String[] semesterSubId, String registerNumber);
	
	@Query("select a.courseAllocationModel.timeTableModel.slotName from CourseRegistrationModel a "+
			"where a.courseRegistrationPKId.semesterSubId=?1 and a.courseRegistrationPKId.registerNumber=?2 "+
			"and a.courseRegistrationPKId.courseType not in ('EPJ','PJT','ECA')")
	List<String> findRegisteredSlots(String semesterSubId, String registerNumber);
	
	@Query("select a.courseAllocationModel.timeTableModel.slotName from CourseRegistrationModel a "+
			"where a.courseRegistrationPKId.semesterSubId=?1 and a.courseRegistrationPKId.registerNumber=?2 "+
			"and a.classId not in (?3) and a.courseRegistrationPKId.courseType not in ('EPJ','PJT','ECA')")
	List<String> findRegisteredSlotsforUpdate(String semesterSubId, String registerNumber, String oldClassId);
	
	@Query("select distinct a.courseRegistrationPKId.courseId from CourseRegistrationModel a "+
			"where a.courseRegistrationPKId.semesterSubId=?1 and a.courseRegistrationPKId.registerNumber=?2")
	List<String> findRegisteredCourse(String semesterSubId, String registerNumber);
	
	//For previous semester course checking
	@Query("select distinct 'R' from CourseRegistrationModel a where a.courseRegistrationPKId.semesterSubId "+
			"in (?1) and a.courseRegistrationPKId.registerNumber=?2 and a.courseCatalogModel.code=?3")
	String findStudentPrvSemRegCourseCheck(String[] semesterSubId, String registerNumber, String courseCode);
	
	@Query("select distinct a.courseCatalogModel.code from CourseRegistrationModel a where "+
			"a.courseRegistrationPKId.semesterSubId in (?1) and a.courseRegistrationPKId.registerNumber in (?2) "+
			"and (a.courseCatalogModel.code in (?3) or (a.courseCatalogModel.code in (select c.equivalentCourseCode "+
			"from CourseEquivalancesModel c where c.courseCode in (?3))) or (a.courseCatalogModel.code in "+
			"(select d.courseCode from CourseEquivalancesModel d where d.equivalentCourseCode in (?3))))")
	List<String> findStudentPrvSemPARequisite(String[] semesterSubId, List<String> registerNumber, 
					List<String> courseCode);
		
	@Modifying
	@Transactional
	@Query(value="insert into academics.COURSE_REGISTRATION (select a.SEMSTR_DETAILS_SEMESTER_SUB_ID, "+
			"a.COURSE_ALLOCATION_CLASS_ID, a.STDNTSLGNDTLS_REGISTER_NUMBER, a.COURSE_CATALOG_COURSE_ID, "+
			"a.CRSTYPCMPNTMASTER_COURSE_TYPE, a.COURSE_OPTION_MASTER_CODE, a.REGISTRATION_STATUS_NUMBER, "+
			"a.REGISTRATION_COMPONENT_TYPE, 0, 0, 0, ?2, SYSTIMESTAMP, a.LOG_IPADDRESS from "+
			"academics.COURSE_REGISTRATION_WAITING a where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.COURSE_CATALOG_COURSE_ID=?3)", nativeQuery=true)
	void insertWaitingToRegistration(String semesterSubId, String registerNumber, String courseId);	 
	
	
	//Procedure
	//For Insert
	@Procedure(name="registration_insert_prc", procedureName="academics.registration_insert_prc")
	String registration_insert_prc(String psemsubid, String pclassid, String pregno, String pcourseid, 
			String pcomponent_type, String pcourse_option, Integer pregstatus, Integer pregcomponent_type, 
			String ploguserid, String plogipaddress, String pregtype, String pold_course_code, 
			String pcalltype);
	
	//For Update
	@Procedure(name="registration_update_prc", procedureName="academics.registration_update_prc")
	String registration_update_prc(String psemsubid, String pregno, String pcourseid, String pcomponent_type,
			String pcourse_option, String poldclassid, String pnewclassid, String ploguserid, String plogipaddress,
			Integer pregstatus, Integer pregcomponent_type, String pregtype, String pold_course_code);
	
	//For Delete
	@Procedure(name="registration_delete_prc", procedureName="academics.registration_delete_prc")
	String registration_delete_prc(String psemsubid, String pregno, String pcourseid, String pcalltype, 
			String ploguserid, String plogipaddress, String pregtype, String poldcoursecode);
	
	
	@Query(value="select SLOT, week_day, CODE, CRSTYPCMPNTMASTER_COURSE_TYPE, ROOM_MASTER_ROOM_NUMBER, "+
			      "TIME_TABLE_SLOT_ID, SLOT_ID, SLOT_NAME, SLOT_TYPE from ("+
			      "(select e.SLOT, e.week_day, b.CODE, a.CRSTYPCMPNTMASTER_COURSE_TYPE, c.ROOM_MASTER_ROOM_NUMBER, "+
			      "c.TIME_TABLE_SLOT_ID, d.SLOT_ID, d.SLOT_NAME, d.SLOT_TYPE from academics.course_registration a, "+
			      "academics.course_catalog b, academics.course_allocation c, academics.time_table d, "+
			      "academics.slot_time_master e where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+
			      "a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and d.PATTERN_ID=?3 and a.CRSTYPCMPNTMASTER_COURSE_TYPE in "+
			      "('ETH','TH','ELA','LO','SS') and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID and "+
			      "a.COURSE_ALLOCATION_CLASS_ID=c.CLASS_ID and b.COURSE_ID=c.COURSE_CATALOG_COURSE_ID and "+
			      "c.TIME_TABLE_SLOT_ID=d.SLOT_ID and e.SLOT IN (SELECT REGEXP_SUBSTR(d.SLOT_NAME, '[^+]+', 1, LEVEL) "+
			      "AS data FROM dual CONNECT BY REGEXP_SUBSTR(d.SLOT_NAME,'[^+]+', 1, LEVEL) IS NOT NULL)) "+
			      "union all "+
			      "(select e.SLOT, e.week_day, b.CODE, a.CRSTYPCMPNTMASTER_COURSE_TYPE, c.ROOM_MASTER_ROOM_NUMBER, "+
			      "c.TIME_TABLE_SLOT_ID, d.SLOT_ID, d.SLOT_NAME, d.SLOT_TYPE from academics.COURSE_REGISTRATION_WAITING a, "+
			      "academics.course_catalog b, academics.course_allocation c, academics.time_table d, "+
			      "academics.slot_time_master e where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+
			      "a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and d.PATTERN_ID=?3 and a.CRSTYPCMPNTMASTER_COURSE_TYPE in "+
			      "('ETH','TH','ELA','LO','SS') and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID and "+
			      "a.COURSE_ALLOCATION_CLASS_ID=c.CLASS_ID and b.COURSE_ID=c.COURSE_CATALOG_COURSE_ID and "+
			      "c.TIME_TABLE_SLOT_ID=d.SLOT_ID and e.SLOT IN (SELECT REGEXP_SUBSTR(d.SLOT_NAME, '[^+]+', 1, LEVEL) "+
			      "AS data FROM dual CONNECT BY REGEXP_SUBSTR(d.SLOT_NAME,'[^+]+', 1, LEVEL) IS NOT NULL)))", 
			      nativeQuery=true)
	List<Object[]> findCourseRegWlSlotByStudent(String semesterSubId, String registerNumber, Integer patternId);
	
	//For cancelled course checking
	@Query(value="select distinct 'RP' from academics.course_registration_cancel a, academics.course_catalog b "+
			"where a.STDNTSLGNDTLS_REGISTER_NUMBER in (?1) and (b.code=?2 or b.code in "+ 
			"(select EQUIVALENT_COURSE_CODE from academics.COURSE_EQUIVALANCES where COURSE_CODE=?2) or "+
			"b.code in (select COURSE_CODE from academics.COURSE_EQUIVALANCES where EQUIVALENT_COURSE_CODE=?2)) "+ 
			"and (upper(a.remarks) like '%SUSPEND%' or upper(a.remarks) like '%DISCONTINUE%' or "+
			"upper(a.remarks) like '%BREAK%') and b.course_id=a.course_catalog_course_id", nativeQuery=true)
	String findStudentCourseCancelCheck(List<String> registerNumber, String courseCode);
	
	@Query(value="select nvl(sum(credit),0) as courseCredit from ("+
			"(select b.LECTURE_CREDITS as credit from academics.COURSE_REGISTRATION a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.COURSE_CATALOG_COURSE_ID=?3 and "+
			"a.CRSTYPCMPNTMASTER_COURSE_TYPE='ETH' and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID) union all "+
			"(select b.PRACTICAL_CREDITS as credit from academics.COURSE_REGISTRATION a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.COURSE_CATALOG_COURSE_ID=?3 and "+
			"a.CRSTYPCMPNTMASTER_COURSE_TYPE='ELA' and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID) union all "+
			"(select b.PROJECT_CREDITS as credit from academics.COURSE_REGISTRATION a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.COURSE_CATALOG_COURSE_ID=?3 and "+
			"a.CRSTYPCMPNTMASTER_COURSE_TYPE='EPJ' and a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID) union all "+
			"(select b.CREDITS as credit from academics.COURSE_REGISTRATION a, "+ 
			"academics.COURSE_CATALOG b where a.SEMSTR_DETAILS_SEMESTER_SUB_ID=?1 and "+ 
			"a.STDNTSLGNDTLS_REGISTER_NUMBER=?2 and a.COURSE_CATALOG_COURSE_ID=?3 and "+
			"a.CRSTYPCMPNTMASTER_COURSE_TYPE not in ('ETH','ELA','EPJ','ECA') and "+
			"a.COURSE_CATALOG_COURSE_ID=b.COURSE_ID))", nativeQuery=true)
	Integer findRegisterNumberCreditsByCourse(String semesterSubId, String registerNumber, 
			String courseId);

}
