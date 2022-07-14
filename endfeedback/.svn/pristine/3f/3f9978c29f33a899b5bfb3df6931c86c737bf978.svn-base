package org.vtop.CourseRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vtop.CourseRegistration.model.ActivityDetailsModel;
import org.vtop.CourseRegistration.model.ActivityDetailsModelPK;
import org.vtop.CourseRegistration.repository.ActivityDetailsRepository;

/*@EnableJpaRepositories(basePackageClasses={ActivityDetailsRepository.class},
entityManagerFactoryRef = "academicsEntityManagerFactory",
transactionManagerRef = "academicsTransactionManager")*/
@Service
@Transactional("academicsTransactionManager")
public class ActivityDetailsService {
	
	@Autowired ActivityDetailsRepository activitydetailsrepository;
	
	/* Get One */
	public ActivityDetailsModel getOne(ActivityDetailsModelPK activitydetailsmodelpk)
	{
		return activitydetailsrepository.findOne(activitydetailsmodelpk);
		 
	}
	
	/*Display Data in Desc order*/
	public List<ActivityDetailsModel> getAllDesc()
	{
		return activitydetailsrepository.getAllDesc();
	}
	
	/*Display Activity Details*/
	public List<ActivityDetailsModel> getall()
	{
		return activitydetailsrepository.findAll();
	}
	
	public ActivityDetailsModel getByAcvityIdAndStatus()
	{
		return activitydetailsrepository.findByAcvityIdAndStatus();
	}
		
}
