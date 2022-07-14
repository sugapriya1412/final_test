package org.vtop.CourseRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vtop.CourseRegistration.model.StudentHistoryModel;
import org.vtop.CourseRegistration.model.StudentHistoryPKModel;
import org.vtop.CourseRegistration.repository.StudentHistoryRepository;

@EnableJpaRepositories(basePackageClasses={StudentHistoryRepository.class},
entityManagerFactoryRef = "academicsEntityManagerFactory",
transactionManagerRef = "academicsTransactionManager")
@Service
@Transactional("academicsTransactionManager")
public class StudentHistoryService {
	
	@Autowired
	public StudentHistoryRepository studentHistoryRepository;
	
	public StudentHistoryModel getOne(StudentHistoryPKModel studentHistoryPKModel)
	{
		return studentHistoryRepository.findOne(studentHistoryPKModel);
	}
		
	public List<StudentHistoryModel> getAll()
	{
		return studentHistoryRepository.findAll();
	}
		
	public List<StudentHistoryModel> getByRegisterNumber(List<String> registerNumber)
	{
		return studentHistoryRepository.findByRegisterNumber(registerNumber);
	}
	
	public List<StudentHistoryModel> getByRegisterNumberCourseId(List<String> registerNumber, String courseId)
	{
		return studentHistoryRepository.findByRegisterNumberCourseId(registerNumber, courseId);
	}
	
	/*public StudentHistoryModel getStudentHistoryGrade(String[] registerNumber, String courseCode)
	{
		return studentHistoryRepository.findStudentHistoryGrade(registerNumber, courseCode);
	}*/
	
	public StudentHistoryModel getStudentHistoryGrade(List<String> registerNumber, String courseCode)
	{
		return studentHistoryRepository.findStudentHistoryGrade(registerNumber, courseCode);
	}
	
	public String getStudentHistoryDistinctGrade(List<String> registerNumber, String courseCode)
	{
		return studentHistoryRepository.findStudentHistoryDistinctGrade(registerNumber, courseCode);
	}
	
	public List<StudentHistoryModel> getStudentHistoryCEGrade(List<String> registerNumber, String courseId)
	{
		return studentHistoryRepository.findStudentHistoryCEGrade(registerNumber, courseId);
	}
	
	public List<Object[]> getStudentHistoryCEGrade2(List<String> registerNumber, String courseCode)
	{
		return studentHistoryRepository.findStudentHistoryCEGrade2(registerNumber, courseCode);
	}
	
	public List<StudentHistoryModel> getStudentHistoryPARequisite(List<String> registerNumber, String[] courseId)
	{
		return studentHistoryRepository.findStudentHistoryPARequisite(registerNumber, courseId);
	}
	
	public List<StudentHistoryModel> getStudentHistoryPARequisite2(List<String> registerNumber, List<String> courseId)
	{
		return studentHistoryRepository.findStudentHistoryPARequisite2(registerNumber, courseId);
	}
	
	public List<String> getStudentHistoryCourseType(List<String> registerNumber, String courseId)
	{
		return studentHistoryRepository.findStudentHistoryCourseType(registerNumber, courseId);
	}
	
	public String getStudentHistoryGenericCourseType(List<String> registerNumber, String courseCode)
	{
		return studentHistoryRepository.findStudentHistoryGenericCourseType(registerNumber, courseCode);
	}
	
	public List<StudentHistoryModel> getStudentHistoryCS(List<String> registerNumber, String courseCode)
	{
		return studentHistoryRepository.findStudentHistoryCS(registerNumber, courseCode);
	}
	
	public List<Object[]> getStudentHistoryCS2(List<String> registerNumber, String courseCode)
	{
		return studentHistoryRepository.findStudentHistoryCS2(registerNumber, courseCode);
	}
	
	public List<StudentHistoryModel> getStudentHistoryFailCourse(List<String> registerNumber)
	{
		return studentHistoryRepository.findStudentHistoryFailCourse(registerNumber);
	}
	
	public Integer getStudentHistoryFailCourseCredits(List<String> registerNumber)
	{
		return studentHistoryRepository.findStudentHistoryFailCourseCredits(registerNumber);
	}
	
	public List<Object[]> getStudentHistoryGrade2(List<String> registerNumber, String courseCode)
	{
		return studentHistoryRepository.findStudentHistoryGrade2(registerNumber, courseCode);
	}
	
	public List<Object[]> getStudentHistoryCEGrade3(List<String> registerNumber, String courseCode)
	{
		return studentHistoryRepository.findStudentHistoryCEGrade3(registerNumber, courseCode);
	}
	
	public List<Object[]> getStudentHistoryFailCourse2(List<String> registerNumber)
	{
		return studentHistoryRepository.findStudentHistoryFailCourse2(registerNumber);
	}

}
