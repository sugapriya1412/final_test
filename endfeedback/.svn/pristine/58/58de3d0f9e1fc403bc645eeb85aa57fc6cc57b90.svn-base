package org.vtop.CourseRegistration.repository;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.CourseAllocationModel;

@Repository
public interface CourseAllocationRepository extends JpaRepository<CourseAllocationModel,String> {
	
	@Query("select a from CourseAllocationModel a where a.semesterSubId=?1 and (a.clsGrpMasterGroupId in ?2) "+
			"and (a.classType in ?3) and a.lockStatus=0 order by a.courseId, a.courseType desc, a.classId")
	List<CourseAllocationModel> findCourseAllocationList(String semesterSubId, String[] classGroupId, 
			String[] classType);
	
	@Query("select a from CourseAllocationModel a where a.semesterSubId=?1 and (a.clsGrpMasterGroupId in ?2) "+
			"and a.courseId=?4 and (a.classType in ?3) and a.lockStatus=0 order by a.courseType desc, a.erpId, "+
			"a.classId")
	List<CourseAllocationModel> findCourseAllocationCourseIdList(String semesterSubId, String[] classGroupId, 
			String[] classType, String courseId);
	
	@Query("select a from CourseAllocationModel a where a.semesterSubId=?1 and (a.clsGrpMasterGroupId in ?2) "+
			"and a.courseId=?4 and a.courseType=?5 and (a.classType in ?3) and a.lockStatus=0 order by a.erpId, "+
			"a.classId")
	List<CourseAllocationModel> findCourseAllocationCourseIdTypeList(String semesterSubId, String[] classGroupId, 
			String[] classType, String courseId, String courseType);
	
	@Query("select a from CourseAllocationModel a where a.semesterSubId=?1 and (a.clsGrpMasterGroupId in ?2) "+
			"and a.courseId=?4 and a.courseType=?5 and a.erpId=?6 and (a.classType in ?3) and a.lockStatus=0 "+
			"order by a.classId")
	List<CourseAllocationModel> findCourseAllocationCourseIdTypeEmpidList(String semesterSubId, 
			String[] classGroupId, String[] classType, String courseId, String courseType, String erpId);
	
	@Query("select a from CourseAllocationModel a where a.semesterSubId=?1 and (a.clsGrpMasterGroupId in ?2) "+
			"and a.courseId=?4 and a.courseType=?5 and (a.classType in ?3) and a.lockStatus=0 and a.assoClassId in "+
			"(select b.classId from CourseAllocationModel b where b.semesterSubId=?1 and (b.clsGrpMasterGroupId in ?2) "+
			"and b.courseId=?4 and b.courseType=?5 and b.erpId=?6 and (b.classType in ?3) and b.lockStatus=0) "+
			"order by a.classId")
	List<CourseAllocationModel> findCourseAllocationCourseIdTypeEmpidAssocList(String semesterSubId, 
			String[] classGroupId, String[] classType, String courseId, String courseType, String erpId);
	
	@Query("select a from CourseAllocationModel a where a.semesterSubId=?1 and (a.clsGrpMasterGroupId in ?2) "+
			"and a.courseId=?4 and a.courseType=?5 and a.erpId=?6 and (a.classType in ?3) and a.lockStatus=0 "+
			"and a.slotId=?7 order by a.classId")
	CourseAllocationModel findCourseAllocationCourseIdTypeEmpidSlotList(String semesterSubId, 
			String[] classGroupId, String[] classType, String courseId, String courseType, 
			String erpId, Long slotId);
	/*List<CourseAllocationModel> findCourseAllocationCourseIdTypeEmpidSlotList(String semesterSubId, 
			String[] classGroupId, String[] classType, String courseId, String courseType, 
			String erpId, Long slotId);*/
	
	@Query("select a from CourseAllocationModel a where a.semesterSubId=?1 and (a.clsGrpMasterGroupId in ?2) "+
			"and a.courseId=?4 and a.courseType=?5 and a.erpId=?6 and (a.classType in ?3) and a.lockStatus=0 "+
			"and a.slotId=?7 and a.assoClassId=?8 order by a.classId")
	CourseAllocationModel findCourseAllocationCourseIdTypeEmpidSlotAssoList(String semesterSubId, 
			String[] classGroupId, String[] classType, String courseId, String courseType, 
			String erpId, Long slotId, String assoClassId);
	
	@Query("select a from CourseAllocationModel a where a.semesterSubId=?1 and (a.clsGrpMasterGroupId in ?2) "+
			"and a.courseId=?4 and (a.classType in ?3) and a.lockStatus=0 and a.registeredSeats<a.totalSeats "+
			"order by a.courseType desc, a.erpId, a.classId")
	List<CourseAllocationModel> findCourseAllocationCourseIdAvbList(String semesterSubId, String[] classGroupId, 
			String[] classType, String courseId);
	
	@Query("select a from CourseAllocationModel a where a.semesterSubId=?1 and (a.clsGrpMasterGroupId in ?2) "+
			"and a.courseCatalogModel.code=?4 and (a.classType in ?3) and a.lockStatus=0 and a.registeredSeats<a.totalSeats "+
			"order by a.courseType desc, a.erpId, a.classId")
	List<CourseAllocationModel> findCourseAllocationCourseCodeAvbList(String semesterSubId, String[] classGroupId, 
			String[] classType, String courseCode);
	
	@Query("select (a.totalSeats-a.registeredSeats) as avbseats from CourseAllocationModel a "+
			"where a.classId=?1")
	Integer findAvailableRegisteredSeats(String classId);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select (a.totalSeats-a.registeredSeats) as avbseats from CourseAllocationModel a "+
			"where a.classId=?1")
	Integer findAvailableRegisteredSeatsWithLock(String classId);
	
	//@Query("select (60-a.waitingSeats) as avbseats from CourseAllocationModel a where a.classId=?1")
	@Query("select (10-a.waitingSeats) as avbseats from CourseAllocationModel a where a.classId=?1")
	Integer findAvailableWaitingSeats(String classId);
	
	
	//@Query("select (60-a.waitingSeats) as avbseats from CourseAllocationModel a where a.classId=?1")
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select (10-a.waitingSeats) as avbseats from CourseAllocationModel a where a.classId=?1")
	Integer findAvailableWaitingSeatsWithLock(String classId);
	
	@Modifying
	@Query("update CourseAllocationModel a set a.registeredSeats=registeredSeats+1 where a.classId=?1")
	void increaseRegisteredSeats(String classId);
	
	@Modifying
	@Query("update CourseAllocationModel a set a.registeredSeats=registeredSeats-1 where a.classId=?1")
	void decreaseRegisteredSeats(String classId);
	
}
