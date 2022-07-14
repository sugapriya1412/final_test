package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.SemesterDetailsModel;

@Repository
public interface SemesterDetailsRepository extends JpaRepository<SemesterDetailsModel, String> {

  List<SemesterDetailsModel> findAll();  
  List<SemesterDetailsModel> findByStatus(Integer status);
  List<SemesterDetailsModel> findAllByOrderBySemesterSubIdAsc();
  List<SemesterDetailsModel> findAllByOrderBySemesterSubIdDesc();
  
}