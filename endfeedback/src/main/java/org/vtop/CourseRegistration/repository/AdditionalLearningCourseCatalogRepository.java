package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.AdditionalLearningCourseCatalogModel;
import org.vtop.CourseRegistration.model.AdditionalLearningCourseCatalogPkModel;

@Repository
public interface AdditionalLearningCourseCatalogRepository extends 
			JpaRepository<AdditionalLearningCourseCatalogModel, AdditionalLearningCourseCatalogPkModel> {
	
	@Query("select a from AdditionalLearningCourseCatalogModel a where a.status=0 "+
			"order by a.alccPkId.code, a.alccPkId.courseId")
	List<AdditionalLearningCourseCatalogModel> findAdditionalLearningCourse();
	
	@Query("select a from AdditionalLearningCourseCatalogModel a where a.alccPkId.code=?1 "+
			"and a.status=0 order by a.alccPkId.courseId")
	List<AdditionalLearningCourseCatalogModel> findAdditionalLearningCode(String code);
	
	@Query("select distinct a.alccPkId.code, a.additionalLearningDetailsModel.description from "+
			"AdditionalLearningCourseCatalogModel a where a.courseCatalogModel.code=?1 and a.status=0 and "+
			"a.additionalLearningDetailsModel.learningType='MIN' and a.additionalLearningDetailsModel.status=0 "+
			"order by a.alccPkId.code")
	List<Object> findMinorTitleByCourseCode(String courseCode);
	
	@Query("select distinct a.alccPkId.code, a.additionalLearningDetailsModel.description from "+
			"AdditionalLearningCourseCatalogModel a where a.courseCatalogModel.code=?1 and "+
			"(a.additionalLearningDetailsModel.description like '%('||?2||')' ) and a.status=0 and "+
			"a.additionalLearningDetailsModel.learningType='HON' and a.additionalLearningDetailsModel.status=0 "+
			"order by a.alccPkId.code")
	List<Object> findHonourTitleByCourseCode(String courseCode, String progSpecCode);

}
