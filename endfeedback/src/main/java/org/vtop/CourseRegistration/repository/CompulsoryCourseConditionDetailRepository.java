package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.CompulsoryCourseConditionDetailModel;
import org.vtop.CourseRegistration.model.CompulsoryCourseConditionDetailModelPK;


@Repository
public interface CompulsoryCourseConditionDetailRepository extends JpaRepository<CompulsoryCourseConditionDetailModel,CompulsoryCourseConditionDetailModelPK> {
	
	@Query("select a.cccdmPkId.courseId from CompulsoryCourseConditionDetailModel a where "+
			"a.cccdmPkId.programGroupId=?1 and a.cccdmPkId.studentBatch=?2 and "+
			"a.cccdmPkId.studentSemester=?3 and a.status=0 order by a.cccdmPkId.courseId")
	List<String> findCompulsoryCourseList(Integer progGroupId, Integer studentBatch, 
			Integer studentSemester);
	
	@Query("select a.cccdmPkId.courseId from CompulsoryCourseConditionDetailModel a where "+
			"a.cccdmPkId.programGroupId=?1 and a.cccdmPkId.studentBatch=?2 and "+
			"a.cccdmPkId.studentSemester<?3 and (a.cccdmPkId.courseId like 'STS%') and "+
			"a.status=0 order by a.cccdmPkId.courseId")
	List<String> findSoftSkillCourseList(Integer progGroupId, Integer studentBatch, 
			Integer studentSemester);

}
