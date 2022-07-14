package org.vtop.CourseRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.StudentCreditTransferModel;


@Repository
public interface StudentCreditTransferRepository extends JpaRepository<StudentCreditTransferModel,String> {
	
	StudentCreditTransferModel findByRegisterNumber(String registerNumber);

}
