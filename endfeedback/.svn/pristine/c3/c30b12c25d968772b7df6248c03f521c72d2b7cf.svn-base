package org.vtop.CourseRegistration.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vtop.CourseRegistration.model.CourseCatalogModel;

@Repository
public interface CourseCatalogRepository extends JpaRepository<CourseCatalogModel,String> {
	
	@Query("select a from CourseCatalogModel a where a.code=?1 and a.courseVersion=?2")
	CourseCatalogModel findByCourseCodeAndVersion(String code, float courseVersion);
	
	@Query("select a from CourseCatalogModel a where a.code like ?1 order by a.code")
	List<CourseCatalogModel> findByCourseCode(String searchval);
	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and a.status=0 "+
			"order by a.ownerCode, a.code, a.courseVersion")
	List<CourseCatalogModel> findRegistrationCourseList(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode);
	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 and "+
			"b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	List<CourseCatalogModel> findRegistrationCourseList2(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType);
			
	//To get Course Owner's List
	@Query("select distinct a.ownerCode, b.code, b.description from CourseCatalogModel a, CostCentre b "+
			"where a.campusCode=?1 and b.centreId=to_number(a.ownerCode) and a.campusCode=b.campusCode "+
			"order by b.code")
	List<Object[]> findCourseCostCentre(String campus);
	
		
	//Regular Course List
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code not in (select nvl(c.courseCode,'NONE') from StudentHistoryModel c where "+
			"c.studentHistoryPKId.registerNumber in (?8)) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	List<CourseCatalogModel> findRegularCourseList(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber);
		
	//Regular Course List Pagination with out search	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code not in (select nvl(c.courseCode,'NONE') from StudentHistoryModel c where "+
			"c.studentHistoryPKId.registerNumber in (?8)) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findRegularCoursePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, Pageable pageable);
	
	//Regular Course List Pagination with Course Owner Search	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and a.ownerCode=?9 "+
			"and a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code not in (select nvl(c.courseCode,'NONE') from StudentHistoryModel c where "+
			"c.studentHistoryPKId.registerNumber in (?8)) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findRegularCourseOwnerPagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, String searchval, Pageable pageable);
		
	//Regular Course List Pagination with Course Code Search	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and (a.code like ?9) "+
			"and a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code not in (select nvl(c.courseCode,'NONE') from StudentHistoryModel c where "+
			"c.studentHistoryPKId.registerNumber in (?8)) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findRegularCourseCodePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, String searchval, Pageable pageable);
	
	//Regular Course List Pagination with Course Title Search	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and (upper(a.title) like ?9) "+
			"and a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code not in (select nvl(c.courseCode,'NONE') from StudentHistoryModel c where "+
			"c.studentHistoryPKId.registerNumber in (?8)) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findRegularCourseTitlePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, String searchval, Pageable pageable);
	
	
	//Re-register Course List
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code in (select nvl(c.courseCode,'NONE') from StudentHistoryModel c where "+
			"c.studentHistoryPKId.registerNumber in (?8) and c.grade in ('Fail','F','N','W','WWW','AAA')) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	List<CourseCatalogModel> findRRCourseList(String campusCode, String[] courseSystem, 
				List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
				String[] classType,	String[] registerNumber);
	
	//Re-registered Course List Pagination with out search
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code in (select nvl(c.courseCode,'NONE') from StudentHistoryModel c where "+
			"c.studentHistoryPKId.registerNumber in (?8) and c.grade in ('Fail','F','N','W','WWW','AAA')) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findRRCoursePagination(String campusCode, String[] courseSystem, 
				List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
				String[] classType, String[] registerNumber, Pageable pageable);
	
	//Re-registered Course List Pagination with Course Owner Search	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and a.ownerCode=?9 and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code in (select nvl(c.courseCode,'NONE') from StudentHistoryModel c where "+
			"c.studentHistoryPKId.registerNumber in (?8) and c.grade in ('Fail','F','N','W','WWW','AAA')) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findRRCourseOwnerPagination(String campusCode, String[] courseSystem, 
				List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
				String[] classType, String[] registerNumber, String searchval, Pageable pageable);
	
	//Re-registered Course List Pagination with Course Code Search	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and (a.code like ?9) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code in (select nvl(c.courseCode,'NONE') from StudentHistoryModel c where "+
			"c.studentHistoryPKId.registerNumber in (?8) and c.grade in ('Fail','F','N','W','WWW','AAA')) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findRRCourseCodePagination(String campusCode, String[] courseSystem, 
				List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
				String[] classType, String[] registerNumber, String searchval, Pageable pageable);
	
	//Re-registered Course List Pagination with Course Title Search
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and (upper(a.title) like ?9) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code in (select nvl(c.courseCode,'NONE') from StudentHistoryModel c where "+
			"c.studentHistoryPKId.registerNumber in (?8) and c.grade in ('Fail','F','N','W','WWW','AAA')) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findRRCourseTitlePagination(String campusCode, String[] courseSystem, 
				List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
				String[] classType, String[] registerNumber, String searchval, Pageable pageable);
	
	
	//Grade Improvement Course List
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code in (select nvl(c.courseCode,'NONE') from StudentHistoryModel c where "+
			"c.studentHistoryPKId.registerNumber in (?8) and c.grade in ('A','B','C','D','E')) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	List<CourseCatalogModel> findGICourseList(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber);
		
	//Grade Improvement Course List Pagination with out search
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code in (select nvl(c.courseCode,'NONE') from StudentHistoryModel c where "+
			"c.studentHistoryPKId.registerNumber in (?8) and c.grade in ('A','B','C','D','E')) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findGICoursePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, Pageable pageable);
	
	//Grade Improvement Course Pagination with Course Owner Search
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and a.ownerCode=?9 and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code in (select nvl(c.courseCode,'NONE') from StudentHistoryModel c where "+
			"c.studentHistoryPKId.registerNumber in (?8) and c.grade in ('A','B','C','D','E')) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findGICourseOwnerPagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, String searchval, Pageable pageable);
		
	//Grade Improvement Course Pagination with Course Code Search	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and (a.code like ?9) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code in (select nvl(c.courseCode,'NONE') from StudentHistoryModel c where "+
			"c.studentHistoryPKId.registerNumber in (?8) and c.grade in ('A','B','C','D','E')) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findGICourseCodePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, String searchval, Pageable pageable);
	
	//Grade Improvement Course Pagination with Course Title Search
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and (upper(a.title) like ?9) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code in (select nvl(c.courseCode,'NONE') from StudentHistoryModel c where "+
			"c.studentHistoryPKId.registerNumber in (?8) and c.grade in ('A','B','C','D','E')) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findGICourseTitlePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String[] registerNumber, String searchval, Pageable pageable);
	
	
	//FFCS to CAL Course Equivalence Course List	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem='CAL' "+
			"and (a.groupId in (?2) or (a.groupCode=?3 or a.groupCode like ?3||'/%' "+
			"or a.groupCode like '%/'||?3||'/%' or a.groupCode like '%/'||?3)) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?4 "+
			"and b.clsGrpMasterGroupId in (?5) and b.classType in (?6) and b.lockStatus=0) and "+
			"(a.code in (select c.courseCode from CourseEquivalancesModel c) or a.code in "+
			"(select d.equivalentCourseCode from CourseEquivalancesModel d)) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	List<CourseCatalogModel> findCALToFFCSCEList(String campusCode, List<Integer> egbGroupId, 
			String groupCode, String semesterSubId, String[] classGroupId, String[] classType);
		
	//FFCS to CAL Course Equivalence with out Search	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem='CAL' "+
			"and (a.groupId in (?2) or (a.groupCode=?3 or a.groupCode like ?3||'/%' "+
			"or a.groupCode like '%/'||?3||'/%' or a.groupCode like '%/'||?3)) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?4 "+
			"and b.clsGrpMasterGroupId in (?5) and b.classType in (?6) and b.lockStatus=0) and "+
			"(a.code in (select c.courseCode from CourseEquivalancesModel c) or a.code in "+
			"(select d.equivalentCourseCode from CourseEquivalancesModel d)) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findCALToFFCSCEPagination(String campusCode, List<Integer> egbGroupId, 
			String groupCode, String semesterSubId, String[] classGroupId, String[] classType, 
			Pageable pageable);
	
	//FFCS to CAL Course Equivalence with Course Owner Search	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem='CAL' "+
			"and (a.groupId in (?2) or (a.groupCode=?3 or a.groupCode like ?3||'/%' "+
			"or a.groupCode like '%/'||?3||'/%' or a.groupCode like '%/'||?3)) and a.ownerCode=?7 and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?4 "+
			"and b.clsGrpMasterGroupId in (?5) and b.classType in (?6) and b.lockStatus=0) and "+
			"(a.code in (select c.courseCode from CourseEquivalancesModel c) or a.code in "+
			"(select d.equivalentCourseCode from CourseEquivalancesModel d)) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findCALToFFCSCECourseOwnerPagination(String campusCode, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String searchval, Pageable pageable);
	
	//FFCS to CAL Course Equivalence with Course Code Search
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem='CAL' "+
			"and (a.groupId in (?2) or (a.groupCode=?3 or a.groupCode like ?3||'/%' "+
			"or a.groupCode like '%/'||?3||'/%' or a.groupCode like '%/'||?3)) and (a.code like ?7) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?4 "+
			"and b.clsGrpMasterGroupId in (?5) and b.classType in (?6) and b.lockStatus=0) and "+
			"(a.code in (select c.courseCode from CourseEquivalancesModel c) or a.code in "+
			"(select d.equivalentCourseCode from CourseEquivalancesModel d)) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findCALToFFCSCECourseCodePagination(String campusCode, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String searchval, Pageable pageable);
	
	//FFCS to CAL Course Equivalence with Course Title Search
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem='CAL' "+
			"and (a.groupId in (?2) or (a.groupCode=?3 or a.groupCode like ?3||'/%' "+
			"or a.groupCode like '%/'||?3||'/%' or a.groupCode like '%/'||?3)) and (upper(a.title) like ?7) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?4 "+
			"and b.clsGrpMasterGroupId in (?5) and b.classType in (?6) and b.lockStatus=0) and "+
			"(a.code in (select c.courseCode from CourseEquivalancesModel c) or a.code in "+
			"(select d.equivalentCourseCode from CourseEquivalancesModel d)) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findCALToFFCSCECourseTitlePagination(String campusCode, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, String searchval, Pageable pageable);
	
	
	//Additional Learning Pagination
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem in (?2) "+
			"and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and "+
			"a.code in (select nvl(c.courseCatalogModel.code,'NONE') from "+
			"AdditionalLearningCourseCatalogModel c where c.alccPkId.code=?8 and c.status=0) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findAdditinalLearningCoursePagination(String campusCode, 
			String[] courseSystem, List<Integer> egbGroupId, String groupCode, String semesterSubId, 
			String[] classGroupId, String[] classType, String code, Pageable pageable);
	
	//Compulsory Courses	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and "+
			"a.code in (?8) and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findCompulsoryCoursePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, List<String> courseCode, Pageable pageable);
	
	
	//Curriculum based course display - PC/ PE/ UC
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem in (?2) "+
			"and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 "+
			"and a.courseId in (select distinct b.courseId from CourseAllocationModel b where "+
			"b.semesterSubId=?5 and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and "+
			"b.lockStatus=0) and (a.code in (select d.code from ProgrammeSpecializationCurriculumDetailModel c, "+
			"CourseCatalogModel d where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 and "+
			"c.psccdPkId.curriculumVersion=?11 and c.catalogType='CC' and c.courseCategory=?10 and "+
			"c.status=0 and c.psccdPkId.courseBasketId=d.courseId) or a.code "+
			"in (select d.courseCatalogModel.code from ProgrammeSpecializationCurriculumDetailModel c, "+
			"BasketCourseCatalogModel d where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 "+
			"and c.psccdPkId.curriculumVersion=?11 and c.catalogType='BC' and c.courseCategory=?10 and "+
			"c.status=0 and d.status=0 and c.psccdPkId.courseBasketId=d.bccPkId.basketId)) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	List<CourseCatalogModel> findCurriculumPCPEUCList(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, Integer specId, Integer studYear, String courseCategory, 
			Float curriculumVersion);
	
	//Curriculum based course display Pagination with out Search - PC/ PE/ UC
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem in (?2) "+
			"and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 "+
			"and a.courseId in (select distinct b.courseId from CourseAllocationModel b where "+
			"b.semesterSubId=?5 and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and "+
			"b.lockStatus=0) and (a.code in (select d.code from ProgrammeSpecializationCurriculumDetailModel c, "+
			"CourseCatalogModel d where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 and "+
			"c.psccdPkId.curriculumVersion=?11 and c.catalogType='CC' and c.courseCategory=?10 and "+
			"c.status=0 and c.psccdPkId.courseBasketId=d.courseId) or a.code "+
			"in (select d.courseCatalogModel.code from ProgrammeSpecializationCurriculumDetailModel c, "+
			"BasketCourseCatalogModel d where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 "+
			"and c.psccdPkId.curriculumVersion=?11 and c.catalogType='BC' and c.courseCategory=?10 and "+
			"c.status=0 and d.status=0 and c.psccdPkId.courseBasketId=d.bccPkId.basketId)) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findCurriculumPCPEUCPagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, Integer specId, Integer studYear, String courseCategory, 
			Float curriculumVersion, Pageable pageable);
	
	//Curriculum based course display Pagination with Course Owner Search - PC/ PE/ UC	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem in (?2) "+
			"and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and a.ownerCode=?12 and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and "+
			"a.status=0 and a.courseId in (select distinct b.courseId from CourseAllocationModel b where "+
			"b.semesterSubId=?5 and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and "+
			"b.lockStatus=0) and (a.code in (select d.code from ProgrammeSpecializationCurriculumDetailModel c, "+
			"CourseCatalogModel d where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 and "+
			"c.psccdPkId.curriculumVersion=?11 and c.catalogType='CC' and c.courseCategory=?10 and "+
			"c.status=0 and c.psccdPkId.courseBasketId=d.courseId) or a.code "+
			"in (select d.courseCatalogModel.code from ProgrammeSpecializationCurriculumDetailModel c, "+
			"BasketCourseCatalogModel d where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 "+
			"and c.psccdPkId.curriculumVersion=?11 and c.catalogType='BC' and c.courseCategory=?10 and "+
			"c.status=0 and d.status=0 and c.psccdPkId.courseBasketId=d.bccPkId.basketId)) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findCurriculumPCPEUCCourseOwnerPagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, Integer specId, Integer studYear, String courseCategory, Float curriculumVersion, 
			String searchval, Pageable pageable);
	
	//Curriculum based course display Pagination with Course Code Search - PC/ PE/ UC
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem in (?2) "+
			"and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and (a.code like ?12) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and "+
			"a.status=0 and a.courseId in (select distinct b.courseId from CourseAllocationModel b where "+
			"b.semesterSubId=?5 and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and "+
			"b.lockStatus=0) and (a.code in (select d.code from ProgrammeSpecializationCurriculumDetailModel c, "+
			"CourseCatalogModel d where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 and "+
			"c.psccdPkId.curriculumVersion=?11 and c.catalogType='CC' and c.courseCategory=?10 and "+
			"c.status=0 and c.psccdPkId.courseBasketId=d.courseId) or a.code "+
			"in (select d.courseCatalogModel.code from ProgrammeSpecializationCurriculumDetailModel c, "+
			"BasketCourseCatalogModel d where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 "+
			"and c.psccdPkId.curriculumVersion=?11 and c.catalogType='BC' and c.courseCategory=?10 and "+
			"c.status=0 and d.status=0 and c.psccdPkId.courseBasketId=d.bccPkId.basketId)) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findCurriculumPCPEUCCourseCodePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, Integer specId, Integer studYear, String courseCategory, Float curriculumVersion, 
			String searchval, Pageable pageable);
	
	//Curriculum based course display Pagination with Course Title Search - PC/ PE/ UC	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem in (?2) "+
			"and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and (upper(a.title) like ?12) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and "+
			"a.status=0 and a.courseId in (select distinct b.courseId from CourseAllocationModel b where "+
			"b.semesterSubId=?5 and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and "+
			"b.lockStatus=0) and (a.code in (select d.code from ProgrammeSpecializationCurriculumDetailModel c, "+
			"CourseCatalogModel d where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 and "+
			"c.psccdPkId.curriculumVersion=?11 and c.catalogType='CC' and c.courseCategory=?10 and "+
			"c.status=0 and c.psccdPkId.courseBasketId=d.courseId) or a.code "+
			"in (select d.courseCatalogModel.code from ProgrammeSpecializationCurriculumDetailModel c, "+
			"BasketCourseCatalogModel d where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 "+
			"and c.psccdPkId.curriculumVersion=?11 and c.catalogType='BC' and c.courseCategory=?10 and "+
			"c.status=0 and d.status=0 and c.psccdPkId.courseBasketId=d.bccPkId.basketId)) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findCurriculumPCPEUCCourseTitlePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, Integer specId, Integer studYear, String courseCategory, Float curriculumVersion, 
			String searchval, Pageable pageable);
	
	
	//Curriculum based course display - UE
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem in (?2) "+
			"and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 and "+
			"b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and a.code not in "+
			"(select d.code from ProgrammeSpecializationCurriculumDetailModel c, CourseCatalogModel d "+
			"where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 and "+
			"c.psccdPkId.curriculumVersion=?10 and c.status=0 and c.psccdPkId.courseBasketId=d.courseId) "+
			"and a.code not in (select d.courseCatalogModel.code from ProgrammeSpecializationCurriculumDetailModel c, "+
			"BasketCourseCatalogModel d where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 "+
			"and c.psccdPkId.curriculumVersion=?10 and c.catalogType='BC' and c.status=0 and d.status=0 and "+
			"c.psccdPkId.courseBasketId=d.bccPkId.basketId) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	List<CourseCatalogModel> findCurriculumUEList(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, Integer specId, Integer studYear, Float curriculumVersion);
	
	//Curriculum based course pagination with out search - UE	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem in (?2) "+
			"and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 and "+
			"b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and a.code not in "+
			"(select d.code from ProgrammeSpecializationCurriculumDetailModel c, CourseCatalogModel d "+
			"where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 and "+
			"c.psccdPkId.curriculumVersion=?10 and c.status=0 and c.psccdPkId.courseBasketId=d.courseId) "+
			"and a.code not in (select d.courseCatalogModel.code from ProgrammeSpecializationCurriculumDetailModel c, "+
			"BasketCourseCatalogModel d where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 "+
			"and c.psccdPkId.curriculumVersion=?10 and c.catalogType='BC' and c.status=0 and d.status=0 and "+
			"c.psccdPkId.courseBasketId=d.bccPkId.basketId) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findCurriculumUEPagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, Integer specId, Integer studYear, Float curriculumVersion, Pageable pageable);
	
	//Curriculum based course pagination with Course Owner search - UE	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem in (?2) "+
			"and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and a.ownerCode=?11 and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 and "+
			"b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and a.code not in "+
			"(select d.code from ProgrammeSpecializationCurriculumDetailModel c, CourseCatalogModel d "+
			"where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 and "+
			"c.psccdPkId.curriculumVersion=?10 and c.status=0 and c.psccdPkId.courseBasketId=d.courseId) "+
			"and a.code not in (select d.courseCatalogModel.code from ProgrammeSpecializationCurriculumDetailModel c, "+
			"BasketCourseCatalogModel d where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 "+
			"and c.psccdPkId.curriculumVersion=?10 and c.catalogType='BC' and c.status=0 and d.status=0 and "+
			"c.psccdPkId.courseBasketId=d.bccPkId.basketId) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findCurriculumUECourseOwnerPagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, Integer specId, Integer studYear, Float curriculumVersion, String searchval, 
			Pageable pageable);
	
	//Curriculum based course pagination with Course Code search - UE	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem in (?2) "+
			"and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and (a.code like ?11) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 and "+
			"b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and a.code not in "+
			"(select d.code from ProgrammeSpecializationCurriculumDetailModel c, CourseCatalogModel d "+
			"where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 and "+
			"c.psccdPkId.curriculumVersion=?10 and c.status=0 and c.psccdPkId.courseBasketId=d.courseId) "+
			"and a.code not in (select d.courseCatalogModel.code from ProgrammeSpecializationCurriculumDetailModel c, "+
			"BasketCourseCatalogModel d where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 "+
			"and c.psccdPkId.curriculumVersion=?10 and c.catalogType='BC' and c.status=0 and d.status=0 and "+
			"c.psccdPkId.courseBasketId=d.bccPkId.basketId) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findCurriculumUECourseCodePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, Integer specId, Integer studYear, Float curriculumVersion, String searchval, 
			Pageable pageable);
	
	//Curriculum based course pagination with Course Title search - UE	
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem in (?2) "+
			"and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and (upper(a.title) like ?11) and "+
			"a.genericCourseType not in ('SS') and (a.code not like 'SET%') and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 and "+
			"b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) and a.code not in "+
			"(select d.code from ProgrammeSpecializationCurriculumDetailModel c, CourseCatalogModel d "+
			"where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 and "+
			"c.psccdPkId.curriculumVersion=?10 and c.status=0 and c.psccdPkId.courseBasketId=d.courseId) "+
			"and a.code not in (select d.courseCatalogModel.code from ProgrammeSpecializationCurriculumDetailModel c, "+
			"BasketCourseCatalogModel d where c.psccdPkId.specializationId=?8 and c.psccdPkId.admissionYear=?9 "+
			"and c.psccdPkId.curriculumVersion=?10 and c.catalogType='BC' and c.status=0 and d.status=0 and "+
			"c.psccdPkId.courseBasketId=d.bccPkId.basketId) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findCurriculumUECourseTitlePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, Integer specId, Integer studYear, Float curriculumVersion, String searchval, 
			Pageable pageable);
	
	
	//Soft Skill Courses - CAL
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and a.courseSystem "+
			"in (?2) and (a.groupId in (?3) or (a.groupCode=?4 or a.groupCode like ?4||'/%' "+
			"or a.groupCode like '%/'||?4||'/%' or a.groupCode like '%/'||?4)) and "+
			"a.code in (?8) and a.status=0 and a.courseId in "+
			"(select distinct b.courseId from CourseAllocationModel b where b.semesterSubId=?5 "+
			"and b.clsGrpMasterGroupId in (?6) and b.classType in (?7) and b.lockStatus=0) "+
			"order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findCALSoftSkillCoursePagination(String campusCode, String[] courseSystem, 
			List<Integer> egbGroupId, String groupCode, String semesterSubId, String[] classGroupId, 
			String[] classType, List<String> courseCode, Pageable pageable);
	
	//Soft Skill Courses - FFCS & CAL
	@Query("select a from CourseCatalogModel a where a.campusCode=?1 and "+
			"(a.groupId in (?2) or (a.groupCode=?3 or a.groupCode like ?3||'/%' "+
			"or a.groupCode like '%/'||?3||'/%' or a.groupCode like '%/'||?3)) and "+
			"(a.code in (?7) or a.code in (select c.courseCode from CourseEquivalancesModel c "+
			"where c.equivalentCourseCode in (?7)) or a.code in (select d.equivalentCourseCode "+
			"from CourseEquivalancesModel d where d.courseCode in (?7))) and "+
			"a.status=0 and a.courseId in (select distinct b.courseId from CourseAllocationModel b "+
			"where b.semesterSubId=?4 and b.clsGrpMasterGroupId in (?5) and b.classType in (?6) "+
			"and b.lockStatus=0) order by a.ownerCode, a.code, a.courseVersion")
	Page<CourseCatalogModel> findFFCSSoftSkillCoursePagination(String campusCode, List<Integer> egbGroupId, 
			String groupCode, String semesterSubId, String[] classGroupId, String[] classType, 
			List<String> courseCode, Pageable pageable);
	
}
