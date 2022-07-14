package org.vtop.CourseRegistration.repository.examinations;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.MigrationStudentHistoryAcadModel;
import org.vtop.CourseRegistration.model.MigrationStudentHistoryAcadPKModel;

@Repository
public interface MigrationStudentHistoryAcadRepository extends 
							JpaRepository<MigrationStudentHistoryAcadModel, MigrationStudentHistoryAcadPKModel>
{
	@Query("select distinct a.migrationStudentHistoryAcadPKId.courseType from MigrationStudentHistoryAcadModel a "+
			"where a.migrationStudentHistoryAcadPKId.registerNumber in (?1) and a.courseCode=?2 and "+
			"a.grade='Y' and a.courseTypeComponentModel.component=2 "+
			"order by a.migrationStudentHistoryAcadPKId.courseType desc")
	List<String> findMigrationStudentHistoryCourseType(List<String> registerNumber, String courseCode);
}
