package org.vtop.CourseRegistration.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.vtop.CourseRegistration.model.RegistrationLogModel;
import org.vtop.CourseRegistration.model.SemesterDetailsModel;
import org.vtop.CourseRegistration.model.StudentsLoginDetailsModel;
import org.vtop.CourseRegistration.service.CourseRegistrationCommonFunction;
import org.vtop.CourseRegistration.service.CourseRegistrationService;
import org.vtop.CourseRegistration.service.RegistrationLogService;
import org.vtop.CourseRegistration.service.SemesterDetailsService;
import org.vtop.CourseRegistration.service.StudentLoginDetailsService;
import org.vtop.CourseRegistration.service.UserDetailsService;

@Controller
public class CourseRegistrationLoginController 
{	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private StudentLoginDetailsService studentLoginDetailsService;
	
	@Autowired
	private CourseRegistrationCommonFunction courseRegCommonFn;
	
	@Autowired
	private SemesterDetailsService semesterDetailsService;
	
	@Autowired private RegistrationLogService registrationLogService;
	
	@Autowired
	private CourseRegistrationService courseRegistrationService;

	private static final String RegErrorMethod = "WSENDFEEDBACK201920";
	private static final String WCLASSGROUPID = "ALL";
	
	@PostMapping("processStudentLogin")
	public String processStudentLogin(String registerNo,String password,String captchaString,Model model,HttpSession session,
										HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, ParseException 
	{	
		String[] classGroupId = { WCLASSGROUPID, "UGF", "PGF","ALL02"};
		int studyStartYear = 0;
		//int maxCredit = 27, checkFlag10=2, checkFlag11=2, studyModeFlag = 2, curriculumYear = 0, checkGraduateYear = 2018;
		Integer updateStatus = 0;		
		Integer testStatus = 1; // 1- Production, 2 - Testing
		
		String urlPage = "", semesterSubId = "", msg = "", sessioncaptchaString = "", infoMsg = "";
		String ipAddress = request.getRemoteAddr();		
		//String registrationMethod = "GEN";	
		
		System.out.println("classGroupId"+classGroupId);
				
		int checkFlag=2, checkFlag2=2, checkFlag3=2, checkFlag4=2, checkFlag5=2;
		int checkFlag6=2, checkFlag7=2, checkFlag8=2, checkFlag9=2;				
		int lockStatus = 2, validateLogin = 2, eduStatusFlag = 2, 
				activeStatus = 2, allowStatus = 2;
		
		Integer programDuration = 0, costCentreId = 0;
		String programGroupCode = "";
		Date studyStartDate = new Date();		
		Integer groupId = 0, specId = 0;
		String eduStatus = "", studentName = "", specCode ="", specDesc = "";
		String currentDateTimeStr = "";
		//String courseEligible = "", CGPAEligible = "", oldRegNo = "",  studMobileNo = "", studEMailId = "";
		//Float version = 0f;
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		Date startDate = format.parse("20-DEC-2021");
		Date endDate  = format.parse("24-DEC-2021");
		/*	Long startTime = 90000L;
			Long startTime = 180000L;
			Long endTime = 240000L;	
		*/	

		String startTime = "08:00:00", endTime = "24:00:00";
		
		/*String[] egbProgram = {};
		String[] courseSystem = new String[2];
		List<Integer> egbProgramInt = new ArrayList<Integer>();
		List<String> registerNumberList = new ArrayList<String>();
		String[] registerNumberArray = new String[2];*/
		
		Integer semesterId = 0, regCourseCount = 0;
		Date currentDateTime = new Date();		
		int studentGraduateYear = 0;
		Long studentId = 0L;
		//Integer regCredit = 0, wlCount = 0;
		
		
		try
		{
			StudentsLoginDetailsModel studentsLoginDetailsModel = new StudentsLoginDetailsModel();
			//UserDetailModel userDetailsModel = new UserDetailModel();
			SemesterDetailsModel semesterDetailsModel = new SemesterDetailsModel();
			/*ProgrammeSpecializationCurriculumCreditModel prgmSpeclModel = new ProgrammeSpecializationCurriculumCreditModel();
			CourseEligibleModel courseEligibleModel = new CourseEligibleModel();
			StudentCreditTransferModel studentCreditTransferModel = new StudentCreditTransferModel();			
			CurriculumProgramModelPK curriculumProgramPK = new CurriculumProgramModelPK();	
			CurriculumProgramModel curriculumProgramModel = new CurriculumProgramModel();
			List<Object[]> courseCostCentre = new ArrayList<Object[]>();*/
			
			//Validate the Register No. & Password
			if ((registerNo == null) || (registerNo.equals("")) || (password == null) || (password.equals(""))) 
			{
				msg = "Enter Reg.No / Password";			
			}		
			else
			{
				registerNo = registerNo.trim();
				registerNo = registerNo.toUpperCase();
				checkFlag = 1;
			}
			
			//Checking whether the Register No. is existed or not
			if (checkFlag == 1)
			{
				if ((userDetailsService.isExist(registerNo)) && (studentLoginDetailsService.isExist(registerNo)))
				{
					//userDetailsModel = userDetailsService.getOne(registerNo);
					studentsLoginDetailsModel = studentLoginDetailsService.getOne(registerNo);		
					
					lockStatus = studentsLoginDetailsModel.getLockStatus();					
					programDuration = studentsLoginDetailsModel.getStudentBaseModel().getProgrammeSpecializationModel().getProgrammeGroupModel().getProgrammeDuration();
					costCentreId = studentsLoginDetailsModel.getCostCentre();
					programGroupCode = studentsLoginDetailsModel.getStudentBaseModel().getProgrammeSpecializationModel().getProgrammeGroupModel().getCode();
					studyStartDate = studentsLoginDetailsModel.getStudyStartDate();					
					java.util.Calendar cal = java.util.Calendar.getInstance();
					cal.setTime(studyStartDate);
					studyStartYear = cal.get(java.util.Calendar.YEAR);
					groupId =  studentsLoginDetailsModel.getStudentBaseModel().getProgrammeSpecializationModel().getProgrammeGroupModel().getGroupId();
					eduStatus = studentsLoginDetailsModel.getEduStatus();
					studentName = studentsLoginDetailsModel.getStudentBaseModel().getStudentName();
					specCode = studentsLoginDetailsModel.getStudentBaseModel().getProgrammeSpecializationModel().getCode();
					specDesc = studentsLoginDetailsModel.getStudentBaseModel().getProgrammeSpecializationModel().getDescription();
					specId = studentsLoginDetailsModel.getStudentBaseModel().getProgrammeSpecializationModel().getSpecializationId();
					//prgmSpeclModel = programmeSpecializationCurriculumCreditService.getMaxVerDetailBySpecIdAndAdmYear(specId,studyStartYear);
					//studMobileNo = userDetailsModel.getMobile().trim();
					//studEMailId = userDetailsModel.getEmail().trim();
					
					studentGraduateYear = studyStartYear + programDuration;
					studentId = Long.parseLong(studyStartYear +""+ specId +""+ registerNo.substring(5, registerNo.length()));
					
					//For getting Captcha String in session attribute					
					sessioncaptchaString = (String) session.getAttribute("CAPTCHA");
					
					//Semester Sub Id Assignment
					if (programGroupCode.equals("MBA") || programGroupCode.equals("MBI")) 
					{
						semesterSubId = "CH2021226";
					} 
					else if (programGroupCode.equals("RP") && costCentreId == 96) // 96// VITBS
					{
						semesterSubId = "CH2021226";
					} 
					else 
					{
						semesterSubId = "CH2021221";
					}
					
					checkFlag2 = 1;
				}
				else
				{
					msg = "Invalid Register No. or Password.";
				}
			}
			
			//Checking whether the password is valid or not
			if (checkFlag2 == 1)
			{
				validateLogin = userDetailsService.UserLoginValidation(registerNo, password, testStatus);				
				if (validateLogin == 1)
				{
					if (sessioncaptchaString!=null)
					{
						if (testStatus == 2)
						{
							checkFlag3 = 1;
						}
						else if ((captchaString.equals(sessioncaptchaString)) && (captchaString.length()==6))
						{
							checkFlag3 = 1;
						}
						else
						{							
							msg = "Invalid Captcha Code";
						}
					}
					else
					{
						courseRegCommonFn.callCaptcha(request,response,session,model);
						msg = "Invalid Details.";						
						urlPage = "StudentLogin";
					}
				}
				else
				{
					msg = "Invalid Register No. or Password.";
				}
			}
			
			//Checking Register No. Account status
			if (checkFlag3 == 1)
			{
				checkFlag4 = 1;
				if (lockStatus == 0) 
				{
					checkFlag4 = 1;
				}
				else
				{
					msg = "Your Account is Locked.";
				}
			}
			
			//Checking Register No. Education status
			if (checkFlag4 == 1)
			{
				eduStatusFlag = studentLoginDetailsService.educationStatus(eduStatus);
				if (eduStatusFlag == 1) 
				{
					checkFlag5 = 1;
				}
				else
				{
					msg = "Your are not eligible for Course Feedback.";
				}
			}
						
			//Checking the Student Admission Year
			if (checkFlag5 == 1)
			{
				/*if ((!programGroupCode.equals("MBA")) && (!programGroupCode.equals("MBI")) && (studyStartYear <= 2018)) 
				{*/
					checkFlag6 = 1;
				/*}
				else
				{
					msg = "You are not Allowed to Login.";
				}*/
			}
					
			//Checking the Registered Courses related to feedback
			if (checkFlag6 == 1)
			{
				regCourseCount = courseRegistrationService.getRegisteredFeedbackClassCountByRegisterNumberAndClassGroup(semesterSubId, 
									registerNo, classGroupId);
				
				if ((regCourseCount == 0) && programGroupCode.equals("RP") && costCentreId == 96) // 96// VITBS
				{
					regCourseCount = courseRegistrationService.getRegisteredFeedbackClassCountByRegisterNumberAndClassGroup(
										"CH2021221", registerNo, classGroupId);
					if (regCourseCount >= 1)
					{
						semesterSubId = "CH2021221";
					}
				} 
				//if ((regCourseCount != null) && (regCourseCount >= 1))
				
				if (regCourseCount >= 1)
				{
					checkFlag7 = 1;
				}
				else
				{
					msg = "You did not register any of the course(s) to give feedback.";
				}
			}
			
			//Checking the Registration Date & Time
			if (checkFlag7 == 1)
			{
				//System.out.println("startDate is --> " + startDate);
				String returnVal = courseRegCommonFn.AddorDropDateTimeCheck(startDate, endDate, startTime, endTime, registerNo, updateStatus, ipAddress);
				String[] statusMsg = returnVal.split("/");
				allowStatus = Integer.parseInt(statusMsg[0]);
				infoMsg = statusMsg[1];							
				
				if (allowStatus == 1)
				{
					checkFlag8 = 1;
				}
				else
				{
					msg = infoMsg;
				}
			}			
			
			//Checking whether the Student is already login or not. 
			if (checkFlag8 == 1)
			{					
				activeStatus = courseRegCommonFn.ActivePresentDateTimeCheck(registerNo);				
				if (activeStatus == 1) 
				{
					checkFlag9 = 1;
				}
				else
				{
					msg = "You have already logged in (or) not properly logged out.  Try again after 5 minutes.";
				}
			}
			
			System.out.println("checkFlag: "+ checkFlag +" | checkFlag2: "+ checkFlag2 +" | checkFlag3: "+ checkFlag3 
					+" | checkFlag4: "+ checkFlag4 +" | checkFlag5: "+ checkFlag5 +" | checkFlag6: "+ checkFlag6 
					+" | checkFlag7: "+ checkFlag7 +" | checkFlag8: "+ checkFlag8 +" | checkFlag9: "+ checkFlag9);
			
			if ((checkFlag == 1) && (checkFlag2 == 1) && (checkFlag3 == 1) && (checkFlag4 == 1) && 
					(checkFlag5 == 1) && (checkFlag6 == 1) && (checkFlag7 == 1) && (checkFlag8 == 1) && 
					(checkFlag9 == 1))
			{				
				String studentDetails = registerNo +" - "+ studentName +" - "+ specCode +" - "+ specDesc +" - "+ programGroupCode;
								
				//Semester Sub Id Details
				if (semesterDetailsService.isExist(semesterSubId))
				{
					semesterDetailsModel = semesterDetailsService.getOne(semesterSubId);
					semesterId = semesterDetailsModel.getSemesterId();						
				}
																
				/*	Fixing the maximum credit	*/
				/*if (programGroupCode.equals("MBA") || programGroupCode.equals("MBI") || programGroupCode.equals("MIB")) 
				{
					maxCredit = 18;
				}
				else if (studentGraduateYear <= checkGraduateYear)
				{
					maxCredit = 30;
				}*/
				
				if (activeStatus == 1) 
				{
					Cookie cookie = new Cookie("RegisterNumber", registerNo);
					cookie.setMaxAge(-1);
					response.addCookie(cookie);					
					
					if (registrationLogService.isExist(registerNo)) 
					{
						registrationLogService.UpdateLoginTimeStamp(ipAddress, registerNo);		
					} 
					else 
					{
						RegistrationLogModel registrationLogModel = new RegistrationLogModel();
						registrationLogModel.setRegNo(registerNo);
						registrationLogModel.setLogstatus(1);
						registrationLogModel.setLoginTimestamp(new Date());
						registrationLogModel.setActiveTimestamp(new Date());
						registrationLogModel.setLoginIpaddress(ipAddress);
						registrationLogService.saveOne(registrationLogModel);
					}						
				}
				
				//Initiate Assignment to load the page
				currentDateTimeStr = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").format(currentDateTime);					
				
				//Session assignment
				session.setMaxInactiveInterval(3 * 60); 
												
				session.setAttribute("RegisterNumber", registerNo);
				session.setAttribute("ProgramSpecId", specId);
				session.setAttribute("ProgramSpecCode", specCode);
				session.setAttribute("ProgramGroupId", groupId);
				session.setAttribute("ProgramGroupCode", programGroupCode);
				
				session.setAttribute("testStatus", testStatus);				
				session.setAttribute("StudyStartYear", studyStartYear);
				session.setAttribute("StudentGraduateYear", studentGraduateYear);
				session.setAttribute("startDate", startDate);
				session.setAttribute("endDate", endDate);
				session.setAttribute("startTime", startTime);
				session.setAttribute("endTime", endTime);				
								
				session.setAttribute("SemesterSubId", semesterSubId);
				session.setAttribute("SemesterId", semesterId);
				session.setAttribute("studentDetails", studentDetails);
				session.setAttribute("studentId", studentId);
				
				//Model Assignment											
				model.addAttribute("CurrentDateTime", currentDateTimeStr);
				model.addAttribute("studentDetails", studentDetails);
								
				urlPage = "mainpages/MainPage";
			}
			else
			{
				courseRegCommonFn.callCaptcha(request,response,session,model);
				urlPage = "StudentLogin";				
			}			
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			msg = "Invalid Details.";
			registrationLogService.addErrorLog(e.toString(), RegErrorMethod+"CourseRegistrationLoginController", 
					"processStudentLogin", registerNo, request.getRemoteAddr());
			model.addAttribute("info", msg);
			courseRegCommonFn.callCaptcha(request,response,session,model);
			urlPage = "StudentLogin";
			return urlPage;
		}
		
		model.addAttribute("info", msg);
		return urlPage;		
	}	
}
