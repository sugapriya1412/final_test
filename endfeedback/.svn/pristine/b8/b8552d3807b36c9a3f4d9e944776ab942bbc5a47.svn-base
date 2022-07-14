package org.vtop.CourseRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vtop.CourseRegistration.model.CourseOptionModel;
import org.vtop.CourseRegistration.repository.CourseOptionRepository;


/*@EnableJpaRepositories(basePackageClasses={CourseOptionRepository.class},
entityManagerFactoryRef = "academicsEntityManagerFactory",
transactionManagerRef = "academicsTransactionManager")*/
@Service
@Transactional("academicsTransactionManager")
public class CourseOptionService {
		
	@Autowired
	public CourseOptionRepository courseOptionRepository;
	
	public List<CourseOptionModel>getAll()
	{
		return courseOptionRepository.findAll();
	}
		
	public List <CourseOptionModel>getAllByOrderByCodeAsc(){
		
		return courseOptionRepository.findAllByOrderByCodeAsc();
	 }	
		
	public List <CourseOptionModel>getAllByOrderByCodeDesc(){			
			
			return courseOptionRepository.findAllByOrderByCodeDesc();	
	}	
	
	public CourseOptionModel getOne(String code)
	{
		return courseOptionRepository.findOne(code);
	}
	
} 
