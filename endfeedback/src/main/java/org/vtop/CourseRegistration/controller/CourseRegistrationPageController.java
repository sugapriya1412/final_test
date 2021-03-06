package org.vtop.CourseRegistration.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vtop.CourseRegistration.NetAssist;
import org.vtop.CourseRegistration.service.CourseRegistrationCommonFunction;
import org.vtop.CourseRegistration.service.RegistrationLogService;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;


@Controller
public class CourseRegistrationPageController 
{
	
	
	@Autowired
	private RegistrationLogService registrationLogService;	
	
	@Autowired
	private CourseRegistrationCommonFunction courseRegCommonFn;
	
	private static final String RegErrorMethod = "WSENDFEEDBACK201920";

	@RequestMapping(value = "SessionTimedOut", method = { RequestMethod.POST, RequestMethod.GET })
	public String sessionError(@CookieValue(value = "RegisterNumber") String registerNumber, Model model,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException 
	{
		String page = "";		
		Cookie[] cookies = request.getCookies();		
		
		if (cookies!=null)
		{
			for (Cookie cookie : cookies) 
			{
				if(cookie.getName().equals(registerNumber))
				{
					if (registrationLogService.isExist(registerNumber)) 
					{
						registrationLogService.UpdateLogoutTimeStamp(request.getRemoteAddr(), registerNumber);
						
						cookie = new Cookie("RegisterNumber", null);
						cookie.setMaxAge(0);
						response.addCookie(cookie);
						request.getSession().invalidate();				
					}
				}				
				
				model.addAttribute("message", "Session Expired");
				model.addAttribute("error", "Try Logout and Log-in");
				model.addAttribute("errno", 3);
				page = "CustomErrorPage";
			}			
		}
		else
		{
			courseRegCommonFn.callCaptcha(request,response,session,model);			
			model.addAttribute("flag", 2);			
			page = "redirectpage";							
		}	
		
		return page;
	}

	@RequestMapping(value= "/", method = {RequestMethod.GET, RequestMethod.POST})
	public String home(HttpServletRequest httpServletRequest, Model model, HttpSession session, HttpServletRequest request,HttpServletResponse response)	throws ServletException, IOException 
	{
		String userAgent = httpServletRequest.getHeader("user-agent");
		UserAgent ua = UserAgent.parseUserAgentString(userAgent);
		Version browserVersion = ua.getBrowserVersion();
		String browserName = ua.getBrowser().toString();
		String userSessionId = null;
		
		session.setAttribute("baseURL", NetAssist.getBaseURL(httpServletRequest));		

		int majVersion = Integer.parseInt(browserVersion.getMajorVersion());
		
		if (browserName.equalsIgnoreCase("Firefox") && majVersion < 50) 
		{
			model.addAttribute("message", "Outdated Web Browser Error!");
			model.addAttribute("error", "Kindly Update Your Browser. We recommend to use Mozilla Firefox or Google Chorme for better experience.");
		} 
		else if (browserName.equalsIgnoreCase("Chrome") && majVersion < 50) 
		{
			model.addAttribute("message", "Outdated Web Browser Error!");
			model.addAttribute("error", "Kindly Update Your Browser. We recommend to use Mozilla Firefox or Google Chorme for better experience.");
			return "ErrorPage";
		}
		else if (browserName.equalsIgnoreCase("EDGE14") && majVersion == 14) 
		{
			model.addAttribute("message", "Outdated Web Browser Error!");
			model.addAttribute("error", "Kindly Update Your Borwser. We recommend to use Mozilla Firefox or Google Chorme for better experience.");
			return "ErrorPage";
		} 
		else if (browserName.equalsIgnoreCase("OPERA") && majVersion < 40) 
		{
			model.addAttribute("message", "Outdated Web Browser Error!");
			model.addAttribute("error", "Kindly Update Your Borwser. We recommend to use Mozilla Firefox or Google Chorme for better experience.");
			return "ErrorPage";
		} 
		else if (browserName.contains("IE")) 
		{
			model.addAttribute("message", "Outdated Web Browser Error!");
			model.addAttribute("error", "Kindly Update Your Borwser. We recommend to use Mozilla Firefox or Google Chorme for better experience.");
			return "ErrorPage";
		}

		userSessionId = (String) session.getAttribute("userSessionId");

		if (userSessionId == null) 
		{
			session.setAttribute("userSessionId", session.getId());
		}
		
		//return "InstructionPage";
		
		courseRegCommonFn.callCaptcha(request,response,session,model);
		session.setAttribute("CAPTCHA",session.getAttribute("CAPTCHA"));
		return "StudentLogin";
	}

	@PostMapping("viewStudentLogin")
	public String viewStudentLogin(Model model, HttpServletRequest request, HttpSession session, HttpServletResponse response) throws ServletException, IOException 
	{
		session.setAttribute("baseURL", NetAssist.getBaseURL(request));
		String userSessionId = (String) session.getAttribute("userSessionId");

		if (userSessionId == null) 
		{
			session.setAttribute("userSessionId", session.getId());
		}
		courseRegCommonFn.callCaptcha(request,response,session,model);
		session.setAttribute("CAPTCHA",session.getAttribute("CAPTCHA"));
		return "StudentLogin";
	}
	
	@PostMapping("viewStudentLogin1")
	public String viewStudentLogin1(Model model, HttpServletRequest request, HttpSession session, HttpServletResponse response) throws ServletException, IOException 
	{
		session.setAttribute("baseURL", NetAssist.getBaseURL(request));
		String userSessionId = (String) session.getAttribute("userSessionId");

		if (userSessionId == null) 
		{
			session.setAttribute("userSessionId", session.getId());
		}
		
		courseRegCommonFn.callCaptcha(request,response,session,model);
		session.setAttribute("CAPTCHA",session.getAttribute("CAPTCHA"));
		return "StudentLogin::test";
	}	

	@RequestMapping(value = "ServerLimit", method = { RequestMethod.POST, RequestMethod.GET })
	public String serverLimit(Model model, HttpSession session, HttpServletRequest request) throws ServletException 
	{
		String page = "CustomErrorPage";
		/*String baseURL = NetAssist.getBaseURL(request);
		logger.trace("BaseUrl - " + baseURL);

		if (baseURL.toLowerCase().contains("vtop8")) 
		{
			model.addAttribute("Server1", "https://vtop9.vit.ac.in/CourseRegistration");
			model.addAttribute("Server2", "https://vtop10.vit.ac.in/CourseRegistration");
		} 
		else if (baseURL.toLowerCase().contains("vtop9")) 
		{
			model.addAttribute("Server1", "https://vtop10.vit.ac.in/CourseRegistration");
			model.addAttribute("Server2", "https://vtop8.vit.ac.in:/CourseRegistration");
		} 
		else if (baseURL.toLowerCase().contains("vtop10")) 
		{
			model.addAttribute("Server1", "https://vtop8.vit.ac.in/CourseRegistration");
			model.addAttribute("Server2", "https://vtop9.vit.ac.in/CourseRegistration");
		}

		request.getSession().invalidate();
		model.addAttribute("message", "");
		model.addAttribute("error", " Please Note: Try one of the following Servers <br/><br/>");
		model.addAttribute("errno", 99);*/

		return page;
	}

	@RequestMapping(value = "AlreadyLogin", method = { RequestMethod.POST, RequestMethod.GET })
	public String AlreadyLogin(Model model) throws ServletException 
	{
		String page = "CustomErrorPage";

		model.addAttribute("message", "Multi-Tab Access Error");
		model.addAttribute("error", "Multiple Tabs Access prevented !!!");
		model.addAttribute("errno", 6);
		return page;
	}
	
	@GetMapping("signOut")
	public String signOut(Model model,HttpServletRequest request) 
	{
		model.addAttribute("message", " V - TOP ");
		model.addAttribute("error", " Thank you For Using V TOP Feedback Portal .");
		model.addAttribute("errno", 3);
		request.getSession().invalidate();	
		return "CustomErrorPage";
	}
	
	@GetMapping("noscript")
	public String noscript(Model model) 
	{
		model.addAttribute("message", "JavaScript Error");
		model.addAttribute("error", "Kindly Enable JavaScript in Your Browser to Access V-TOP.");
		return "ErrorPage";
	}

	@RequestMapping(value = "processLogout", method = { RequestMethod.POST, RequestMethod.GET })
	public String doLogout(HttpSession session, HttpServletRequest request, HttpServletResponse response,Model model) throws ServletException, IOException 
	{
		String page = "", info = null;
		//String currentDateTimeStr = "";
		String registerNumber = (String) session.getAttribute("RegisterNumber");
		//int loAllowFlag = 2, totalRegCredit=0, regCredit=0, wlRegCredit=0, checkGraduateYear = 2018, maxCredit = 27;
		//Integer wlCount = 0;
		//Integer StudentGraduateYear = (Integer) session.getAttribute("StudentGraduateYear");
		//String ProgramGroupCode = (String) session.getAttribute("ProgramGroupCode");
		//String SemesterSubId = (String) session.getAttribute("SemesterSubId");
		
		try 
		{
			if ((registerNumber!=null) && (registrationLogService.isExist(registerNumber)))
			{
				info = (String) session.getAttribute("info");				
				registrationLogService.UpdateLogoutTimeStamp(request.getRemoteAddr(),registerNumber);
				model.addAttribute("flag", 4);			
				page = "redirectpage";
				/*courseRegCommonFn.callCaptcha(request,response,session,model);
				session.setAttribute("CAPTCHA",session.getAttribute("CAPTCHA"));
				page = "StudentLogin";*/
			}
			else
			{
				model.addAttribute("flag", 4);			
				page = "redirectpage";
				/*info = "Login with your Username and Password";
				courseRegCommonFn.callCaptcha(request,response,session,model);
				session.setAttribute("CAPTCHA",session.getAttribute("CAPTCHA"));
				page = "StudentLogin";*/				
			}
			
			model.addAttribute("info", info);
			Cookie cookie = new Cookie("RegisterNumber", null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			request.getSession().invalidate();
			//courseRegCommonFn.callCaptcha(request,response,session,model);
			//session.setAttribute("CAPTCHA",session.getAttribute("CAPTCHA"));
			return page;
		} 
		catch (Exception e) 
		{
			model.addAttribute("info", "Login with your Username and Password");
			courseRegCommonFn.callCaptcha(request,response,session,model);
			session.setAttribute("CAPTCHA",session.getAttribute("CAPTCHA"));
			registrationLogService.addErrorLog(e.toString(), RegErrorMethod+"CourseRegistrationPageController", 
					"processLogout", registerNumber, request.getRemoteAddr());
			page = "StudentLogin";
			return page;
		}	
	}
	
}