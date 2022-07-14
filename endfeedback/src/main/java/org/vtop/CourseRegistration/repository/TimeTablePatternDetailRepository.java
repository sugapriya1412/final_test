package org.vtop.CourseRegistration.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.TimeTablePatternDetailModel;
import org.vtop.CourseRegistration.model.TimeTablePatternDetailPK;


@Repository
public interface TimeTablePatternDetailRepository extends JpaRepository<TimeTablePatternDetailModel,TimeTablePatternDetailPK> {

	  List<TimeTablePatternDetailModel> findAll();  
	  List<TimeTablePatternDetailModel> findByStatus(int status);
	  
	  @Modifying
	  @Query("update TimeTablePatternDetailModel a set a.status=2, a.logUserId=?3, a.logTimestamp=?4, "+
	      "a.logIpaddress=?5 where a.ttpdPkId.patternId=?1 and a.ttpdPkId.session=?2 ")
	  void updateTTPatternDetailByStatusLock(Integer patternId, String session, String userId, Date timeStamp, String ipAddress);
	  
	  @Modifying
	  @Query("update TimeTablePatternDetailModel a set a.status=0, a.logUserId=?3, a.logTimestamp=?4, "+
	      "a.logIpaddress=?5 where a.ttpdPkId.patternId=?1 and a.ttpdPkId.session=?2 ")
	  void updateTTPatternDetailByStatusOpen(Integer patternId, String session, String userId, Date timeStamp, String ipAddress);

	  /* TT Pattern Time Master */
		@Query("select a from TimeTablePatternDetailModel a where a.ttpdPkId.patternId=?1")
		List<TimeTablePatternDetailModel> findByPatternId1(Integer patternId);
		
		@Query(value = "select greatest(a.NUM_TH_SLOTS,a.NUM_LAB_SLOTS) as num, a.TT_SESSION"
				+ " from academics.time_table_pattern_detail a where a.PATTERN_ID=?1", nativeQuery= true)
		List<Object[]> getMaxSlots(Integer patternId);

}
