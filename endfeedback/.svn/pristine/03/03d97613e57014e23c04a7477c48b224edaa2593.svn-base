package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.CourseEquivalancesModel;
import org.vtop.CourseRegistration.model.CourseEquivalancesPKModel;

@Repository
public interface CourseEquivalancesRepository extends JpaRepository<CourseEquivalancesModel, CourseEquivalancesPKModel> {
	
	@Query("select a from CourseEquivalancesModel a order by a.courseEquivalancesPkId.courseId, "+
			"a.courseEquivalancesPkId.equivalentCourseId")
	List<CourseEquivalancesModel> findAll();
	
	@Query("select a from CourseEquivalancesModel a where a.courseEquivalancesPkId.courseId=?1 "+
			"order by a.courseEquivalancesPkId.equivalentCourseId")
	List<CourseEquivalancesModel> findByCourseId(String courseId);
	
	@Query("select a from CourseEquivalancesModel a where a.courseEquivalancesPkId.equivalentCourseId=?1 "+
			"order by a.courseEquivalancesPkId.courseId")
	List<CourseEquivalancesModel> findByEquivalCourseId(String equivalCourseId);

}
