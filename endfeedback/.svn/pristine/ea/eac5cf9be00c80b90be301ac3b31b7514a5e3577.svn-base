 package org.vtop.CourseRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vtop.CourseRegistration.model.CourseCatalogModel;
import org.vtop.CourseRegistration.repository.CourseCatalogRepository;

@EnableJpaRepositories(basePackageClasses={CourseCatalogRepository.class},
entityManagerFactoryRef = "academicsEntityManagerFactory",
transactionManagerRef = "academicsTransactionManager")
@Service
@Transactional("academicsTransactionManager")
public class CourseCatalogService {
		
	@Autowired
	public CourseCatalogRepository courseCatalogRepository;
		
	public CourseCatalogModel getOne(String courseId)
	{
		return courseCatalogRepository.findOne(courseId);
	}
	
	public List<CourseCatalogModel> getByCourseCode(String searchVal)
	{
		return courseCatalogRepository.findByCourseCode(searchVal);
	}
		
	public CourseCatalogModel getByCourseCodeAndVersion(String code, float courseVersion)
	{
		return courseCatalogRepository.findByCourseCodeAndVersion(code, courseVersion);
	}
		
	public List<CourseCatalogModel> getRegistrationCourseList(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode)
	{
		return courseCatalogRepository.findRegistrationCourseList(campusCode, courseSystem, 
				egbGroupId, groupCode);
	}
		
	public List<CourseCatalogModel> getRegistrationCourseList2(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType)
	{
		return courseCatalogRepository.findRegistrationCourseList2(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType);
	}
		
	//To get Course Owner's List
	public List<Object[]> getCourseCostCentre (String campus)
	{
		return courseCatalogRepository.findCourseCostCentre(campus);
	}
	
	//Pagination
	public Page<CourseCatalogModel> getAllPageable(Pageable pageable) {
		return courseCatalogRepository.findAll(pageable);
	}
	
	
	//Regular Course List
	public List<CourseCatalogModel> getRegularCourseList(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber)
	{
		return courseCatalogRepository.findRegularCourseList(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, registerNumber);
	}
	
	//Regular Course List Pagination with out search
	public Page<CourseCatalogModel> getRegularCoursePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, Pageable pageable)
	{
		return courseCatalogRepository.findRegularCoursePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, registerNumber, pageable);
	}
	
	//Regular Course List Pagination with Course Owner Search
	public Page<CourseCatalogModel> getRegularCourseOwnerPagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findRegularCourseOwnerPagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, registerNumber, 
				searchval, pageable);
	}
	
	//Regular Course List Pagination with Course Code Search
	public Page<CourseCatalogModel> getRegularCourseCodePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findRegularCourseCodePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, registerNumber, 
				searchval, pageable);
	}
	
	//Regular Course List Pagination with Course Title Search
	public Page<CourseCatalogModel> getRegularCourseTitlePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findRegularCourseTitlePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, registerNumber, 
				searchval, pageable);
	}
	
	
	//Re-register Course List
	public List<CourseCatalogModel> getRRCourseList(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber)
	{
		return courseCatalogRepository.findRRCourseList(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, registerNumber);
	}
	
	//Re-register Course List Pagination with out search
	public Page<CourseCatalogModel> getRRCoursePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, Pageable pageable)
	{
		return courseCatalogRepository.findRRCoursePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, registerNumber, pageable);
	}
	
	//Re-register Course List Pagination with Course Owner Search
	public Page<CourseCatalogModel> getRRCourseOwnerPagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findRRCourseOwnerPagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, registerNumber, 
				searchval, pageable);
	}
		
	//Re-register Course List Pagination with Course Code Search
	public Page<CourseCatalogModel> getRRCourseCodePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findRRCourseCodePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, registerNumber, 
				searchval, pageable);
	}
	
	//Re-register Course List Pagination with Course Title Search
	public Page<CourseCatalogModel> getRRCourseTitlePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findRRCourseTitlePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, registerNumber, 
				searchval, pageable);
	}
	
	
	//Grade Improvement Course List
	public List<CourseCatalogModel> getGICourseList(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber)
	{
		return courseCatalogRepository.findGICourseList(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, registerNumber);
	}
	
	//Grade Improvement Course List Pagination with out search
	public Page<CourseCatalogModel> getGICoursePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, Pageable pageable)
	{
		return courseCatalogRepository.findGICoursePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, registerNumber, pageable);
	}
	
	//Grade Improvement Course List Pagination with Course Owner Search
	public Page<CourseCatalogModel> getGICourseOwnerPagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findGICourseOwnerPagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, registerNumber, 
				searchval, pageable);
	}
		
	//Grade Improvement Course List Pagination with Course Code Search
	public Page<CourseCatalogModel> getGICourseCodePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findGICourseCodePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, registerNumber, 
				searchval, pageable);
	}
	
	//Grade Improvement Course List Pagination with Course Title Search
	public Page<CourseCatalogModel> getGICourseTitlePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findGICourseTitlePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, registerNumber, 
				searchval, pageable);
	}
	
	//FFCS to CAL Course Equivalence Course List
	public List<CourseCatalogModel> getCALToFFCSCEList(String campusCode, List<Integer> egbGroupId, 
			String groupCode, String semesterSubId, String[] classGroupId, String[] classType)
	{
		return courseCatalogRepository.findCALToFFCSCEList(campusCode, egbGroupId, 
				groupCode, semesterSubId, classGroupId, classType);
	}
	
	//FFCS to CAL Course Equivalence Course List Pagination with out search
	public Page<CourseCatalogModel> getCALToFFCSCEPagination(String campusCode, List<Integer> egbGroupId, 
			String groupCode, String semesterSubId, String[] classGroupId, String[] classType, Pageable pageable)
	{
		return courseCatalogRepository.findCALToFFCSCEPagination(campusCode, egbGroupId, groupCode, 
				semesterSubId, classGroupId, classType, pageable);
	}
	
	//FFCS to CAL Course Equivalence Course List Pagination with Course Owner Search
	public Page<CourseCatalogModel> getCALToFFCSCECourseOwnerPagination(String campusCode, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findCALToFFCSCECourseOwnerPagination(campusCode, egbGroupId, 
				groupCode, semesterSubId, classGroupId, classType, searchval, pageable);
	}
		
	//FFCS to CAL Course Equivalence Course List Pagination with Course Code Search
	public Page<CourseCatalogModel> getCALToFFCSCECourseCodePagination(String campusCode, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findCALToFFCSCECourseCodePagination(campusCode, egbGroupId, 
				groupCode, semesterSubId, classGroupId, classType, searchval, pageable);
	}
		
	//FFCS to CAL Course Equivalence Course List Pagination with Course Title Search
	public Page<CourseCatalogModel> getCALToFFCSCECourseTitlePagination(String campusCode, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findCALToFFCSCECourseTitlePagination(campusCode, egbGroupId, 
				groupCode, semesterSubId, classGroupId, classType, searchval, pageable);
	}
	
	//Additional Learning Pagination
	public Page<CourseCatalogModel> getAdditinalLearningCoursePagination(String campusCode, 
			String[] courseSystem, List<Integer> egbGroupId, String groupCode, String semesterSubId, 
			String[] classGroupId, String[] classType, String code, Pageable pageable)
	{
		return courseCatalogRepository.findAdditinalLearningCoursePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, code, pageable);
	}
	
	//Compulsory Course Pagination
	public Page<CourseCatalogModel> getCompulsoryCoursePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, List<String> courseCode, Pageable pageable)
	{
		return courseCatalogRepository.findCompulsoryCoursePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, courseCode, pageable);
	}
	
	public boolean isExist(String courseId)
	{
		return courseCatalogRepository.exists(courseId);
	}
	
	
	//Curriculum based course display - PC/ PE/ UC
	public List<CourseCatalogModel> getCurriculumPCPEUCList(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, Integer specId, Integer studYear, String courseCategory, 
			Float curriculumVersion)
	{
		return courseCatalogRepository.findCurriculumPCPEUCList(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, specId, 
				studYear, courseCategory, curriculumVersion);
	}
	
	//Curriculum based course display Pagination with out Search - PC/ PE/ UC
	public Page<CourseCatalogModel> getCurriculumPCPEUCPagination(String campusCode, 
			String[] courseSystem, List<Integer> egbGroupId, String groupCode, String semesterSubId, 
			String[] classGroupId, String[] classType, Integer specId, Integer studYear, 
			String courseCategory, Float curriculumVersion, Pageable pageable)
	{
		return courseCatalogRepository.findCurriculumPCPEUCPagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, specId, studYear, 
				courseCategory, curriculumVersion, pageable);
	}
	
	//Curriculum based course display Pagination with Course Owner Search - PC/ PE/ UC
	public Page<CourseCatalogModel> getCurriculumPCPEUCCourseOwnerPagination(String campusCode, 
			String[] courseSystem, List<Integer> egbGroupId, String groupCode, String semesterSubId, 
			String[] classGroupId, String[] classType, Integer specId, Integer studYear, 
			String courseCategory, Float curriculumVersion, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findCurriculumPCPEUCCourseOwnerPagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, specId, studYear, 
				courseCategory, curriculumVersion, searchval, pageable);
	}
	
	//Curriculum based course display Pagination with Course Code Search - PC/ PE/ UC
	public Page<CourseCatalogModel> getCurriculumPCPEUCCourseCodePagination(String campusCode, 
			String[] courseSystem, List<Integer> egbGroupId, String groupCode, String semesterSubId, 
			String[] classGroupId, String[] classType, Integer specId, Integer studYear, 
			String courseCategory, Float curriculumVersion, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findCurriculumPCPEUCCourseCodePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, specId, studYear, 
				courseCategory, curriculumVersion, searchval, pageable);
	}
	
	//Curriculum based course display Pagination with Course Title Search - PC/ PE/ UC
	public Page<CourseCatalogModel> getCurriculumPCPEUCCourseTitlePagination(String campusCode, 
			String[] courseSystem, List<Integer> egbGroupId, String groupCode, String semesterSubId, 
			String[] classGroupId, String[] classType, Integer specId, Integer studYear, 
			String courseCategory, Float curriculumVersion, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findCurriculumPCPEUCCourseTitlePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, specId, studYear, 
				courseCategory, curriculumVersion, searchval, pageable);
	}
	
	
	//Curriculum based course display - UE
	public List<CourseCatalogModel> getCurriculumUEList(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, Integer specId, Integer studYear, Float curriculumVersion)
	{
		return courseCatalogRepository.findCurriculumUEList(campusCode, courseSystem, egbGroupId, 
				groupCode, semesterSubId, classGroupId, classType, specId, studYear, curriculumVersion);
	}
	
	//Curriculum based course pagination with out search - UE
	public Page<CourseCatalogModel> getCurriculumUEPagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, Integer specId, Integer studYear, Float curriculumVersion, Pageable pageable)
	{
		return courseCatalogRepository.findCurriculumUEPagination(campusCode, courseSystem, egbGroupId, 
				groupCode, semesterSubId, classGroupId, classType, specId, studYear, curriculumVersion, pageable);
	}
	
	//Curriculum based course pagination with Course Owner search - UE
	public Page<CourseCatalogModel> getCurriculumUECourseOwnerPagination(String campusCode, 
			String[] courseSystem, List<Integer> egbGroupId, String groupCode, String semesterSubId, 
			String[] classGroupId, String[] classType, Integer specId, Integer studYear, 
			Float curriculumVersion, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findCurriculumUECourseOwnerPagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, specId, studYear, 
				curriculumVersion, searchval, pageable);
	}
	
	//Curriculum based course pagination with Course Code search - UE
	public Page<CourseCatalogModel> getCurriculumUECourseCodePagination(String campusCode, 
			String[] courseSystem, List<Integer> egbGroupId, String groupCode, String semesterSubId, 
			String[] classGroupId, String[] classType, Integer specId, Integer studYear, 
			Float curriculumVersion, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findCurriculumUECourseCodePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, specId, studYear, 
				curriculumVersion, searchval, pageable);
	}
	
	//Curriculum based course pagination with Course Title search - UE
	public Page<CourseCatalogModel> getCurriculumUECourseTitlePagination(String campusCode, 
			String[] courseSystem, List<Integer> egbGroupId, String groupCode, String semesterSubId, 
			String[] classGroupId, String[] classType, Integer specId, Integer studYear, 
			Float curriculumVersion, String searchval, Pageable pageable)
	{
		return courseCatalogRepository.findCurriculumUECourseTitlePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, specId, studYear, 
				curriculumVersion, searchval, pageable);
	}
	
	//Soft Skill Courses - CAL
	public Page<CourseCatalogModel> getCALSoftSkillCoursePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, List<String> courseCode, Pageable pageable)
	{
		return courseCatalogRepository.findCALSoftSkillCoursePagination(campusCode, courseSystem, 
				egbGroupId, groupCode, semesterSubId, classGroupId, classType, courseCode, pageable);
	}
	
	//Soft Skill Courses - FFCS & CAL
	public Page<CourseCatalogModel> getFFCSSoftSkillCoursePagination(String campusCode, List<Integer> egbGroupId, 
			String groupCode, String semesterSubId, String[] classGroupId, String[] classType, 
			List<String> courseCode, Pageable pageable)
	{
		return courseCatalogRepository.findFFCSSoftSkillCoursePagination(campusCode, egbGroupId, groupCode, 
				semesterSubId, classGroupId, classType, courseCode, pageable);
	}
		
}
