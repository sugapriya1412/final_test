package org.vtop.CourseRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vtop.CourseRegistration.model.AdditionalLearningCourseCatalogModel;
import org.vtop.CourseRegistration.model.AdditionalLearningCourseCatalogPkModel;
import org.vtop.CourseRegistration.repository.AdditionalLearningCourseCatalogRepository;

@EnableJpaRepositories(basePackageClasses={AdditionalLearningCourseCatalogRepository.class},
entityManagerFactoryRef = "academicsEntityManagerFactory",
transactionManagerRef = "academicsTransactionManager")
@Service
@Transactional("academicsTransactionManager")
public class AdditionalLearningCourseCatalogService {
	
	@Autowired
	public AdditionalLearningCourseCatalogRepository additionalLearningCourseCatalogRepository;
	
	public AdditionalLearningCourseCatalogModel getOne(AdditionalLearningCourseCatalogPkModel additionalLearningCourseCatalogPkModel)
	{
		return additionalLearningCourseCatalogRepository.findOne(additionalLearningCourseCatalogPkModel);
	}
	
	public List<AdditionalLearningCourseCatalogModel> getAdditionalLearningCourse()
	{
		return additionalLearningCourseCatalogRepository.findAdditionalLearningCourse();
	}
	
	public List<AdditionalLearningCourseCatalogModel> getAdditionalLearningCode(String code)
	{
		return additionalLearningCourseCatalogRepository.findAdditionalLearningCode(code);
	}
	
	public List<Object> getMinorTitleByCourseCode(String courseCode)
	{
		return additionalLearningCourseCatalogRepository.findMinorTitleByCourseCode(courseCode);
	}
	
	public List<Object> getHonourTitleByCourseCode(String courseCode, String progSpecCode)
	{
		return additionalLearningCourseCatalogRepository.findHonourTitleByCourseCode(courseCode, progSpecCode);
	}

}
