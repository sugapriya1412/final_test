package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.ProgrammeSpecializationCurriculumDetailModel;
import org.vtop.CourseRegistration.model.ProgrammeSpecializationCurriculumDetailPKModel;

@Repository
public interface ProgrammeSpecializationCurriculumDetailRepository extends 
	JpaRepository<ProgrammeSpecializationCurriculumDetailModel, ProgrammeSpecializationCurriculumDetailPKModel> {
	
	@Query("select a from ProgrammeSpecializationCurriculumDetailModel a order by "+
			"a.psccdPkId.specializationId, a.psccdPkId.admissionYear desc, a.psccdPkId.curriculumVersion, "+
			"a.courseCategory, a.catalogType, a.psccdPkId.courseBasketId")
	List<ProgrammeSpecializationCurriculumDetailModel> findAll();
	
	@Query("select a from ProgrammeSpecializationCurriculumDetailModel a where a.psccdPkId.specializationId=?1 "+
			"order by a.psccdPkId.admissionYear desc, a.psccdPkId.curriculumVersion, a.courseCategory, "+
			"a.catalogType, a.psccdPkId.courseBasketId")
	List<ProgrammeSpecializationCurriculumDetailModel> findBySpecId(Integer specId);
	
	@Query("select a from ProgrammeSpecializationCurriculumDetailModel a where a.psccdPkId.specializationId=?1 "+
			"and a.psccdPkId.admissionYear=?2 order by a.psccdPkId.curriculumVersion, a.courseCategory, "+
			"a.catalogType, a.psccdPkId.courseBasketId")
	List<ProgrammeSpecializationCurriculumDetailModel> findBySpecIdAdmYear(Integer specId, Integer admissionYear);
	
	@Query("select a from ProgrammeSpecializationCurriculumDetailModel a where a.psccdPkId.specializationId=?1 "+
			"and a.psccdPkId.admissionYear=?2 and a.psccdPkId.curriculumVersion=?3 order by a.courseCategory, "+
			"a.catalogType, a.psccdPkId.courseBasketId")
	List<ProgrammeSpecializationCurriculumDetailModel> findBySpecIdAdmYearCCVersion(Integer specId, 
			Integer admissionYear, Float ccVersion);
		
}
