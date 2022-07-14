package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.vtop.CourseRegistration.model.FeedbackGeneralAnswersModel;
import org.vtop.CourseRegistration.model.FeedbackGeneralAnswersPKModel;

@Repository
@Transactional
public interface FeedbackGeneralAnswerRepository extends JpaRepository<FeedbackGeneralAnswersModel, FeedbackGeneralAnswersPKModel>
{	
	@Query("select a from FeedbackGeneralAnswersModel a where a.fbgaPkId.semesterSubId=?1 and "+
			"a.fbgaPkId.feedbackType=?2 order by a.fbgaPkId.fbSlNo")
	List<FeedbackGeneralAnswersModel> findAnswerByTypeAndClassId(String semesterSubId, String feedbackType);
	
	@Query("select a from FeedbackGeneralAnswersModel a where a.fbgaPkId.semesterSubId=?1 and "+
			"a.fbgaPkId.feedbackType=?2 and a.fbgaPkId.fbSlNo=?3")
	FeedbackGeneralAnswersModel findAnswerByTypeClassIdAndSlno(String semesterSubId, String feedbackType, 
			Long fbSlNo);
}
