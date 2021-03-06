package org.vtop.CourseRegistration.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.vtop.CourseRegistration.model.RegistrationLogModel;
import org.vtop.CourseRegistration.repository.CourseRegistrationWithdrawRepository;
import org.vtop.CourseRegistration.repository.RegistrationLogRepository;
import org.vtop.CourseRegistration.repository.WishlistRegistrationRepository;

@Service
public class CourseRegistrationCommonFunction {

	private static final Logger logger = LogManager.getLogger(CourseRegistrationCommonFunction.class);
	//private static final String CAMPUSCODE = "VLR";
	//Previous Semester checking purpose => Fall Sem 2017-18 & Tri Sem I/IV 2017-18
	//private static final String[] previousSemester = {"VL2017181","VL2017182"};

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

	@SuppressWarnings("unused")
	@Autowired
	private StudentHistoryService studentHistoryService;

	@Autowired
	AdditionalLearningDetailsService additionalLearningDetailsService;

	@Autowired
	AdditionalLearningCourseCatalogService additionalLearningCourseCatalogService;

	@Autowired
	CourseEquivalanceRegService courseEquivalanceRegService;

	@Autowired
	ProjectRegistrationService projectRegistrationService;
	
	@Autowired
	CourseEquivalancesService courseEquivalancesService;

	@Autowired
	CampusAPI campusAPI;

	@Autowired
	RegistrationScheduleService registrationScheduleService;

	@Autowired
	CompulsoryCourseConditionDetailService compulsoryCourseConditionDetailService;

	@Autowired
	SemesterDetailsService semesterDetailsService;

	@Autowired
	RegistrationLogService registrationLogService;
	
	@Autowired private RegistrationLogRepository registrationLogRepository;

	@Autowired
	CapStoneProjectConditionDetailService capStoneProjectConditionDetailService;

	@Autowired
	StudentCurrentCgpaService studentCurrentCgpaService;
	
	@Autowired
	public CourseRegistrationWaitingMoveService courseRegistrationWaitingMoveService;
	
	@Autowired
	CourseRegistrationWithdrawRepository courseRegistrationWithdrawRepository;
	
	@Autowired
	WishlistRegistrationRepository wishlistRegistrationRepository;
	
	@Autowired
	BridgeCourseConditionDetailService bridgeCourseConditionDetailService;
	
	
	//For checking Date & Time
	public int ActivePresentDateTimeCheck(String registerNo) {

		RegistrationLogModel registrationLogModel = new RegistrationLogModel();
		Integer logStatus = 0;
		String activeDateTime = null;
		String presentDateTime = null;
		int activeStatus = 1;

		try {
			
			   if (registrationLogService.isExist(registerNo)) {
	
					registrationLogModel = registrationLogService.getOne(registerNo);
					logStatus = registrationLogModel.getLogstatus();
	
					if (registrationLogModel.getActiveTimestamp() != null) {
						activeDateTime = registrationLogModel.getActiveTimestamp();
					} else {
						activeDateTime = "01-Jan-2017 01:00:00";
					}
				}
			   	//System.out.println("ActiveDate Time " + activeDateTime);
	
				if (logStatus == 1) {
	
					presentDateTime = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date());
	
					// System.out.println("Present Date Time " + presentDateTime +
					// "Active Date Time " + activeDateTime);
	
					String[] activeDateTimeArr = activeDateTime.split(" ");
					long activeTime = Long.parseLong(activeDateTimeArr[1].replace(":", ""));
	
					DateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
				
					Date activeDate = null;
	
					try {
	
						activeDate = format.parse(activeDateTimeArr[0]);
						// System.out.println("Active Date" + activeDate + "Active
						// Time " + activeTime);
	
					} catch (ParseException e) {
						e.printStackTrace();
					}
	
					// Present Date time Stamp
					String[] presentDateTimeArr = presentDateTime.split(" ");
					//System.out.println("presentDateTime" +presentDateTime );
					long presentTime = Long.parseLong(presentDateTimeArr[1].replace(":", ""));
					Date presentDate = null;
	
					try {
						presentDate = format.parse(presentDateTimeArr[0]);
						// System.out.println("Present Date" + presentDate +
						// "Present Time " + presentTime);
					} catch (ParseException e) {
						e.printStackTrace();
					}
	
					long timediff = presentTime - activeTime;
					
					
				/*	logger.trace("ActiveDate Time" + activeDateTime);
					logger.trace("presentTime " + presentTime);					
					logger.trace("activeTime " + activeTime);
					logger.trace("timediff " + timediff);
					logger.trace("presentDate "+ presentDate);
					logger.trace("activeDate "+ activeDate);*/
	
					if (presentDate.equals(activeDate) && (timediff < 500)) {
						activeStatus = 2;
						logger.trace(
								"You have already logged in (or) not properly logged out.  Try again after 5 minutes.");
					}
		}
			
		} catch (Exception ex) {
			logger.catching(ex);
		}

		return activeStatus;
	}

	public int RegistrationTimeCheck(Date regDate, String regFromTime, String regToTime, int updateStatus, String regNo,
			String ipAddr, Integer testStatus) 
	{

		int allowStatus = 0;
		//testStatus = 1;

		if (testStatus == 2) {

			allowStatus = 1;

		} else {

			if (updateStatus == 1) {
				try {
					if (registrationLogService.isExist(regNo)) {
						registrationLogService.UpdateLoginTimeStamp(ipAddr, regNo);
					}
				} catch (Exception ex) {
					logger.catching(ex);
				}
			}
			SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
			Date curDateTime = new Date();
			String presentDateTime = df.format(curDateTime);
			String presentDateTimeArr[] = presentDateTime.split(" ");
			String presentDate = presentDateTimeArr[0];
			String presentTime = presentDateTimeArr[1];

			Date presentDate1 = null;
			try {
				presentDate1 = new SimpleDateFormat("dd-MMM-yyyy").parse(presentDate);				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			long regFromTimeVal = Long.parseLong(regFromTime.replace(":", ""));
			long regToTimeVal = Long.parseLong(regToTime.replace(":", ""));
			long presentTimeVal = Long.parseLong(presentTime.replace(":", ""));

			/*logger.trace(regDate + "/  " + presentDate1 + "/  " + regFromTime + "/  " + regToTime);*/
			if ((presentDate1.equals(regDate)) && (presentTimeVal >= regFromTimeVal)
					&& (presentTimeVal <= regToTimeVal)) {
				allowStatus = 1;
			} else {
				allowStatus = 2;
			}

		}

		return allowStatus;
	}	
	
	
	
	public String AddorDropDateTimeCheck(Date startDate, Date endDate, String startTime, String endTime,
			String registerNo, int updateStatus, String ipAddr) {
		
		/*String presentDateTime = null;		
		String returnVal = null;
		DateFormat format = new SimpleDateFormat("dd-MMM-yyyy");

		try {
			
				if (updateStatus == 1) {
					try {
						if (registrationLogService.isExist(registerNo)) {
							registrationLogService.UpdateLoginTimeStamp(ipAddr, registerNo);
						}
					} catch (Exception ex) {
						logger.catching(ex);
					}
				}
				presentDateTime = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date());					
				String[] presentDateTimeArr = presentDateTime.split(" ");
				Long presentTime = Long.parseLong(presentDateTimeArr[1].replace(":", ""));
				Date presentDate = null;
				int chkFlg = 2;
				String msg = null;
			
	
				try {
					presentDate = format.parse(presentDateTimeArr[0]);
					presentTime = presentDateTimeArr[1];
					presentTimeVal = Long.parseLong(presentTime.replace(":", ""));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				logger.trace("Start Date Time" + startDate + " " + startTime);
				logger.trace("End Date Time" + endDate + " " + endTime);
				logger.trace("Present Date Time" + presentDate + " " + presentTime);
				
				if (presentDate.equals(startDate)){					
					if (presentTime >= startTime){
						chkFlg = 1;
					}else{
						msg = "Course Feedback is starts at 09:00:00 Hrs";
					}					
				}else if (presentDate.after(startDate)){
					if (presentDate.before(endDate)){
						chkFlg = 1;
					}else if (presentDate.equals(endDate) && (presentTime >= 0)  && (presentTime <= endTime)){
						chkFlg = 1;
					}else{
						msg = "Course Feedback is Closed...!";
					}
				}
				else{
					msg = "Course Feedback is opened on " + format.format(startDate) + " at  09:00:00 Hrs";
				}
				returnVal = chkFlg + "/" + msg;*/
				
				/*******************************/
			
		int timeCheckFlag = 2;
		String timeCheckMessage = "NONE", presentDateTime = "", presentTime = "";
		Long startTimeVal = 0L, endTimeVal = 0L, presentTimeVal = 0L;
		
		Date presentDate = null;
		DateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		
		try
		{			
			startTimeVal = Long.parseLong((startTime.toString()).replace(":", ""));
			endTimeVal = Long.parseLong((endTime.toString()).replace(":", ""));
			
			presentDateTime = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date());					
			String[] presentDateTimeArr = presentDateTime.split(" ");
			presentDate = format.parse(presentDateTimeArr[0]);
			presentTime = presentDateTimeArr[1];
			presentTimeVal = Long.parseLong(presentTime.replace(":", ""));
									
			/*System.out.println("StartDate: "+ startDate +" | StartTime: "+ startTime 
										+" | Start Time Value: " + startTimeVal);
			System.out.println("EndDate: "+ endDate +" | EndTime: "+ endTime +" | EndTimeValue: " + endTimeVal);
			System.out.println("PresentDate: "+ presentDate +" | PresentTime: "+ presentTime
					 				+" | PresentTimeValue: " + presentTimeVal);*/
					
			if ((presentDate.compareTo(startDate) >= 0) && (presentDate.compareTo(endDate) <= 0))
			{				
				if ((startDate.compareTo(endDate) == 0) && (presentDate.compareTo(startDate) == 0) 
						&& (presentTimeVal < startTimeVal))
				{
					timeCheckMessage = "FeedBack starts at "+ startTime +" Hrs.";
				}
				else if ((startDate.compareTo(endDate) == 0) && (presentDate.compareTo(startDate) == 0) 
							&& (presentTimeVal >= startTimeVal) && (presentTimeVal <= endTimeVal))
				{
					timeCheckMessage = "Success.";
					timeCheckFlag = 1;
				}
				else if ((startDate.compareTo(endDate) == 0) && (presentDate.compareTo(startDate) == 0) 
							&& (presentTimeVal > endTimeVal))
				{
					timeCheckMessage = "FeedBack closed.";
				}
				else if ((startDate.compareTo(endDate) != 0) && (presentDate.compareTo(startDate) == 0) 
							&& (presentTimeVal < startTimeVal))
				{
					timeCheckMessage = "FeedBack starts at "+ startTime +" Hrs.";
				}
				else if ((startDate.compareTo(endDate) != 0) && (presentDate.compareTo(startDate) == 0) 
							&& (presentTimeVal >= startTimeVal))
				{
					timeCheckMessage = "Success.";
					timeCheckFlag = 1;
				}
				else if ((startDate.compareTo(endDate) != 0) && (presentDate.compareTo(startDate) > 0) 
							&& (presentDate.compareTo(endDate) < 0))
				{
					timeCheckMessage = "Success.";
					timeCheckFlag = 1;
				}
				else if ((startDate.compareTo(endDate) != 0) && (presentDate.compareTo(endDate) == 0) 
							&& (presentTimeVal <= endTimeVal))
				{
					timeCheckMessage = "Success.";
					timeCheckFlag = 1;
				}
				else
				{
					timeCheckMessage = "FeedBack closed.";
				}
			}
			else
			{
				if (presentDate.compareTo(endDate) > 0)
				{
					timeCheckMessage = "FeedBack closed.";
				}
				else
				{
					timeCheckMessage = "FeedBack will start on "+ new SimpleDateFormat("dd-MMM-yyyy").format(startDate) 
											+" at "+ startTime +" Hrs.";
				}
			}
			
			if ((timeCheckFlag == 1) && (updateStatus == 1))
			{
				registrationLogRepository.UpdateActiveTimeStamp(registerNo);
			}
		}
		catch (Exception ex)
		{
			logger.catching(ex);
		}

		return timeCheckFlag +"/"+ timeCheckMessage;
	}
	
	public final void callCaptcha(HttpServletRequest request,HttpServletResponse response, HttpSession session, Model model) throws ServletException, IOException
	{
		Sdc_common_functions sdf = new Sdc_common_functions();
		sdf.doGet(request, response);
		String res = (String) session.getAttribute("ENCDATA");
		model.addAttribute("res1", res);
	}
	
	/*public String getRandomOtp(Integer keyLength)
	{
		String sDefaultChars = "123456789abcdefghjkmnpqrxyzABCDEFGHJKMNPQRXYZ";
		Integer iKeyLength =keyLength;
		Integer iDefaultCharactersLength = sDefaultChars.length();
		String sMyKey="";
		for(int iCounter=1;iCounter<=iKeyLength;iCounter++)
		{
			Integer iPickedChar=(int) ((iDefaultCharactersLength*Math.random())+1);
			if(iPickedChar>=sDefaultChars.length())
				sMyKey = sMyKey+(sDefaultChars.substring(sDefaultChars.length()-1));
			else
				sMyKey = sMyKey+(sDefaultChars.substring(iPickedChar,iPickedChar+1));
		}
		return sMyKey;
	}*/
}
