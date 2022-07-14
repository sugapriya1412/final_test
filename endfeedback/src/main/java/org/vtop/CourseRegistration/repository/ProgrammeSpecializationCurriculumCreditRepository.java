package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.ProgrammeSpecializationCurriculumCreditModel;
import org.vtop.CourseRegistration.model.ProgrammeSpecializationCurriculumCreditPKModel;

@Repository
public interface ProgrammeSpecializationCurriculumCreditRepository extends JpaRepository<ProgrammeSpecializationCurriculumCreditModel, ProgrammeSpecializationCurriculumCreditPKModel> {
	
	@Query("select a from ProgrammeSpecializationCurriculumCreditModel a order by "+
			"a.pscccPkId.specializationId, a.pscccPkId.admissionYear desc, a.pscccPkId.curriculumVersion")
	List<ProgrammeSpecializationCurriculumCreditModel> findAll();
	
	@Query("select a from ProgrammeSpecializationCurriculumCreditModel a where a.pscccPkId.specializationId=?1 "+
			"order by a.pscccPkId.admissionYear desc, a.pscccPkId.curriculumVersion")
	List<ProgrammeSpecializationCurriculumCreditModel> findBySpecId(Integer specId);
	
	@Query("select a from ProgrammeSpecializationCurriculumCreditModel a where a.pscccPkId.specializationId=?1 "+
			"and a.pscccPkId.admissionYear=?2 order by a.pscccPkId.curriculumVersion")
	List<ProgrammeSpecializationCurriculumCreditModel> findBySpecIdAdmYear(Integer specId, Integer admissionYear);
	
	@Query("select a from ProgrammeSpecializationCurriculumCreditModel a where a.pscccPkId.specializationId=?1 "+
			"and a.pscccPkId.admissionYear=?2 and a.pscccPkId.curriculumVersion="+
			"(select max(a.pscccPkId.curriculumVersion) from ProgrammeSpecializationCurriculumCreditModel a "+
			"where a.pscccPkId.specializationId=?1 and a.pscccPkId.admissionYear=?2)")
	ProgrammeSpecializationCurriculumCreditModel findMaxVerDetailBySpecIdAndAdmYear(Integer specId, Integer admissionYear);
		
}
