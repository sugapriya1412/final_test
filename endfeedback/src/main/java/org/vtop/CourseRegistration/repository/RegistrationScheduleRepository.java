package org.vtop.CourseRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.RegistrationScheduleModel;


@Repository
public interface RegistrationScheduleRepository extends JpaRepository<RegistrationScheduleModel,String> {

}
