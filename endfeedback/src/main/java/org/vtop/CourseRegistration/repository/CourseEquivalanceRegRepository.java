package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.CourseEquivalanceRegModel;
import org.vtop.CourseRegistration.model.CourseEquivalanceRegPKModel;

@Repository
public interface CourseEquivalanceRegRepository extends JpaRepository<CourseEquivalanceRegModel, CourseEquivalanceRegPKModel> {
	
	@Query("select a from CourseEquivalanceRegModel a where a.courseEquivalanceRegPKId.semesterSubId=?1 "+
			"order by a.courseEquivalanceRegPKId.registerNumber, a.courseEquivalanceRegPKId.courseId, "+
			"a.courseEquivalanceRegPKId.courseType desc")
	List<CourseEquivalanceRegModel> findBySemesterSubId(String semesterSubId);
	
	@Query("select a from CourseEquivalanceRegModel a where a.courseEquivalanceRegPKId.semesterSubId=?1 "+
			"and a.courseEquivalanceRegPKId.registerNumber=?2 order by a.courseEquivalanceRegPKId.courseId, "+
			"a.courseEquivalanceRegPKId.courseType desc")
	List<CourseEquivalanceRegModel> findByRegisterNumber(String semesterSubId, String registerNumber);
	
	@Query("select a from CourseEquivalanceRegModel a where a.courseEquivalanceRegPKId.semesterSubId=?1 "+
			"and a.courseEquivalanceRegPKId.registerNumber=?2 and a.courseEquivalanceRegPKId.courseId=?3 "+
			"order by a.courseEquivalanceRegPKId.courseType desc")
	List<CourseEquivalanceRegModel> findByRegisterNumberCourseId(String semesterSubId, String registerNumber, 
		String courseId);
	
	@Query("select distinct a.equivalanceCourseId from CourseEquivalanceRegModel a where "+
			"a.courseEquivalanceRegPKId.semesterSubId=?1 and a.courseEquivalanceRegPKId.registerNumber=?2 "+
			"and a.courseEquivalanceRegPKId.courseId=?3")
	String findEquivCourseByRegisterNumberAndCourseId(String semesterSubId, String registerNumber, String courseId);
	
	@Modifying
	@Query("delete from CourseEquivalanceRegModel a where a.courseEquivalanceRegPKId.semesterSubId=?1 "+
			"and a.courseEquivalanceRegPKId.registerNumber=?2 and a.courseEquivalanceRegPKId.courseId=?3")
	void deleteByRegisterNumberCourseId(String semesterSubId, String registerNumber, 
			String courseId);
	
}
