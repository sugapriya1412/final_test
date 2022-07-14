package org.vtop.CourseRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vtop.CourseRegistration.model.ProgrammeSpecializationCurriculumDetailModel;
import org.vtop.CourseRegistration.model.ProgrammeSpecializationCurriculumDetailPKModel;
import org.vtop.CourseRegistration.repository.ProgrammeSpecializationCurriculumDetailRepository;

/*@EnableJpaRepositories(basePackageClasses={ProgrammeSpecializationCurriculumDetailRepository.class},
entityManagerFactoryRef = "academicsEntityManagerFactory",
transactionManagerRef = "academicsTransactionManager")*/
@Service
@Transactional("academicsTransactionManager")
public class ProgrammeSpecializationCurriculumDetailService {
	
	@Autowired
	public ProgrammeSpecializationCurriculumDetailRepository programmeSpecializationCurriculumDetailRepository;
				
	public ProgrammeSpecializationCurriculumDetailModel getOne(ProgrammeSpecializationCurriculumDetailPKModel programmeSpecializationCurriculumDetailPKModel)
	{
		return programmeSpecializationCurriculumDetailRepository.findOne(programmeSpecializationCurriculumDetailPKModel);
	}
		
	public List<ProgrammeSpecializationCurriculumDetailModel>getAll()
	{
		return programmeSpecializationCurriculumDetailRepository.findAll();
	}
			
	public List<ProgrammeSpecializationCurriculumDetailModel> getBySpecId(Integer specId)
	{
		return programmeSpecializationCurriculumDetailRepository.findBySpecId(specId);
	}
	
	public List<ProgrammeSpecializationCurriculumDetailModel> getBySpecIdAdmYear(Integer specId, Integer admissionYear)
	{
		return programmeSpecializationCurriculumDetailRepository.findBySpecIdAdmYear(specId, admissionYear);
	}
	
	public List<ProgrammeSpecializationCurriculumDetailModel> getBySpecIdAdmYearCCVersion(Integer specId, 
			Integer admissionYear, Float ccVersion)
	{
		return programmeSpecializationCurriculumDetailRepository.findBySpecIdAdmYearCCVersion(specId, admissionYear, ccVersion);
	}

}
