package org.vtop.CourseRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vtop.CourseRegistration.repository.BridgeCourseConditionDetailRepository;

@Service
@Transactional("academicsTransactionManager")
public class BridgeCourseConditionDetailService {
	
	@Autowired
	BridgeCourseConditionDetailRepository bridgeCourseConditionDetailRepository;
	
	//For EPT Result
	String getEPTResultByRegisterNumber(List<String> registerNumber)
	{
		return bridgeCourseConditionDetailRepository.findEPTResultByRegisterNumber(registerNumber);
	}
	
	//For PCMB status from Academics Schema (i.e. PCMB, PCM, PCB, etc.)
	String getPCMBStatusByRegisterNumber(List<String> registerNumber)
	{
		return bridgeCourseConditionDetailRepository.findPCMBStatusByRegisterNumber(registerNumber);
	}
		
	//For PCMB status from Admissions Schema (i.e. PCMB, PCM, PCB, etc.)
	String getPCMBStatusFromAdmissionsByRegisterNumber(String registerNumber)
	{
		return bridgeCourseConditionDetailRepository.findPCMBStatusFromAdmissionsByRegisterNumber(registerNumber);
	}
	
}
