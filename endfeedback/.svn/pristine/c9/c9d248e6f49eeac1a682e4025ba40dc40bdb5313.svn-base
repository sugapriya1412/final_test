package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.CurriculumProgramModel;
import org.vtop.CourseRegistration.model.CurriculumProgramModelPK;



@Repository
public interface CurriculumProgramRepository extends JpaRepository<CurriculumProgramModel,CurriculumProgramModelPK> {

	List<CurriculumProgramModel> findAll();
	CurriculumProgramModel findByCpmPkIdAndStatus(CurriculumProgramModelPK curriculumProgramPK, int status);
}
