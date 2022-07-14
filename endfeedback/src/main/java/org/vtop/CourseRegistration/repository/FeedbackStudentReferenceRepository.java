package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.FeedbackStudentReferenceModel;
import org.vtop.CourseRegistration.model.FeedbackStudentReferencePKModel;

@Repository
public interface FeedbackStudentReferenceRepository extends JpaRepository
			<FeedbackStudentReferenceModel, FeedbackStudentReferencePKModel> {
	
	@Query("select a from FeedbackStudentReferenceModel a where a.fbsrPkId.semesterSubId=?1 and "+
			"a.fbsrPkId.feedbackType=?2 and a.fbsrPkId.classId=?3 order by a.fbsrPkId.registerNumber")
	List<FeedbackStudentReferenceModel> getReferenceByTypeAndClassId(String semesterSubId, 
			String feedbackType, String classId);
	
	@Query("select a from FeedbackStudentReferenceModel a where a.fbsrPkId.semesterSubId=?1 and "+
			"a.fbsrPkId.feedbackType=?2 and a.fbsrPkId.registerNumber=?3 order by a.fbsrPkId.classId")
	List<FeedbackStudentReferenceModel> getReferenceByTypeAndRegisterNo(String semesterSubId, 
			String feedbackType, String registerNumber);
	
	@Query("select a.fbsrPkId.classId from FeedbackStudentReferenceModel a where a.fbsrPkId.semesterSubId=?1 "+
			"and a.fbsrPkId.feedbackType=?2 and a.fbsrPkId.registerNumber=?3 order by a.fbsrPkId.classId")
	List<String> getReferenceClassIdByTypeAndRegisterNo(String semesterSubId, String feedbackType, 
			String registerNumber);
	
	@Query("select a from FeedbackStudentReferenceModel a where a.fbsrPkId.semesterSubId=?1 and "+
			"a.fbsrPkId.feedbackType=?2 and a.fbsrPkId.classId=?3 and a.fbsrPkId.registerNumber=?4")
	FeedbackStudentReferenceModel getReferenceByTypeClassIdAndRegisterNo(String semesterSubId, 
			String feedbackType, String classId, String registerNumber);
	
	@Modifying
	@Query("update FeedbackStudentReferenceModel a set a.feedbackGiven=?5 where a.fbsrPkId.semesterSubId=?1 and "+
			"a.fbsrPkId.feedbackType=?2 and a.fbsrPkId.classId=?3 and a.fbsrPkId.registerNumber=?4")
	void updateReferenceStatusByTypeClassIdAndRegisterNo(String semesterSubId, String feedbackType, String classId, 
			String registerNumber, int fbStatus);

}
