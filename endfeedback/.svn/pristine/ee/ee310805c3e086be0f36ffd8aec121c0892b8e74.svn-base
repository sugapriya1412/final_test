package org.vtop.CourseRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vtop.CourseRegistration.model.ProgrammeSpecializationCurriculumCreditModel;
import org.vtop.CourseRegistration.model.ProgrammeSpecializationCurriculumCreditPKModel;
import org.vtop.CourseRegistration.repository.ProgrammeSpecializationCurriculumCreditRepository;

/*@EnableJpaRepositories(basePackageClasses={ProgrammeSpecializationCurriculumCreditRepository.class},
entityManagerFactoryRef = "academicsEntityManagerFactory",
transactionManagerRef = "academicsTransactionManager")*/
@Service
@Transactional("academicsTransactionManager")
public class ProgrammeSpecializationCurriculumCreditService {
		
	@Autowired
	public ProgrammeSpecializationCurriculumCreditRepository programmeSpecializationCurriculumCreditRepository;
				
	public ProgrammeSpecializationCurriculumCreditModel getOne(ProgrammeSpecializationCurriculumCreditPKModel programmeSpecializationCurriculumCreditPKModel)
	{
		return programmeSpecializationCurriculumCreditRepository.findOne(programmeSpecializationCurriculumCreditPKModel);
	}
		
	public List<ProgrammeSpecializationCurriculumCreditModel> getAll()
	{
		return programmeSpecializationCurriculumCreditRepository.findAll();
	}
		
	public List<ProgrammeSpecializationCurriculumCreditModel> getBySpecId(Integer specId)
	{
		return programmeSpecializationCurriculumCreditRepository.findBySpecId(specId);
	}
	
	public List<ProgrammeSpecializationCurriculumCreditModel> getBySpecIdAdmYear(Integer specId, Integer admissionYear)
	{
		return programmeSpecializationCurriculumCreditRepository.findBySpecIdAdmYear(specId, admissionYear);
	}
	
	public ProgrammeSpecializationCurriculumCreditModel getMaxVerDetailBySpecIdAndAdmYear(Integer specId, Integer admissionYear)
	{
		return programmeSpecializationCurriculumCreditRepository.findMaxVerDetailBySpecIdAndAdmYear(specId, admissionYear);
	}

}
