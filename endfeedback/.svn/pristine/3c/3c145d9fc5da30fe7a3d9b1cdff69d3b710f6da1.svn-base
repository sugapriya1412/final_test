package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.CourseOptionModel;

@Repository
public interface CourseOptionRepository extends JpaRepository<CourseOptionModel,String> {

	List<CourseOptionModel> findAll();
	public List<CourseOptionModel> findAllByOrderByCodeAsc();	
	public List<CourseOptionModel> findAllByOrderByCodeDesc();
	
}
