package org.vtop.CourseRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.StudentsLoginDetailsModel;

@Repository
public interface StudentLoginDetailsRepository extends JpaRepository<StudentsLoginDetailsModel, String>{

	StudentsLoginDetailsModel findByRegNoAndCostCentre(String registerNumber, Integer costCentre);
	
	
}
