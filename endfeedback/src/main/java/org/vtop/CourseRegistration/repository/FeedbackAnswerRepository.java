package org.vtop.CourseRegistration.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.vtop.CourseRegistration.model.FeedbackAnswerModel;
import org.vtop.CourseRegistration.model.FeedbackAnswerPkModel;

@Repository
@Transactional
public interface FeedbackAnswerRepository extends JpaRepository<FeedbackAnswerModel, FeedbackAnswerPkModel> {
	
	@Query("select a from FeedbackAnswerModel a where a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 "+
			"and a.fbaPkId.classId=?3 order by a.fbaPkId.fbSlNo")
	List<FeedbackAnswerModel> getAnswerByTypeAndClassId(String semesterSubId, String feedbackType, String classId);
	
	@Query("select a from FeedbackAnswerModel a where a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 "+
			"and a.fbaPkId.classId=?3 and a.fbaPkId.fbSlNo=?4")
	FeedbackAnswerModel getAnswerByTypeClassIdAndSlno(String semesterSubId, String feedbackType, String classId, 
			Long fbSlNo);
	
	
	//Rating Update
	@Modifying
	@Query("update FeedbackAnswerModel a set fba01=?5, logTimestamp=?6, logIpaddress=?7 where "+
			"a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 and a.fbaPkId.classId=?3 and a.fbaPkId.fbSlNo=?4")
	void updateRatingAnswer01(String semesterSubId, String feedbackType, String classId, 
			Long fbSlNo, int fbRating, Date logTimeStamp, String logIpaddress);
	
	@Modifying
	@Query("update FeedbackAnswerModel a set fba02=?5, logTimestamp=?6, logIpaddress=?7 where "+
			"a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 and a.fbaPkId.classId=?3 and a.fbaPkId.fbSlNo=?4")
	void updateRatingAnswer02(String semesterSubId, String feedbackType, String classId, 
			Long fbSlNo, int fbRating, Date logTimeStamp, String logIpaddress);
	
	@Modifying
	@Query("update FeedbackAnswerModel a set fba03=?5, logTimestamp=?6, logIpaddress=?7 where "+
			"a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 and a.fbaPkId.classId=?3 and a.fbaPkId.fbSlNo=?4")
	void updateRatingAnswer03(String semesterSubId, String feedbackType, String classId, 
			Long fbSlNo, int fbRating, Date logTimeStamp, String logIpaddress);
	
	@Modifying
	@Query("update FeedbackAnswerModel a set fba04=?5, logTimestamp=?6, logIpaddress=?7 where "+
			"a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 and a.fbaPkId.classId=?3 and a.fbaPkId.fbSlNo=?4")
	void updateRatingAnswer04(String semesterSubId, String feedbackType, String classId, 
			Long fbSlNo, int fbRating, Date logTimeStamp, String logIpaddress);
	
	@Modifying
	@Query("update FeedbackAnswerModel a set fba05=?5, logTimestamp=?6, logIpaddress=?7 where "+
			"a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 and a.fbaPkId.classId=?3 and a.fbaPkId.fbSlNo=?4")
	void updateRatingAnswer05(String semesterSubId, String feedbackType, String classId, 
			Long fbSlNo, int fbRating, Date logTimeStamp, String logIpaddress);
	
	@Modifying
	@Query("update FeedbackAnswerModel a set fba06=?5, logTimestamp=?6, logIpaddress=?7 where "+
			"a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 and a.fbaPkId.classId=?3 and a.fbaPkId.fbSlNo=?4")
	void updateRatingAnswer06(String semesterSubId, String feedbackType, String classId, 
			Long fbSlNo, int fbRating, Date logTimeStamp, String logIpaddress);
	
	@Modifying
	@Query("update FeedbackAnswerModel a set fba07=?5, logTimestamp=?6, logIpaddress=?7 where "+
			"a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 and a.fbaPkId.classId=?3 and a.fbaPkId.fbSlNo=?4")
	void updateRatingAnswer07(String semesterSubId, String feedbackType, String classId, 
			Long fbSlNo, int fbRating, Date logTimeStamp, String logIpaddress);
	
	@Modifying
	@Query("update FeedbackAnswerModel a set fba08=?5, logTimestamp=?6, logIpaddress=?7 where "+
			"a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 and a.fbaPkId.classId=?3 and a.fbaPkId.fbSlNo=?4")
	void updateRatingAnswer08(String semesterSubId, String feedbackType, String classId, 
			Long fbSlNo, int fbRating, Date logTimeStamp, String logIpaddress);
		
	@Modifying
	@Query("update FeedbackAnswerModel a set fba09=?5, logTimestamp=?6, logIpaddress=?7 where "+
			"a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 and a.fbaPkId.classId=?3 and a.fbaPkId.fbSlNo=?4")
	void updateRatingAnswer09(String semesterSubId, String feedbackType, String classId, 
			Long fbSlNo, int fbRating, Date logTimeStamp, String logIpaddress);
	
	@Modifying
	@Query("update FeedbackAnswerModel a set fba10=?5, logTimestamp=?6, logIpaddress=?7 where "+
			"a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 and a.fbaPkId.classId=?3 and a.fbaPkId.fbSlNo=?4")
	void updateRatingAnswer10(String semesterSubId, String feedbackType, String classId, 
			Long fbSlNo, int fbRating, Date logTimeStamp, String logIpaddress);
	
	
	//Update Statement
	@Modifying
	@Query("update FeedbackAnswerModel a set fbs01=?5, logTimestamp=?6, logIpaddress=?7 where "+
			"a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 and a.fbaPkId.classId=?3 and a.fbaPkId.fbSlNo=?4")
	void updateStatementAnswer01(String semesterSubId, String feedbackType, String classId, 
			Long fbSlNo, String fbStatement, Date logTimeStamp, String logIpaddress);
	
	@Modifying
	@Query("update FeedbackAnswerModel a set fbs02=?5, logTimestamp=?6, logIpaddress=?7 where "+
			"a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 and a.fbaPkId.classId=?3 and a.fbaPkId.fbSlNo=?4")
	void updateStatementAnswer02(String semesterSubId, String feedbackType, String classId, 
			Long fbSlNo, String fbStatement, Date logTimeStamp, String logIpaddress);
	
	@Modifying
	@Query("update FeedbackAnswerModel a set fbs03=?5, logTimestamp=?6, logIpaddress=?7 where "+
			"a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 and a.fbaPkId.classId=?3 and a.fbaPkId.fbSlNo=?4")
	void updateStatementAnswer03(String semesterSubId, String feedbackType, String classId, 
			Long fbSlNo, String fbStatement, Date logTimeStamp, String logIpaddress);
	
	@Modifying
	@Query("update FeedbackAnswerModel a set fbs04=?5, logTimestamp=?6, logIpaddress=?7 where "+
			"a.fbaPkId.semesterSubId=?1 and a.fbaPkId.feedbackType=?2 and a.fbaPkId.classId=?3 and a.fbaPkId.fbSlNo=?4")
	void updateStatementAnswer04(String semesterSubId, String feedbackType, String classId, 
			Long fbSlNo, String fbStatement, Date logTimeStamp, String logIpaddress);
	
}
