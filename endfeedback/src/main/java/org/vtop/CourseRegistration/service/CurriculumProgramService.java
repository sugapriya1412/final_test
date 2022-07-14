package org.vtop.CourseRegistration.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vtop.CourseRegistration.model.CurriculumProgramModel;
import org.vtop.CourseRegistration.model.CurriculumProgramModelPK;
import org.vtop.CourseRegistration.repository.CurriculumProgramRepository;


@Service
@Transactional("academicsTransactionManager")
public class CurriculumProgramService {
	
	@Autowired
	CurriculumProgramRepository curriculumProgramRepository;	
	
	public CurriculumProgramModel getByIdAndStatus(CurriculumProgramModelPK curriculumProgramModelPK,int status){
		return curriculumProgramRepository.findByCpmPkIdAndStatus(curriculumProgramModelPK, status);
	}
	
	public boolean isExist(CurriculumProgramModelPK curriculumProgramModelPK)
	{
		return curriculumProgramRepository.exists(curriculumProgramModelPK);
	}
	

}
