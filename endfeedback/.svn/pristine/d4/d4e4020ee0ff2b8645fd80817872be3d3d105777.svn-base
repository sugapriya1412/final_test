package org.vtop.CourseRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vtop.CourseRegistration.repository.CompulsoryCourseConditionDetailRepository;

@Service
@Transactional("academicsTransactionManager")
public class CompulsoryCourseConditionDetailService {
	
	@Autowired 
	CompulsoryCourseConditionDetailRepository compulsoryCourseConditionDetailRepository;
	
	public List<String> getCompulsoryCourseList(Integer progGroupId, Integer studentBatch, 
			Integer studentSemester)
	{
		return compulsoryCourseConditionDetailRepository.findCompulsoryCourseList(progGroupId, 
				studentBatch, studentSemester);
	}
	
	public List<String> getSoftSkillCourseList(Integer progGroupId, Integer studentBatch, 
			Integer studentSemester)
	{
		return compulsoryCourseConditionDetailRepository.findSoftSkillCourseList(progGroupId, 
				studentBatch, studentSemester);
	}

}
