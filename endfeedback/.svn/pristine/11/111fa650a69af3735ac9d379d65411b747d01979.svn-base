package org.vtop.CourseRegistration.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vtop.CourseRegistration.model.CourseRegistrationModel;
import org.vtop.CourseRegistration.model.CourseRegistrationPKModel;
import org.vtop.CourseRegistration.repository.CourseRegistrationRepository;

/*@EnableJpaRepositories(basePackageClasses={CourseRegistrationRepository.class},
entityManagerFactoryRef = "academicsEntityManagerFactory",
transactionManagerRef = "academicsTransactionManager")*/
@Service
@Transactional("academicsTransactionManager")
public class CourseRegistrationService {
		
	@Autowired
	public CourseRegistrationRepository courseRegistrationRepository;
	
	public CourseRegistrationModel saveOne(CourseRegistrationModel courseRegistrationModel)
	{
		return courseRegistrationRepository.save(courseRegistrationModel);
	}
	
	public CourseRegistrationModel getOne(CourseRegistrationPKModel courseRegistrationPKModel)
	{
		return courseRegistrationRepository.findOne(courseRegistrationPKModel);
	}
		
	public List<CourseRegistrationModel> getAll(String semesterSubId)
	{
		return courseRegistrationRepository.findBySemesterSubId(semesterSubId);
	}
		
	public List<CourseRegistrationModel> getByRegisterNumber(String semesterSubId, String registerNumber)
	{
		return courseRegistrationRepository.findByRegisterNumber(semesterSubId, registerNumber);
	}
	
	public List<CourseRegistrationModel> getByRegisterNumberAndClassGroup(String semesterSubId, 
				String registerNumber, String[] classGroupId)
	{
		return courseRegistrationRepository.findByRegisterNumberAndClassGroup(semesterSubId, 
					registerNumber, classGroupId);
	}
	
	public List<Object[]> getByRegisterNumberAndClassGroup2(String semesterSubId, 
				String registerNumber, String[] classGroupId)
	{
		return courseRegistrationRepository.findByRegisterNumberAndClassGroup2(semesterSubId, 
					registerNumber, classGroupId);
	}
	
	public List<CourseRegistrationModel> getByRegisterNumberCourseId(String semesterSubId, 
			String registerNumber, String courseId)
	{
		return courseRegistrationRepository.findByRegisterNumberCourseId(semesterSubId, 
				registerNumber, courseId);
	}
	
	public CourseRegistrationModel getByRegisterNumberCourseIdAndType(String semesterSubId, String registerNumber, 
			String courseId, String courseType)
	{
		return courseRegistrationRepository.findByRegisterNumberCourseIdAndType(semesterSubId, registerNumber, 
				courseId, courseType);
	}
	
	public List<CourseRegistrationModel> getByRegisterNumberCourseCode(String semesterSubId, 
			String registerNumber, String courseCode)
	{
		return courseRegistrationRepository.findByRegisterNumberCourseCode(semesterSubId, 
				registerNumber, courseCode);
	}
	
	public void classUpdate(String semesterSubId, String registerNumber, String courseId, 
			String courseType, String classId, String userId, Date timestamp, 
			String ipaddress)
	{				
		courseRegistrationRepository.updateClassIdByRegisterNumberCourseIdType(semesterSubId, 
				registerNumber, courseId, courseType, classId, userId, timestamp, ipaddress);
	}
	
	public void statusUpdate(String semesterSubId, String registerNumber, String courseId, 
			Integer statusNumber)
	{		
		courseRegistrationRepository.updateStatusNoByRegisterNumberCourseId(semesterSubId, 
				registerNumber, courseId, statusNumber);
	}
	
	public void deleteByRegisterNumberCourseId(String semesterSubId, String registerNumber, String courseId)
	{		
		courseRegistrationRepository.deleteByRegisterNumberCourseId(semesterSubId, 
				registerNumber, courseId);
	}
	
	public Integer getRegisterNumberTCCount(String semesterSubId, String registerNumber)
	{
		return courseRegistrationRepository.findRegisterNumberTCCount(semesterSubId, registerNumber);
	}
	
	public Integer getRegisteredCourseCountByRegisterNumberAndClassGroup(String semesterSubId, 
				String registerNumber, String[] classGroupId)
	{
		return courseRegistrationRepository.findRegisteredCourseCountByRegisterNumberAndClassGroup(semesterSubId, 
					registerNumber, classGroupId);
	}
	
	public Integer getRegisteredFeedbackClassCountByRegisterNumberAndClassGroup(String semesterSubId, 
			String registerNumber, String[] classGroupId)
	{
		Integer tempCount = 0;
		
		tempCount = courseRegistrationRepository.findRegisteredFeedbackClassCountByRegisterNumberAndClassGroup(semesterSubId, 
							registerNumber, classGroupId);
		if (tempCount == null)
		{
			tempCount = 0;
		}
		
		return tempCount;
	}
	
	public Integer getRegisterNumberRCCount(String semesterSubId, String registerNumber)
	{
		return courseRegistrationRepository.findRegisterNumberRCCount(semesterSubId, registerNumber);
	}
	
	public Integer getRegisterNumbeAudCount(String semesterSubId, String registerNumber)
	{
		return courseRegistrationRepository.findRegisterNumbeAudCount(semesterSubId, registerNumber);
	}
	
	public Integer getRegisterNumbeGICount(String semesterSubId, String registerNumber)
	{
		return courseRegistrationRepository.findRegisterNumbeGICount(semesterSubId, registerNumber);
	}
	
	public Integer getRegisterNumbeICCCount(String semesterSubId, String registerNumber)
	{
		return courseRegistrationRepository.findRegisterNumbeICCCount(semesterSubId, registerNumber);
	}
	
	public Integer getRegisterNumberTotalCredits(String semesterSubId, String registerNumber)
	{
		return courseRegistrationRepository.findRegisterNumberTotalCredits(semesterSubId, registerNumber);
	}
	
	public Integer getPSRegisteredTotalCreditsByRegisterNumber(String[] semesterSubId, String registerNumber)
	{
		return courseRegistrationRepository.findPSRegisteredTotalCreditsByRegisterNumber(semesterSubId, registerNumber);
	}
	
	public List<String> getRegisteredSlots(String semesterSubId, String registerNumber)
	{
		return courseRegistrationRepository.findRegisteredSlots(semesterSubId, registerNumber);
	}
	
	public List<String> getRegisteredSlotsforUpdate(String semesterSubId, String registerNumber, String oldClassId)
	{
		return courseRegistrationRepository.findRegisteredSlotsforUpdate(semesterSubId, registerNumber, oldClassId);
	}
	
	public List<String> getRegisteredCourse(String semesterSubId, String registerNumber)
	{
		return courseRegistrationRepository.findRegisteredCourse(semesterSubId, registerNumber);
	}
	
	public List<CourseRegistrationModel> getRegisterNumberCredits(String semesterSubId, String registerNumber)
	{
		return courseRegistrationRepository.findRegisterNumberCredits(semesterSubId, registerNumber);
	}
	
	public String getStudentPrvSemRegCourseCheck(String[] semesterSubId, String registerNumber, String courseCode)
	{
		return courseRegistrationRepository.findStudentPrvSemRegCourseCheck(semesterSubId, registerNumber, courseCode);
	}
	
	public List<String> getStudentPrvSemPARequisite(String[] semesterSubId, List<String> registerNumber, 
			List<String> courseCode)
	{
		return courseRegistrationRepository.findStudentPrvSemPARequisite(semesterSubId, registerNumber, courseCode);
	}
		
	public void insertFromWaitingToRegistration(String semesterSubId, String registerNumber, String courseId)
	{		
		courseRegistrationRepository.insertWaitingToRegistration(semesterSubId, 
				registerNumber, courseId);
	}
	
	//For Procedure
	public String courseRegistrationAdd(String psemsubid, String pclassid, String pregno, String pcourseid, 
			String pcomponent_type, String pcourse_option, Integer pregstatus, Integer pregcomponent_type, 
			String ploguserid, String plogipaddress, String pregtype, String pold_course_code, 
			String pcalltype)
	{
		return courseRegistrationRepository.registration_insert_prc(psemsubid, pclassid, pregno, pcourseid, 
				pcomponent_type, pcourse_option, pregstatus, pregcomponent_type, ploguserid, plogipaddress, 
				pregtype, pold_course_code, pcalltype);
	}
	
	public String courseRegistrationUpdate(String psemsubid, String pregno, String pcourseid, String pcomponent_type,
			String pcourse_option, String poldclassid, String pnewclassid, String ploguserid, String plogipaddress,
			Integer pregstatus, Integer pregcomponent_type, String pregtype, String pold_course_code)
	{
		return courseRegistrationRepository.registration_update_prc(psemsubid, pregno, pcourseid, pcomponent_type,
				pcourse_option, poldclassid, pnewclassid, ploguserid, plogipaddress, pregstatus, pregcomponent_type, 
				pregtype, pold_course_code);
	}
	
	public String courseRegistrationDelete(String psemsubid, String pregno, String pcourseid, String pcalltype, 
			String ploguserid, String plogipaddress, String pregtype, String poldcoursecode)
	{
		return courseRegistrationRepository.registration_delete_prc(psemsubid, pregno, pcourseid, pcalltype, 
				ploguserid, plogipaddress, pregtype, poldcoursecode);
	}
	
	public List<Object[]> getCourseRegWlSlotByStudent(String semesterSubId, String registerNumber, 
			Integer patternId)
	{
		return courseRegistrationRepository.findCourseRegWlSlotByStudent(semesterSubId, registerNumber, 
				patternId);
	}
	
	public String getStudentCourseCancelCheck(List<String> registerNumber, String courseCode)
	{
		return courseRegistrationRepository.findStudentCourseCancelCheck(registerNumber, courseCode);
	}
	
	public Integer getRegisterNumberCreditsByCourse(String semesterSubId, String registerNumber, String courseId)
	{
		return courseRegistrationRepository.findRegisterNumberCreditsByCourse(semesterSubId, registerNumber, courseId);
	}

}
