package org.vtop.CourseRegistration.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.vtop.CourseRegistration.model.CourseRegistrationModel;
import org.vtop.CourseRegistration.model.FeedbackAnswerModel;
import org.vtop.CourseRegistration.model.FeedbackAnswerPkModel;
import org.vtop.CourseRegistration.model.FeedbackGeneralAnswersModel;
import org.vtop.CourseRegistration.model.FeedbackGeneralAnswersPKModel;
import org.vtop.CourseRegistration.model.FeedbackStudentReferenceModel;
import org.vtop.CourseRegistration.model.FeedbackStudentReferencePKModel;
import org.vtop.CourseRegistration.repository.CourseRegistrationWithdrawOTPRepository;
import org.vtop.CourseRegistration.repository.CourseRegistrationWithdrawRepository;
import org.vtop.CourseRegistration.repository.FeedbackAnswerRepository;
import org.vtop.CourseRegistration.repository.FeedbackGeneralAnswerRepository;
import org.vtop.CourseRegistration.repository.FeedbackQuestionRepository;
import org.vtop.CourseRegistration.repository.FeedbackStudentReferenceRepository;
import org.vtop.CourseRegistration.repository.WishlistRegistrationRepository;
import org.vtop.CourseRegistration.service.ActivityDetailsService;
import org.vtop.CourseRegistration.service.AdditionalLearningCourseCatalogService;
import org.vtop.CourseRegistration.service.AdditionalLearningDetailsService;
import org.vtop.CourseRegistration.service.CampusAPI;
import org.vtop.CourseRegistration.service.CompulsoryCourseConditionDetailService;
import org.vtop.CourseRegistration.service.CourseAllocationService;
import org.vtop.CourseRegistration.service.CourseCatalogService;
import org.vtop.CourseRegistration.service.CourseEligibleService;
import org.vtop.CourseRegistration.service.CourseEquivalanceRegService;
import org.vtop.CourseRegistration.service.CourseRegistrationCommonFunction;
import org.vtop.CourseRegistration.service.CourseRegistrationService;
import org.vtop.CourseRegistration.service.CourseRegistrationWaitingMoveService;
import org.vtop.CourseRegistration.service.CourseRegistrationWaitingService;
import org.vtop.CourseRegistration.service.CourseTypeMasterService;
import org.vtop.CourseRegistration.service.CurriculumProgramService;
import org.vtop.CourseRegistration.service.ProgrammeSpecializationService;
import org.vtop.CourseRegistration.service.ProjectRegistrationService;
import org.vtop.CourseRegistration.service.RegistrationLogService;
import org.vtop.CourseRegistration.service.RegistrationScheduleService;
import org.vtop.CourseRegistration.service.StudentCreditTransferService;
import org.vtop.CourseRegistration.service.StudentLoginDetailsService;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

@Controller
public class CourseFeedbackController 
{
	//private static final Logger logger = LogManager.getLogger(CourseFeedbackController.class);
	private static final String RegErrorMethod = "WSENDFEEDBACK201920";
	private static final String WCLASSGROUPID = "ALL";
	private static final Integer fbPattern = 1;
	private static final String feedbackType = "TEE";	

	@Autowired
	StudentLoginDetailsService studentLoginDetailsService;

	@Autowired
	ProgrammeSpecializationService programmeSpecializationService;

	@Autowired
	CourseEligibleService courseEligibleService;

	@Autowired
	ActivityDetailsService activityDetailsService;

	@Autowired
	StudentCreditTransferService studentCreditTransferService;

	@Autowired
	CurriculumProgramService curriculumProgramService;

	@Autowired
	CourseCatalogService courseCatalogService;

	@Autowired
	CourseAllocationService courseAllocationService;

	@Autowired
	CourseRegistrationService courseRegistrationService;

	@Autowired
	CourseTypeMasterService courseTypeMasterService;

	@Autowired
	CourseRegistrationWaitingService courseRegistrationWaitingService;

	@Autowired
	AdditionalLearningDetailsService additionalLearningDetailsService;

	@Autowired
	AdditionalLearningCourseCatalogService additionalLearningCourseCatalogService;

	@Autowired
	CourseEquivalanceRegService courseEquivalanceRegService;

	@Autowired
	CampusAPI campusAPI;

	@Autowired
	RegistrationScheduleService registrationScheduleService;

	@Autowired
	CompulsoryCourseConditionDetailService compulsoryCourseConditionDetailService;
	
	@Autowired
	ProjectRegistrationService projectRegistrationService;
	
	@Autowired
	CourseRegistrationCommonFunction courseRegCommonFn;	
	
	@Autowired
	public CourseRegistrationWaitingMoveService courseRegistrationWaitingMoveService;	

	@Autowired
	RegistrationLogService registrationLogService;
	
	@Autowired
	WishlistRegistrationRepository wishlistRegistrationRepository;
		
	@Autowired
	public CourseRegistrationWithdrawRepository courseRegistrationWithdrawRepository;
	
	@Autowired
	CourseRegistrationWithdrawOTPRepository courseRegistrationWithdrawOTPRepository;
				
	@Autowired
	public FeedbackQuestionRepository feedbackQuestionRepository;
		
	@Autowired
	public FeedbackAnswerRepository feedbackAnswerRepository;
	
	@Autowired
	public FeedbackStudentReferenceRepository feedbackStudentReferenceRepository;
	
	@Autowired
	public FeedbackGeneralAnswerRepository feedbackGeneralAnswerRepository;
	
	
	//General Feedback Process
	//------------------------
	@PostMapping("processCheckFeedbackPerception")
	public String processCheckFeedbackPerception(Model model, HttpSession session, HttpServletRequest request) 
	{	
		String registerNumber = (String) session.getAttribute("RegisterNumber");				
		String msg = null, infoMsg = "", urlPage = "";
		Integer allowStatus = 2;			
		String ipAddress = request.getRemoteAddr();
		Integer updateStatus = 0;
		String[] classGroupId = { WCLASSGROUPID, "UGF", "PGF","ALL02" };
		
		try
		{	
			if (registerNumber!=null)
			{
				String semesterSubId = (String) session.getAttribute("SemesterSubId");
				Long studentId = (Long) session.getAttribute("studentId");
				
				Date startDate = (Date) session.getAttribute("startDate");
				Date endDate = (Date) session.getAttribute("endDate");
				String startTime = (String) session.getAttribute("startTime");
				String endTime = (String) session.getAttribute("endTime");
				
				String returnVal = courseRegCommonFn.AddorDropDateTimeCheck(startDate, endDate, startTime, endTime, registerNumber, updateStatus, ipAddress);
				String[] statusMsg = returnVal.split("/");
				allowStatus = Integer.parseInt(statusMsg[0]);
				infoMsg = statusMsg[1];
				
				FeedbackGeneralAnswersModel feedbackGeneralAnswersModel = new FeedbackGeneralAnswersModel();
				String fbCourseType = "GENERAL";
				
				switch(allowStatus)
				{
					case 1:
												
						feedbackGeneralAnswersModel = feedbackGeneralAnswerRepository.findAnswerByTypeClassIdAndSlno(semesterSubId, 
														feedbackType, studentId);
					/*	if (feedbackGeneralAnswersModel != null)
						{	*/
							/*model.addAttribute("courseRegistrationModel", courseRegistrationService
									.getByRegisterNumberAndClassGroup(semesterSubId, registerNumber, classGroupId));*/
							model.addAttribute("courseRegistrationModel", courseRegistrationService
									.getByRegisterNumberAndClassGroup2(semesterSubId, registerNumber, classGroupId));
							model.addAttribute("fbPostList", feedbackStudentReferenceRepository.
									getReferenceClassIdByTypeAndRegisterNo(semesterSubId, feedbackType, registerNumber));
							urlPage = "mainpages/CourseFeedback::section";
							/*}
						else
						{
							model.addAttribute("generalFbQuestion", feedbackQuestionRepository.
													getQuestionByPatternAndType2(fbPattern, fbCourseType));
							urlPage = "mainpages/GeneralFeedbackPerception :: section";
						} */
						
						break;
					
					default:						
						msg = infoMsg;						
						session.setAttribute("info", msg);
						model.addAttribute("flag", 2);
						urlPage = "redirectpage";
						return urlPage;
				}
			}
			else
			{
				model.addAttribute("flag", 1);
				urlPage = "redirectpage";
				return urlPage;
			}
		}
		catch(Exception e)
		{
			model.addAttribute("flag", 1);
			registrationLogService.addErrorLog(e.toString(), RegErrorMethod+"CourseFeedBackController", 
					"processCheckFeedbackPerception", registerNumber, request.getRemoteAddr());
			urlPage = "redirectpage";
			return urlPage;
		}
		
		return urlPage;
	}
	
	@PostMapping("saveGeneralFeedbackPerception")
	public String saveGeneralFeedbackPerception(Model model, HttpSession session, HttpServletRequest request) 
	{	
		String registerNumber = (String) session.getAttribute("RegisterNumber");				
		String msg = null, infoMsg = "", urlPage = "";
		Integer allowStatus = 2;			
		String ipAddress = request.getRemoteAddr();
		Integer updateStatus = 0;
		String[] classGroupId = { WCLASSGROUPID, "UGF", "PGF","ALL02" };
		Long studentId = (Long) session.getAttribute("studentId");
		
		try
		{	
			if (registerNumber!=null)
			{
				String semesterSubId = (String) session.getAttribute("SemesterSubId");
				
				Date startDate = (Date) session.getAttribute("startDate");
				Date endDate = (Date) session.getAttribute("endDate");
				String startTime = (String) session.getAttribute("startTime");
				String endTime = (String) session.getAttribute("endTime");
								
				String returnVal = courseRegCommonFn.AddorDropDateTimeCheck(startDate, endDate, startTime, endTime, registerNumber, updateStatus, ipAddress);
				String[] statusMsg = returnVal.split("/");
				allowStatus = Integer.parseInt(statusMsg[0]);
				infoMsg = statusMsg[1];
				
				FeedbackGeneralAnswersPKModel feedbackGeneralAnswersPKModel = new FeedbackGeneralAnswersPKModel();
				FeedbackGeneralAnswersModel feedbackGeneralAnswersModel = new FeedbackGeneralAnswersModel();
								
				int fbAnsType = 0, ratingAns = 0;				
				int fba01 = 0, fba02 = 0, fba03= 0, fba04 = 0, fba05 = 0;
								
				//String courseId = "", courseType= "", classId="", employeeId="",stateAns = "";				
				String[] ansTypeArr = request.getParameterValues("ansType");
				String[] qnoArr = request.getParameterValues("qno");
				String qno = "";
												
				switch(allowStatus)
				{
					case 1:
												
						//Check & assigning the data
						for (int i = 0; i<qnoArr.length; i++)
						{
							qno = qnoArr[i];
							fbAnsType = Integer.parseInt(ansTypeArr[i]);
							//stateAns = "";
							ratingAns = 0;
								
							/*System.out.println("QNo.: "+ qno + " | ansType: "+ fbAnsType + 
									" | inputVal: "+ request.getParameter(qno));*/
								
							if (fbAnsType ==  1)
							{
								ratingAns = Integer.parseInt(request.getParameter(qno));
								
								if (qno.equals("FBA01"))
									fba01 = ratingAns;
								else if (qno.equals("FBA02"))
									fba02 = ratingAns;
								else if (qno.equals("FBA03"))
									fba03 = ratingAns;
								else if (qno.equals("FBA04"))
									fba04 = ratingAns;
								else if (qno.equals("FBA05"))
									fba05 = ratingAns;
							}
						}
														
						synchronized (this)
						{
							//Saving the Student Feedback data
							//--------------------------------
							feedbackGeneralAnswersPKModel.setSemesterSubId(semesterSubId);
							feedbackGeneralAnswersPKModel.setFeedbackType(feedbackType);
							feedbackGeneralAnswersPKModel.setFbSlNo(studentId);
							feedbackGeneralAnswersModel.setFbgaPkId(feedbackGeneralAnswersPKModel);
							feedbackGeneralAnswersModel.setFbgAns01(fba01);
							feedbackGeneralAnswersModel.setFbgAns02(fba02);
							feedbackGeneralAnswersModel.setFbgAns03(fba03);
							feedbackGeneralAnswersModel.setFbgAns04(fba04);
							feedbackGeneralAnswersModel.setFbgAns05(fba05);
							feedbackGeneralAnswersModel.setLogTimestamp(new Date());
							feedbackGeneralAnswersModel.setLogIpaddress(ipAddress);
							feedbackGeneralAnswerRepository.save(feedbackGeneralAnswersModel);
						}
						
						/*model.addAttribute("courseRegistrationModel", courseRegistrationService
									.getByRegisterNumberAndClassGroup(semesterSubId, registerNumber, classGroupId));*/
						model.addAttribute("courseRegistrationModel", courseRegistrationService
								.getByRegisterNumberAndClassGroup2(semesterSubId, registerNumber, classGroupId));
						model.addAttribute("fbPostList", feedbackStudentReferenceRepository.
									getReferenceClassIdByTypeAndRegisterNo(semesterSubId, feedbackType, registerNumber));
						urlPage = "mainpages/CourseFeedback :: section";
												
						break;
					
					default:						
						msg = infoMsg;						
						session.setAttribute("info", msg);
						model.addAttribute("flag", 2);
						urlPage = "redirectpage";
						return urlPage;
				}
			}
			else
			{
				model.addAttribute("flag", 1);
				urlPage = "redirectpage";
				return urlPage;
			}
		}
		catch(Exception e)
		{
			model.addAttribute("flag", 1);
			registrationLogService.addErrorLog(e.toString(), RegErrorMethod+"CourseFeedBackController", 
					"saveGeneralFeedbackPerception", registerNumber, request.getRemoteAddr());
			urlPage = "redirectpage";
			return urlPage;
		}
		
		return urlPage;
	}
	
	
	//Course Feedback Process
	//-----------------------
	@PostMapping("processCourseFeedback")
	public String processCourseFeedback(Model model, HttpSession session, HttpServletRequest request) 
	{	
		String registerNumber = (String) session.getAttribute("RegisterNumber");				
		String msg = null, infoMsg = "", urlPage = "";
		Integer allowStatus = 2;			
		String ipAddress = request.getRemoteAddr();
		Integer updateStatus = 0;
		String[] classGroupId = { WCLASSGROUPID, "UGF", "PGF","ALL02" };
		
		try
		{	
			if (registerNumber!=null)
			{
				
				String semesterSubId = (String) session.getAttribute("SemesterSubId");
				
				Date startDate = (Date) session.getAttribute("startDate");
				Date endDate = (Date) session.getAttribute("endDate");
				String startTime = (String) session.getAttribute("startTime");
				String endTime = (String) session.getAttribute("endTime");
								
				String returnVal = courseRegCommonFn.AddorDropDateTimeCheck(startDate, endDate, startTime, endTime, registerNumber, updateStatus, ipAddress);
				
				String[] statusMsg = returnVal.split("/");
				allowStatus = Integer.parseInt(statusMsg[0]);
				infoMsg = statusMsg[1];
				
				switch(allowStatus)
				{
					case 1:
						/*model.addAttribute("courseRegistrationModel", courseRegistrationService
								.getByRegisterNumberAndClassGroup(semesterSubId, registerNumber, classGroupId));*/
						model.addAttribute("courseRegistrationModel", courseRegistrationService
								.getByRegisterNumberAndClassGroup2(semesterSubId, registerNumber, classGroupId));
						model.addAttribute("fbPostList", feedbackStudentReferenceRepository.
								getReferenceClassIdByTypeAndRegisterNo(semesterSubId, feedbackType, registerNumber));
						urlPage = "mainpages/CourseFeedback :: section";
						break;
					
					default:						
						msg = infoMsg;						
						session.setAttribute("info", msg);
						model.addAttribute("flag", 2);
						urlPage = "redirectpage";
						return urlPage;
				}
			}
			else
			{
				model.addAttribute("flag", 1);
				urlPage = "redirectpage";
				return urlPage;
			}
		}
		catch(Exception e)
		{
			model.addAttribute("flag", 1);
			registrationLogService.addErrorLog(e.toString(), RegErrorMethod+"CourseFeedBackController", 
					"processCourseFeedback", registerNumber, request.getRemoteAddr());
			urlPage = "redirectpage";
			return urlPage;
		}
		
		return urlPage;
	}
	
	
	@PostMapping("processCourseFeedbackPerception")
	public String processCourseFeedbackPerception(String courseId, String courseType, Model model, 
				HttpSession session, HttpServletRequest request) 
	{	
		String registerNumber = (String) session.getAttribute("RegisterNumber");				
		String msg = null, infoMsg = "", urlPage = "";
		Integer allowStatus = 2;			
		String ipAddress = request.getRemoteAddr();
		Integer updateStatus = 0;
		String[] classGroupId = { WCLASSGROUPID, "UGF", "PGF","ALL02" };
		
		
		
		try
		{	
			if (registerNumber!=null)
			{
				
				String semesterSubId = (String) session.getAttribute("SemesterSubId");
				
				Date startDate = (Date) session.getAttribute("startDate");
				Date endDate = (Date) session.getAttribute("endDate");
				String startTime = (String) session.getAttribute("startTime");
				String endTime = (String) session.getAttribute("endTime");
								
				String returnVal = courseRegCommonFn.AddorDropDateTimeCheck(startDate, endDate, startTime, endTime, registerNumber, updateStatus, ipAddress);
				String[] statusMsg = returnVal.split("/");
				allowStatus = Integer.parseInt(statusMsg[0]);
				infoMsg = statusMsg[1];
				
				CourseRegistrationModel courseRegistrationModel = new CourseRegistrationModel();
				String fbCourseType = "";
				
				switch(allowStatus)
				{
					case 1:
												
						courseRegistrationModel = courseRegistrationService.getByRegisterNumberCourseIdAndType(semesterSubId, 
													registerNumber, courseId, courseType);
						if (courseRegistrationModel != null)
						{
							if ((courseType.equals("ETH")) || (courseType.equals("TH")) || (courseType.equals("SS")))
							{
								fbCourseType = "THEORY";
							}
							else if ((courseType.equals("ELA")) || (courseType.equals("LO")))
							{
								fbCourseType = "LAB";
							}
							
							model.addAttribute("courseRegistrationModel", courseRegistrationModel);
							model.addAttribute("courseId", courseId);
							model.addAttribute("courseType", courseType);
							model.addAttribute("fbQuestion", feedbackQuestionRepository.
													getQuestionByPatternAndType2(fbPattern, fbCourseType));
														
							urlPage = "mainpages/CourseFeedbackPerception :: section";
						}
						else
						{
							/*model.addAttribute("courseRegistrationModel", courseRegistrationService
									.getByRegisterNumberAndClassGroup(semesterSubId, registerNumber, classGroupId));*/
							model.addAttribute("courseRegistrationModel", courseRegistrationService
									.getByRegisterNumberAndClassGroup2(semesterSubId, registerNumber, classGroupId));
							model.addAttribute("fbPostList", feedbackStudentReferenceRepository.
									getReferenceClassIdByTypeAndRegisterNo(semesterSubId, feedbackType, registerNumber));
							urlPage = "mainpages/CourseFeedback::section";
						}
						
						break;
					
					default:						
						msg = infoMsg;						
						session.setAttribute("info", msg);
						model.addAttribute("flag", 2);
						urlPage = "redirectpage";
						return urlPage;
				}
			}
			else
			{
				model.addAttribute("flag", 1);
				urlPage = "redirectpage";
				return urlPage;
			}
		}
		catch(Exception e)
		{
			model.addAttribute("flag", 1);
			registrationLogService.addErrorLog(e.toString(), RegErrorMethod+"CourseFeedBackController", 
					"processCourseFeedbackPerception", registerNumber, request.getRemoteAddr());
			urlPage = "redirectpage";
			return urlPage;
		}
		
		return urlPage;
	}
	
	
	@PostMapping("saveCourseFeedbackPerception")
	public String saveCourseFeedbackPerception(Model model, HttpSession session, HttpServletRequest request) 
	{	
		String registerNumber = (String) session.getAttribute("RegisterNumber");				
		String msg = null, infoMsg = "", urlPage = "";
		Integer allowStatus = 2;			
		String ipAddress = request.getRemoteAddr();
		Integer updateStatus = 0;
		String[] classGroupId = { WCLASSGROUPID, "UGF", "PGF","ALL02" };
		Long studentId = (Long) session.getAttribute("studentId");

		try
		{	
			if (registerNumber!=null)
			{
				
				String semesterSubId = (String) session.getAttribute("SemesterSubId");
				
				Date startDate = (Date) session.getAttribute("startDate");
				Date endDate = (Date) session.getAttribute("endDate");
				String startTime = (String) session.getAttribute("startTime");
				String endTime = (String) session.getAttribute("endTime");
				
				String returnVal = courseRegCommonFn.AddorDropDateTimeCheck(startDate, endDate, startTime, endTime, registerNumber, updateStatus, ipAddress);
				String[] statusMsg = returnVal.split("/");
				allowStatus = Integer.parseInt(statusMsg[0]);
				infoMsg = statusMsg[1];
								
				CourseRegistrationModel courseRegistrationModel = new CourseRegistrationModel();
				FeedbackAnswerPkModel feedbackAnswerPkModel = new FeedbackAnswerPkModel();
				FeedbackAnswerModel feedbackAnswerModel = new FeedbackAnswerModel();
				FeedbackStudentReferencePKModel feedbackStudentReferencePKModel = new FeedbackStudentReferencePKModel();
				FeedbackStudentReferenceModel feedbackStudentReferenceModel = new FeedbackStudentReferenceModel();
				
				
				int checkFlag = 2;
				int fbAnsType = 0, ratingAns = 0;				
				int fba01 = 0, fba02 = 0, fba03= 0, fba04 = 0, fba05 = 0;
				int fba06 = 0, fba07 = 0, fba08= 0, fba09 = 0, fba10 = 0;
				int fba11 = 0, fba12 = 0, fba13= 0, fba14 = 0;
				
				String courseId = "", courseType= "", classId="", employeeId="";
				String fbs01 = null, fbs02 = null, fbs03 = null, fbs04 = null;
				
				String[] ansTypeArr = request.getParameterValues("ansType");
				String[] qnoArr = request.getParameterValues("qno");
				String qno = "", stateAns = "";
				
				courseId = request.getParameter("courseId");
				courseType = request.getParameter("courseType");
								
				switch(allowStatus)
				{
					case 1:
												
						courseRegistrationModel = courseRegistrationService.getByRegisterNumberCourseIdAndType(semesterSubId, 
													registerNumber, courseId, courseType);
						if (courseRegistrationModel != null)
						{
							classId = courseRegistrationModel.getClassId();
							employeeId = courseRegistrationModel.getCourseAllocationModel().getErpId();
							checkFlag = 1;
						}
						
						if (checkFlag == 1)
						{
							//Check & assigning the data
							for (int i = 0; i<qnoArr.length; i++)
							{
								qno = qnoArr[i];
								fbAnsType = Integer.parseInt(ansTypeArr[i]);
								stateAns = "";
								ratingAns = 0;
								
								/*System.out.println("QNo.: "+ qno + " | ansType: "+ fbAnsType + 
										" | inputVal: "+ request.getParameter(qno));*/
								
								if (fbAnsType ==  1)
								{
									ratingAns = Integer.parseInt(request.getParameter(qno));
									
									if (qno.equals("FBA01"))
										fba01 = ratingAns;
									else if (qno.equals("FBA02"))
										fba02 = ratingAns;
									else if (qno.equals("FBA03"))
										fba03 = ratingAns;
									else if (qno.equals("FBA04"))
										fba04 = ratingAns;
									else if (qno.equals("FBA05"))
										fba05 = ratingAns;
									else if (qno.equals("FBA06"))
										fba06 = ratingAns;
									else if (qno.equals("FBA07"))
										fba07 = ratingAns;
									else if (qno.equals("FBA08"))
										fba08 = ratingAns;
									else if (qno.equals("FBA09"))
										fba09 = ratingAns;
									else if (qno.equals("FBA10"))
										fba10 = ratingAns;
									else if (qno.equals("FBA11"))
										fba11 = ratingAns;
									else if (qno.equals("FBA12"))
										fba12 = ratingAns;
									else if (qno.equals("FBA13"))
										fba13 = ratingAns;
									else if (qno.equals("FBA14"))
										fba14 = ratingAns;
								}
								else if (fbAnsType ==  2)
								{
									stateAns = request.getParameter(qno).trim();
									if (stateAns.length() > 250)
									{
										stateAns = stateAns.substring(0, 251);
									}
									
									if (qno.equals("FBS01"))
										fbs01 = stateAns;
									else if (qno.equals("FBS02"))
										fbs02 = stateAns;
									else if (qno.equals("FBS03"))
										fbs03 = stateAns;
									else if (qno.equals("FBS04"))
										fbs04 = stateAns;
								}
							}
							
							synchronized (this)
							{
								//Saving the Student Feedback data
								//--------------------------------
								feedbackAnswerPkModel.setSemesterSubId(semesterSubId);
								feedbackAnswerPkModel.setFeedbackType(feedbackType);
								feedbackAnswerPkModel.setClassId(classId);
								feedbackAnswerPkModel.setFbSlNo(studentId);
								feedbackAnswerModel.setFbaPkId(feedbackAnswerPkModel);
								feedbackAnswerModel.setEmployeeId(employeeId);
								feedbackAnswerModel.setCourseId(courseId);
								feedbackAnswerModel.setCourseType(courseType);
								feedbackAnswerModel.setFba01(fba01);
								feedbackAnswerModel.setFba02(fba02);
								feedbackAnswerModel.setFba03(fba03);
								feedbackAnswerModel.setFba04(fba04);
								feedbackAnswerModel.setFba05(fba05);
								feedbackAnswerModel.setFba06(fba06);
								feedbackAnswerModel.setFba07(fba07);
								feedbackAnswerModel.setFba08(fba08);
								feedbackAnswerModel.setFba09(fba09);
								feedbackAnswerModel.setFba10(fba10);
								feedbackAnswerModel.setFba11(fba11);
								feedbackAnswerModel.setFba12(fba12);
								feedbackAnswerModel.setFba13(fba13);
								feedbackAnswerModel.setFba14(fba14);
								feedbackAnswerModel.setFbs01(fbs01);
								feedbackAnswerModel.setFbs02(fbs02);
								feedbackAnswerModel.setFbs03(fbs03);
								feedbackAnswerModel.setFbs04(fbs04);
								feedbackAnswerModel.setLockStatus(0);
								feedbackAnswerModel.setLogTimestamp(new Date());
								feedbackAnswerModel.setLogIpaddress(ipAddress);
								feedbackAnswerRepository.save(feedbackAnswerModel);
								
								//Saving the Student Feedback Reference data
								//------------------------------------------
								feedbackStudentReferencePKModel.setSemesterSubId(semesterSubId);
								feedbackStudentReferencePKModel.setFeedbackType(feedbackType);
								feedbackStudentReferencePKModel.setClassId(classId);
								feedbackStudentReferencePKModel.setRegisterNumber(registerNumber);
								feedbackStudentReferenceModel.setFbsrPkId(feedbackStudentReferencePKModel);
								feedbackStudentReferenceModel.setFeedbackGiven(1);
								feedbackStudentReferenceRepository.save(feedbackStudentReferenceModel);
							}
						}
						
						/*model.addAttribute("courseRegistrationModel", courseRegistrationService
									.getByRegisterNumberAndClassGroup(semesterSubId, registerNumber, classGroupId));*/
						model.addAttribute("courseRegistrationModel", courseRegistrationService
								.getByRegisterNumberAndClassGroup2(semesterSubId, registerNumber, classGroupId));
						model.addAttribute("fbPostList", feedbackStudentReferenceRepository.
									getReferenceClassIdByTypeAndRegisterNo(semesterSubId, feedbackType, registerNumber));
						urlPage = "mainpages/CourseFeedback :: section";
												
						break;
					
					default:						
						msg = infoMsg;						
						session.setAttribute("info", msg);
						model.addAttribute("flag", 2);
						urlPage = "redirectpage";
						return urlPage;
				}
			}
			else
			{
				model.addAttribute("flag", 1);
				urlPage = "redirectpage";
				return urlPage;
			}
		}
		catch(Exception e)
		{
			model.addAttribute("flag", 1);
			registrationLogService.addErrorLog(e.toString(), RegErrorMethod+"CourseFeedBackController", 
					"saveCourseFeedbackPerception", registerNumber, request.getRemoteAddr());
			urlPage = "redirectpage";
			return urlPage;
		}
		
		return urlPage;
	}
		
}
