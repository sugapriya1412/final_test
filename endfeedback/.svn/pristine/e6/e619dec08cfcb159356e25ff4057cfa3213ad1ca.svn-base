package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.FeedbackQuestionModel;
import org.vtop.CourseRegistration.model.FeedbackQuestionPKModel;

@Repository
public interface FeedbackQuestionRepository extends JpaRepository<FeedbackQuestionModel, FeedbackQuestionPKModel> {
	
	@Query("select a from FeedbackQuestionModel a where a.fbqPkId.feedbackPattern=?1 and "+
			"a.fbqPkId.courseType=?2 order by a.fbqPkId.questionNumber")
	List<FeedbackQuestionModel> getQuestionByPatternAndType(Integer feedbackPattern, String courseType);
	
	@Query("select a from FeedbackQuestionModel a where a.fbqPkId.feedbackPattern=?1 and "+
			"a.fbqPkId.courseType=?2 and a.fbqPkId.questionNumber=?3")
	FeedbackQuestionModel getQuestionByPatternTypeAndNo(Integer feedbackPattern, 
			String courseType, String questionNumber);
	
	
	@Query(value="select decode(SUBSTR(QUESTION_NUMBER,1,3),'FBS',2,1) as fbAnsType, QUESTION_NUMBER, "+
					"QUESTION_TEXT, QUESTION_CATEGORY from ACADEMICS.FEEDBACK_QUESTIONS where "+
					"FEEDBACK_PATTERN=?1 and COURSE_TYPE=?2 order by fbAnsType, "+
					"QUESTION_NUMBER", nativeQuery=true)
	List<Object[]> getQuestionByPatternAndType2(Integer feedbackPattern, String courseType);

}
