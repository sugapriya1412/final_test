package org.vtop.CourseRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vtop.CourseRegistration.model.CourseAllocationModel;
import org.vtop.CourseRegistration.repository.CourseAllocationRepository;

@EnableJpaRepositories(basePackageClasses={CourseAllocationRepository.class},
entityManagerFactoryRef = "academicsEntityManagerFactory",
transactionManagerRef = "academicsTransactionManager")
@Service
@Transactional("academicsTransactionManager")
public class CourseAllocationService {
	
	@Autowired CourseAllocationRepository courseAllocationRepository;
		
	/*Get All */
	public List<CourseAllocationModel> getAll()
	{
		return courseAllocationRepository.findAll();
	}
	
	/*Find One*/
	public CourseAllocationModel getOne(String classId)
	{
		return courseAllocationRepository.findOne(classId);
	}
	
	public List<CourseAllocationModel> getCourseAllocationList(String semesterSubId, 
			String[] classGroupId, String[] classType)
	{
		return courseAllocationRepository.findCourseAllocationList(semesterSubId, 
				classGroupId, classType);
	}
	
	public List<CourseAllocationModel> getCourseAllocationCourseIdList(String semesterSubId, 
			String[] classGroupId, String[] classType, String courseId)
	{
		return courseAllocationRepository.findCourseAllocationCourseIdList(semesterSubId, 
				classGroupId, classType, courseId);
	}
	
	public List<CourseAllocationModel> getCourseAllocationCourseIdTypeList(String semesterSubId, 
			String[] classGroupId, String[] classType, String courseId, String courseType)
	{
		return courseAllocationRepository.findCourseAllocationCourseIdTypeList(semesterSubId, 
				classGroupId, classType, courseId, courseType);
	}
	
	public List<CourseAllocationModel> getCourseAllocationCourseIdTypeEmpidList(String semesterSubId, 
			String[] classGroupId, String[] classType, String courseId, String courseType, String erpId)
	{
		return courseAllocationRepository.findCourseAllocationCourseIdTypeEmpidList(semesterSubId, 
				classGroupId, classType, courseId, courseType, erpId);
	}
	
	public List<CourseAllocationModel> getCourseAllocationCourseIdAvbList(String semesterSubId, 
			String[] classGroupId, String[] classType, String courseId)
	{
		return courseAllocationRepository.findCourseAllocationCourseIdAvbList(semesterSubId, 
				classGroupId, classType, courseId);
	}
	
	public List<CourseAllocationModel> getCourseAllocationCourseCodeAvbList(String semesterSubId, 
			String[] classGroupId, String[] classType, String courseCode)
	{
		return courseAllocationRepository.findCourseAllocationCourseCodeAvbList(semesterSubId, 
				classGroupId, classType, courseCode);
	}
	
	public List<CourseAllocationModel> getCourseAllocationCourseIdTypeEmpidAssocList(String semesterSubId, 
			String[] classGroupId, String[] classType, String courseId, String courseType, String erpId)
	{
		return courseAllocationRepository.findCourseAllocationCourseIdTypeEmpidAssocList(semesterSubId, 
				classGroupId, classType, courseId, courseType, erpId);
	}
	
	//public List<CourseAllocationModel> getCourseAllocationCourseIdTypeEmpidSlotList(String semesterSubId, 
	//		String[] classGroupId, String[] classType, String courseId, String courseType, 
	//		String erpId, Long slotId)
	public CourseAllocationModel getCourseAllocationCourseIdTypeEmpidSlotList(String semesterSubId, 
			String[] classGroupId, String[] classType, String courseId, String courseType, 
			String erpId, Long slotId)
	{
		return courseAllocationRepository.findCourseAllocationCourseIdTypeEmpidSlotList(semesterSubId, 
				classGroupId, classType, courseId, courseType, erpId, slotId);
	}
	
	public CourseAllocationModel getCourseAllocationCourseIdTypeEmpidSlotAssoList(String semesterSubId, 
			String[] classGroupId, String[] classType, String courseId, String courseType, 
			String erpId, Long slotId, String assoClassId)
	{
		return courseAllocationRepository.findCourseAllocationCourseIdTypeEmpidSlotAssoList(semesterSubId, 
				classGroupId, classType, courseId, courseType, erpId, slotId, assoClassId);
	}
	
	public Integer getAvailableRegisteredSeats(String classId)
	{
		return courseAllocationRepository.findAvailableRegisteredSeats(classId);
	}
	
	public Integer getAvailableWaitingSeats(String classId)
	{
		return courseAllocationRepository.findAvailableWaitingSeats(classId);
	}
	
	public Integer getAvailableRegisteredSeatsWithLock(String classId)
	{
		return courseAllocationRepository.findAvailableRegisteredSeatsWithLock(classId);
	}
	
	public Integer getAvailableWaitingSeatsWithLock(String classId)
	{
		return courseAllocationRepository.findAvailableWaitingSeatsWithLock(classId);
	}
	
	public void increaseRegisteredSeatsByOne(String classId)
	{
		courseAllocationRepository.increaseRegisteredSeats(classId);
	}
	
	public void decreaseRegisteredSeatsByOne(String classId)
	{
		courseAllocationRepository.decreaseRegisteredSeats(classId);
	}
		
}

