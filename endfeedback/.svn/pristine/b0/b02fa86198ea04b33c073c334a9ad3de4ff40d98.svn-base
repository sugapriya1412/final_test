package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.StudentHistoryModel;
import org.vtop.CourseRegistration.model.StudentHistoryPKModel;

@Repository
public interface StudentHistoryRepository extends JpaRepository<StudentHistoryModel, StudentHistoryPKModel> {

	@Query("select a from StudentHistoryModel a order by a.studentHistoryPKId.registerNumber, "+
			"a.studentHistoryPKId.courseId, a.studentHistoryPKId.courseType desc")
	List<StudentHistoryModel> findAll();
	
	@Query("select a from StudentHistoryModel a where a.studentHistoryPKId.registerNumber in (?1) "+
			"order by a.studentHistoryPKId.courseId, a.studentHistoryPKId.courseType desc")
	List<StudentHistoryModel> findByRegisterNumber(List<String> registerNumber);
	
	@Query("select a from StudentHistoryModel a where a.studentHistoryPKId.registerNumber in (?1) and "+
			"a.studentHistoryPKId.courseId=?2 order by a.studentHistoryPKId.courseType desc")
	List<StudentHistoryModel> findByRegisterNumberCourseId(List<String> registerNumber, String courseId);
	
	/*@Query("select a from StudentHistoryModel a where (a.studentHistoryPKId.registerNumber in ?1) and "+
			"a.studentHistoryPKId.courseId in (select b.courseId from CourseCatalogModel b where "+
			"b.code=?2) and a.courseTypeComponentModel.component in (1,3) "+
			"order by a.studentHistoryPKId.courseType desc")
	StudentHistoryModel findStudentHistoryGrade(String[] registerNumber, String courseCode);*/
	
	/*@Query("select a from StudentHistoryModel a where (a.studentHistoryPKId.registerNumber in ?1) and "+
			"a.studentHistoryPKId.courseId in (select b.courseId from CourseCatalogModel b where "+
			"b.code=?2) and a.courseTypeComponentModel.component in (1,3) "+
			"order by a.studentHistoryPKId.courseType desc")*/
	@Query("select a from StudentHistoryModel a where (a.studentHistoryPKId.registerNumber in ?1) and "+
			"a.courseCode=?2 and a.courseTypeComponentModel.component in (1,3) "+
			"order by a.studentHistoryPKId.courseType desc")
	StudentHistoryModel findStudentHistoryGrade(List<String> registerNumber, String courseCode);
	
	/*@Query(value="select distinct nvl(a.GRADE,'NIL') as grade from academics.STUDENT_HISTORY a, "+
	"academics.COURSE_TYPE_COMPONENT_MASTER b where a.STDNTSLGNDTLS_REGISTER_NUMBER in (?1) and "+
	"a.COURSE_CODE=?2 and b.COMPONENT in (1,3) and a.CRSTYPCMPNTMASTER_COURSE_TYPE=b.COURSE_TYPE", 
	nativeQuery=true)*/
	@Query("select distinct a.grade from StudentHistoryModel a where "+
			"a.studentHistoryPKId.registerNumber in (?1) and a.courseCode=?2 and "+
			"a.courseTypeComponentModel.component in (1,3)")
	String findStudentHistoryDistinctGrade(List<String> registerNumber, String courseCode);
	
	/*@Query("select a from StudentHistoryModel a where (a.studentHistoryPKId.registerNumber in ?1) and "+
			"a.studentHistoryPKId.courseId in (select b.courseId from CourseCatalogModel b where "+
			"b.code in (select c.code from CourseCatalogModel c where c.courseId in "+
			"(select d.courseEquivalancesPkId.equivalentCourseId from CourseEquivalancesModel d "+
			"where d.courseEquivalancesPkId.courseId=?2))) and a.courseTypeComponentModel.component "+
			"in (1,3) order by a.studentHistoryPKId.courseType desc")*/
	@Query("select a from StudentHistoryModel a where (a.studentHistoryPKId.registerNumber in ?1) and "+
			"a.courseTypeComponentModel.component in (1,3) and a.courseCode in "+
			"(select b.equivalentCourseCode from CourseEquivalancesModel b where "+
			"b.courseEquivalancesPkId.courseId=?2) order by a.studentHistoryPKId.courseType desc")
	List<StudentHistoryModel> findStudentHistoryCEGrade(List<String> registerNumber, String courseId);
	
	@Query(value="select a.grade, a.COURSE_CATALOG_COURSE_ID, decode(a.grade,'S',1,'U',2,'P',3,'Pass',"+
				"4,'A',5,'B',6,'C',7,'D',8,'E',9,'R',10,'F',11,'Fail',12,'N',13,'W',14,'WWW',15,'AAA',16,17) as "+
				"grade_order from academics.student_history a, academics.COURSE_TYPE_COMPONENT_MASTER b where "+
				"a.STDNTSLGNDTLS_REGISTER_NUMBER in (?1) and b.COMPONENT in (1,3) and "+
				"a.CRSTYPCMPNTMASTER_COURSE_TYPE=b.COURSE_TYPE and (a.COURSE_CODE in "+
				"(select EQUIVALENT_COURSE_CODE from academics.COURSE_EQUIVALANCES "+
				"where COURSE_CODE=?2) or a.COURSE_CODE in (select COURSE_CODE from "+ 
				"academics.COURSE_EQUIVALANCES where EQUIVALENT_COURSE_CODE=?2)) "+
				"order by grade_order", nativeQuery=true)
	List<Object[]> findStudentHistoryCEGrade2(List<String> registerNumber, String courseCode);
	
	@Query("select a from StudentHistoryModel a where (a.studentHistoryPKId.registerNumber in ?1) and "+
			"a.studentHistoryPKId.courseId in (select b.courseId from CourseCatalogModel b where "+
			"(b.code in ?2)) and a.grade in ('A','B','C','D','E','S','U','R','F','Fail','P','Pass') "+
			"and a.courseTypeComponentModel.component in (1,3) "+
			"order by a.studentHistoryPKId.courseType desc")
	List<StudentHistoryModel> findStudentHistoryPARequisite(List<String> registerNumber, String[] courseCode);
	
	/*@Query("select a from StudentHistoryModel a where (a.studentHistoryPKId.registerNumber in ?1) and "+
			"(a.studentHistoryPKId.courseId in (select b.courseId from CourseCatalogModel b where "+
			"(b.code in ?2)) or a.studentHistoryPKId.courseId in (select c.courseEquivalancesPkId.equivalentCourseId "+
			"from CourseEquivalancesModel c  where (c.courseCatalogModel.code in ?2))) and a.grade in "+
			"('A','B','C','D','E','S','U','R','F','Fail','P','Pass','N') and a.courseTypeComponentModel.component in (1,3) "+
			"order by a.studentHistoryPKId.courseType desc")*/
	/*@Query("select a from StudentHistoryModel a where (a.studentHistoryPKId.registerNumber in ?1) and "+
			"a.grade in ('A','B','C','D','E','S','U','R','F','Fail','P','Pass','N') and "+
			"a.courseTypeComponentModel.component in (1,3) and ((a.courseCatalogModel.code in ?2) or "+
			"a.courseCatalogModel.code in (select substr(c.courseEquivalancesPkId.equivalentCourseId,"+
			"4,length(c.courseEquivalancesPkId.equivalentCourseId)-9) as CourseCode from CourseEquivalancesModel c "+
			"where (c.courseCatalogModel.code in ?2)) or a.courseCatalogModel.code in (select d.courseCatalogModel.code "+
			"from CourseEquivalancesModel d where ((substr(d.courseEquivalancesPkId.equivalentCourseId,4,"+
			"length(d.courseEquivalancesPkId.equivalentCourseId)-9)) in ?2)))")*/
	@Query("select a from StudentHistoryModel a where (a.studentHistoryPKId.registerNumber in ?1) and "+
			"a.grade in ('A','B','C','D','E','S','U','R','F','Fail','P','Pass','N') and "+
			"a.courseTypeComponentModel.component in (1,3) and ((a.courseCode in ?2) or (a.courseCode in "+
			"(select c.equivalentCourseCode from CourseEquivalancesModel c where (c.courseCode in ?2))) or "+
			"(a.courseCode in (select d.courseCode from CourseEquivalancesModel d where "+
			"(d.equivalentCourseCode in ?2))))")
	List<StudentHistoryModel> findStudentHistoryPARequisite2(List<String> registerNumber, List<String> courseCode);
	
	/*@Query("select distinct a.studentHistoryPKId.courseType from StudentHistoryModel a where "+
			"(a.studentHistoryPKId.registerNumber in ?1) and a.studentHistoryPKId.courseId in "+
			"(select b.courseId from CourseCatalogModel b where b.code=?2) and a.grade='Y' "+
			"and a.courseTypeComponentModel.component=2 order by a.studentHistoryPKId.courseType desc")*/
	@Query("select distinct a.studentHistoryPKId.courseType from StudentHistoryModel a where "+
			"(a.studentHistoryPKId.registerNumber in ?1) and a.courseCode=?2 and "+
			"a.grade='Y' and a.courseTypeComponentModel.component=2 "+
			"order by a.studentHistoryPKId.courseType desc")
	List<String> findStudentHistoryCourseType(List<String> registerNumber, String courseCode);
	
	/*@Query("select distinct a.studentHistoryPKId.courseType from StudentHistoryModel a where "+
			"(a.studentHistoryPKId.registerNumber in ?1) and a.courseCode=?2 and a.grade='N' "+
			"and a.courseTypeComponentModel.component not in (2)")*/
	@Query("select distinct a.studentHistoryPKId.courseType from StudentHistoryModel a where "+
			"(a.studentHistoryPKId.registerNumber in ?1) and a.courseCode=?2 "+
			"and a.courseTypeComponentModel.component not in (2)")
	String findStudentHistoryGenericCourseType(List<String> registerNumber, String courseCode);
	
	/*@Query("select a from StudentHistoryModel a where (a.studentHistoryPKId.registerNumber in ?1) and "+
			"a.studentHistoryPKId.courseId not in (select b.courseId from CourseCatalogModel b where "+
			"b.code=?2) and a.grade in ('Fail','F','N') and a.courseTypeComponentModel.component in (1,3) "+
			"order by a.studentHistoryPKId.courseType desc")*/
	@Query("select a from StudentHistoryModel a where (a.studentHistoryPKId.registerNumber in ?1) and "+
			"a.courseCode=?2 and a.grade in ('Fail','F','N') and a.courseTypeComponentModel.component "+
			"in (1,3) order by a.studentHistoryPKId.courseType desc")
	List<StudentHistoryModel> findStudentHistoryCS(List<String> registerNumber, String courseCode);
	
	@Query(value="select a.COURSE_CATALOG_COURSE_ID, a.COURSE_CODE, b.TITLE from academics.STUDENT_HISTORY a, "+
				"academics.CRS_CTG_MAX_VERSION_VIEW b where a.STDNTSLGNDTLS_REGISTER_NUMBER in (?1) "+
				"and a.COURSE_CODE not in (?2) and a.GRADE in ('Fail','F','N') and "+
				"a.CRSTYPCMPNTMASTER_COURSE_TYPE not in ('ETH','ELA','EPJ') and a.COURSE_CODE=b.CODE and "+
				"a.COURSE_CODE not in (select distinct COURSE_CODE from academics.STUDENT_HISTORY where "+
				"STDNTSLGNDTLS_REGISTER_NUMBER in (?1) and GRADE in ('S','A','B','C','D','E','U','P','Pass')) "+
				"and a.COURSE_CODE not in (select EQUIVALENT_COURSE_CODE from academics.COURSE_EQUIVALANCES "+
				"where COURSE_CODE=?2) and a.COURSE_CODE not in (select COURSE_CODE from "+ 
				"academics.COURSE_EQUIVALANCES where EQUIVALENT_COURSE_CODE=?2) order by a.COURSE_CODE", 
				nativeQuery=true)
	List<Object[]> findStudentHistoryCS2(List<String> registerNumber, String courseCode);
	
	@Query("select a from StudentHistoryModel a where (a.studentHistoryPKId.registerNumber in ?1) "+
			"and a.grade in ('Fail','F') and a.courseTypeComponentModel.component in (1,3) "+
			"order by a.studentHistoryPKId.courseType desc")
	List<StudentHistoryModel> findStudentHistoryFailCourse(List<String> registerNumber);
	
	@Query("select nvl(sum(a.credit),0) as FCredits from StudentHistoryModel a where "+
			"(a.studentHistoryPKId.registerNumber in ?1) and a.grade in ('Fail','F') "+
			"and a.courseTypeComponentModel.component in (1,3)")
	Integer findStudentHistoryFailCourseCredits(List<String> registerNumber);
	
	
	@Query(value="select GRADE, COURSE_CATALOG_COURSE_ID, COURSE_CODE, GEN_COURSE_TYPE, decode(GRADE,'S',1,'U',2,'P',3,"+
				"'Pass',4,'A',5,'B',6,'C',7,'D',8,'E',9,'R',10,'F',11,'Fail',12,'N',13,'W',14,'WWW',15,"+
				"'AAA',16,17) as grade_order, hist_type from ("+
				"(select a.GRADE, a.COURSE_CATALOG_COURSE_ID, a.COURSE_CODE, a.CRSTYPCMPNTMASTER_COURSE_TYPE "+
				"as GEN_COURSE_TYPE, 1 as hist_type from academics.STUDENT_HISTORY a, academics.COURSE_TYPE_COMPONENT_MASTER b "+
				"where a.STDNTSLGNDTLS_REGISTER_NUMBER in (?1) and b.COMPONENT in (1,3) and "+ 
				"a.CRSTYPCMPNTMASTER_COURSE_TYPE=b.COURSE_TYPE) "+
				"union all "+
				"(select a.GRADE, a.COURSE_CATALOG_COURSE_ID, a.CODE as COURSE_CODE, a.CRS_CTALOG_GENERIC_COURSE_TYPE "+
				"as GEN_COURSE_TYPE, 2 as hist_type from examinations.MIGRATION_STUDENT_HISTORY_ACAD a, academics.COURSE_TYPE_COMPONENT_MASTER b "+ 
				"where a.STDNTSLGNDTLS_REGISTER_NUMBER in (?1) and b.COMPONENT in (1,3) and "+
				"a.GRADE is not null and a.CRS_CTALOG_GENERIC_COURSE_TYPE=b.COURSE_TYPE)"+
				") where COURSE_CODE=?2 order by grade_order", nativeQuery=true)
	List<Object[]> findStudentHistoryGrade2(List<String> registerNumber, String courseCode);
	
	@Query(value="select GRADE, COURSE_CATALOG_COURSE_ID, COURSE_CODE, GEN_COURSE_TYPE, decode(GRADE,'S',1,'U',2,'P',3,"+
				"'Pass',4,'A',5,'B',6,'C',7,'D',8,'E',9,'R',10,'F',11,'Fail',12,'N',13,'W',14,'WWW',15,"+
				"'AAA',16,17) as grade_order, hist_type from ("+
				"(select a.GRADE, a.COURSE_CATALOG_COURSE_ID, a.COURSE_CODE, a.CRSTYPCMPNTMASTER_COURSE_TYPE "+
				"as GEN_COURSE_TYPE, 1 as hist_type from academics.STUDENT_HISTORY a, academics.COURSE_TYPE_COMPONENT_MASTER b "+
				"where a.STDNTSLGNDTLS_REGISTER_NUMBER in (?1) and b.COMPONENT in (1,3) and "+ 
				"a.CRSTYPCMPNTMASTER_COURSE_TYPE=b.COURSE_TYPE) "+
				"union all "+
				"(select a.GRADE, a.COURSE_CATALOG_COURSE_ID, a.CODE as COURSE_CODE, a.CRS_CTALOG_GENERIC_COURSE_TYPE "+
				"as GEN_COURSE_TYPE, 2 as hist_type from examinations.MIGRATION_STUDENT_HISTORY_ACAD a, academics.COURSE_TYPE_COMPONENT_MASTER b "+ 
				"where a.STDNTSLGNDTLS_REGISTER_NUMBER in (?1) and b.COMPONENT in (1,3) and "+
				"a.GRADE is not null and a.CRS_CTALOG_GENERIC_COURSE_TYPE=b.COURSE_TYPE)"+
				") where (COURSE_CODE in (select EQUIVALENT_COURSE_CODE from academics.COURSE_EQUIVALANCES "+
				"where COURSE_CODE=?2) or COURSE_CODE in (select COURSE_CODE from academics.COURSE_EQUIVALANCES "+
				"where EQUIVALENT_COURSE_CODE=?2)) order by grade_order", nativeQuery=true)
	List<Object[]> findStudentHistoryCEGrade3(List<String> registerNumber, String courseCode);
	
	/*@Query(value="select a.GRADE, a.COURSE_CATALOG_COURSE_ID, a.COURSE_CODE, a.CRSTYPCMPNTMASTER_COURSE_TYPE "+
			"as GEN_COURSE_TYPE from academics.STUDENT_HISTORY a, academics.COURSE_TYPE_COMPONENT_MASTER b "+
			"where a.STDNTSLGNDTLS_REGISTER_NUMBER in (?1) and a.GRADE in ('Fail','F','Y') and "+
			"a.CRSTYPCMPNTMASTER_COURSE_TYPE=b.COURSE_TYPE order by a.COURSE_CODE", 
			nativeQuery=true)
	List<Object[]> findStudentHistoryFailCourse2(List<String> registerNumber);*/
	
	@Query(value="select GRADE, COURSE_CATALOG_COURSE_ID, COURSE_CODE, GEN_COURSE_TYPE, hist_type from ("+
				"(select a.GRADE, a.COURSE_CATALOG_COURSE_ID, a.COURSE_CODE, a.CRSTYPCMPNTMASTER_COURSE_TYPE "+
				"as GEN_COURSE_TYPE, 1 as hist_type from academics.STUDENT_HISTORY a, academics.COURSE_TYPE_COMPONENT_MASTER b "+
				"where a.STDNTSLGNDTLS_REGISTER_NUMBER in (?1) and a.CRSTYPCMPNTMASTER_COURSE_TYPE=b.COURSE_TYPE) "+
				"union all "+
				"(select a.GRADE, a.COURSE_CATALOG_COURSE_ID, a.CODE as COURSE_CODE, a.CRS_CTALOG_GENERIC_COURSE_TYPE "+
				"as GEN_COURSE_TYPE, 2 as hist_type from examinations.MIGRATION_STUDENT_HISTORY_ACAD a, academics.COURSE_TYPE_COMPONENT_MASTER b "+ 
				"where a.STDNTSLGNDTLS_REGISTER_NUMBER in (?1) and a.GRADE is not null and "+
				"a.CRS_CTALOG_GENERIC_COURSE_TYPE=b.COURSE_TYPE)"+
				") where GRADE in ('Fail','F','Y') order by COURSE_CODE", nativeQuery=true)
	List<Object[]> findStudentHistoryFailCourse2(List<String> registerNumber);
	
}
