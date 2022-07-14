package org.vtop.CourseRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vtop.CourseRegistration.model.CourseRegistrationWaitingModel;
import org.vtop.CourseRegistration.model.CourseRegistrationWaitingPKModel;
import org.vtop.CourseRegistration.repository.CourseRegistrationWaitingRepository;

/*@EnableJpaRepositories(basePackageClasses={CourseRegistrationWaitingRepository.class},
entityManagerFactoryRef = "academicsEntityManagerFactory",
transactionManagerRef = "academicsTransactionManager")*/
@Service
@Transactional("academicsTransactionManager")
public class CourseRegistrationWaitingService {
		
	@Autowired
	public CourseRegistrationWaitingRepository courseRegistrationWaitingRepository;
	
	public CourseRegistrationWaitingModel saveOne(CourseRegistrationWaitingModel courseRegistrationWaitingModel)
	{
		return courseRegistrationWaitingRepository.save(courseRegistrationWaitingModel);
	}
	
	public CourseRegistrationWaitingModel getOne(CourseRegistrationWaitingPKModel courseRegistrationWaitingPKModel)
	{
		return courseRegistrationWaitingRepository.findOne(courseRegistrationWaitingPKModel);
	}
		
	public List<CourseRegistrationWaitingModel> getAll(String semesterSubId)
	{
		return courseRegistrationWaitingRepository.findBySemesterSubId(semesterSubId);
	}
		
	public List<CourseRegistrationWaitingModel> getByRegisterNumber(String semesterSubId, String registerNumber)
	{
		return courseRegistrationWaitingRepository.findByRegisterNumber(semesterSubId, registerNumber);
	}
	
	public List<CourseRegistrationWaitingModel> getByRegisterNumberCourseId(String semesterSubId, 
			String registerNumber, String courseId)
	{
		return courseRegistrationWaitingRepository.findByRegisterNumberCourseId(semesterSubId, 
				registerNumber, courseId);
	}
	
	public List<String> getWaitingSlots(String semesterSubId, String registerNumber)
	{
		return courseRegistrationWaitingRepository.findWaitingSlots(semesterSubId, registerNumber);
	}
	
	public List<String> getWaitingCourse(String semesterSubId, String registerNumber)
	{
		return courseRegistrationWaitingRepository.findWaitingCourse(semesterSubId, registerNumber);
	}
	
	public List<CourseRegistrationWaitingModel> getByClassId(String semesterSubId, String classId)
	{
		return courseRegistrationWaitingRepository.findByClassId(semesterSubId, classId);
	}
	
	public void statusUpdate(String semesterSubId, String registerNumber, String courseId, 
			Integer waitingStatus)
	{		
		courseRegistrationWaitingRepository.updateStatusNoByRegisterNumberCourseId(semesterSubId, 
				registerNumber, courseId, waitingStatus);
	}
	
	public Integer getRegisterNumberCRWCount(String semesterSubId, String registerNumber)
	{
		return courseRegistrationWaitingRepository.findRegisterNumberCRWCount(semesterSubId, registerNumber);
	}
	
	public Integer getRegisterNumberAudCount(String semesterSubId, String registerNumber)
	{
		return courseRegistrationWaitingRepository.findRegisterNumberAudCount(semesterSubId, registerNumber);
	}
	
	public Integer getRegisterNumberGICount(String semesterSubId, String registerNumber)
	{
		return courseRegistrationWaitingRepository.findRegisterNumberGICount(semesterSubId, registerNumber);
	}
	
	public Integer getWLRegCreditsByRegisterNumber(String semesterSubId, String registerNumber)
	{
		return courseRegistrationWaitingRepository.findWLRegCreditsByRegisterNumber(semesterSubId, registerNumber);
	}
		
	public void deleteByRegisterNumberCourseId(String semesterSubId, String registerNumber, String courseId)
	{		
		courseRegistrationWaitingRepository.deleteByRegisterNumberCourseId(semesterSubId, 
				registerNumber, courseId);
	}
	
	public List<Object[]> getWaitingCourseByRegNoWithRank(String semesterSubId, String registerNumber)
	{
		return courseRegistrationWaitingRepository.findWaitingCourseByRegNoWithRank(semesterSubId, registerNumber);
	}
		
}
