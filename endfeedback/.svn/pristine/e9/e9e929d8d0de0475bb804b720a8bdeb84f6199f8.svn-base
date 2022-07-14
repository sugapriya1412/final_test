package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.BridgeCourseConditionDetailModel;


@Repository
public interface BridgeCourseConditionDetailRepository extends JpaRepository<BridgeCourseConditionDetailModel,Integer> {
	
	//For EPT Result
	@Query(value="select nvl(result,'NONE') from academics.STUDENT_EPT_DETAILS where "+
					"STDNTSLGNDTLS_REGISTER_NUMBER in (?1)", nativeQuery=true)
	String findEPTResultByRegisterNumber(List<String> registerNumber);
	
	//For PCMB status from Academics Schema (i.e. PCMB, PCM, PCB, etc.)
	@Query(value="select nvl(HSC_GROUP,'NONE') from academics.STUDENT_BRIDGE_COURSE_DETAIL "+
					"where REGNO in (?1)", nativeQuery=true)
	String findPCMBStatusByRegisterNumber(List<String> registerNumber);
	
	//For PCMB status from Admissions Schema (i.e. PCMB, PCM, PCB, etc.)
	@Query(value="select nvl(b.ELIGIBILITY_CODE,'NONE') from admissions.STUDENTS_LOGIN_DETAILS a, "+
					"admissions.STUDENT_BASE b where a.REG_NO=?1 and a.APPLICATION_NO=b.APPLICATION_NUMBER", 
					nativeQuery=true)
	String findPCMBStatusFromAdmissionsByRegisterNumber(String registerNumber);

}
