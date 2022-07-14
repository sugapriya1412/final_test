package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.CapStoneProjectConditionDetailModel;
import org.vtop.CourseRegistration.model.CapStoneProjectConditionDetailModelPK;

@Repository
public interface CapStoneProjectConditionDetailRepository extends 
	JpaRepository<CapStoneProjectConditionDetailModel,CapStoneProjectConditionDetailModelPK> {

	@Query("select a from CapStoneProjectConditionDetailModel a where "+
			"a.cspcdmPkId.programGroupId=?1 order by a.cspcdmPkId.studentBatch desc")
	List<CapStoneProjectConditionDetailModel> findByProgramGroupId(Integer programGroupId);
}
