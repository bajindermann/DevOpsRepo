package com.consulting.action;

import com.consulting.action.BaseAction;
import com.consulting.action.LoginAction;
import com.consulting.common.CommonUtil;
import com.consulting.common.vo.NameValue;
import com.consulting.dao.CommonDBdao;
import com.consulting.dao.UserManagerDBdao;
 
import com.consulting.vo.User;
import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;

public class LoginAction extends BaseAction implements ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private static Pattern usrNamePtrn = Pattern.compile("^([a-zA-Z0-9])+([\\s\\w@._-]{2,30})+$");
	private static Pattern usrNamePtrn2 = Pattern.compile("^([a-zA-Z0-9])+([\\s\\w@._-]{1,30})+$");
	private static Pattern usrNamePtrn3=Pattern.compile("^[0-9]{1,3}$");
	
	private static final Logger log = Logger.getLogger(LoginAction.class);
	private List<NameValue> locationList = new ArrayList<NameValue>();
	private List<User> userlist = new ArrayList<User>();

	public static boolean validateUserName2(String userName) {

		Matcher mtch = usrNamePtrn2.matcher(userName);
		if (mtch.matches()) {
			return true;
		}
		return false;
	}
	public static boolean validateuserid(String uid) {

		Matcher mtch = usrNamePtrn3.matcher(uid);
		if (mtch.matches()) {
			return true;
		}
		return false;
	}


	public static boolean validateUserName(String userName) {

		Matcher mtch = usrNamePtrn.matcher(userName);
		if (mtch.matches()) {
			return true;
		}
		return false;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	private String userId;

	private String password;

	private String role;

	private String hiddenId;

	private String custType1;

	private User user;
	private User userdetails;

	public User getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(User userdetails) {
		this.userdetails = userdetails;
	}

	private HttpServletRequest servletRequest;

	public List<NameValue> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<NameValue> locationList) {
		this.locationList = locationList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@SuppressWarnings("unchecked")

	public String adduser() {
		servletRequest.setAttribute("url", "adduser");
		User user = (User) getSession().get("user_details");
		if (user == null) {
			addActionMessage("Not Authorize to view this page.");
			return ERROR;
		}
		if(!servletRequest.getMethod().equalsIgnoreCase("GET"))
		{
		   ((SessionMap) this.getSession()).invalidate();
			return ERROR;
		}
		((SessionMap) this.getSession()).invalidate();
		this.getSession().put("user_details", user);  
		System.out.print(user.getRole());
		if (user.getRole().equalsIgnoreCase("Admin")) {			 
		} else {
			addActionMessage("Not Authorize to view this page.");
		}
		return "adduser";
	}

	public String viewuser() {
		servletRequest.setAttribute("url", "viewuser");
		User user = (User) getSession().get("user_details");
		if (user == null) {
			addActionMessage("Not Authorize to view this page.");
			return ERROR;
		}
		if(!servletRequest.getMethod().equalsIgnoreCase("GET"))
		{
		   ((SessionMap) this.getSession()).invalidate();
			return ERROR;
		}
		((SessionMap) this.getSession()).invalidate();
		this.getSession().put("user_details", user);  
		if (user.getRole().equalsIgnoreCase("Admin")) {
			UserManagerDBdao ulist = new UserManagerDBdao();
			userlist = ulist.viewUser();
		} else {
			addActionMessage("Not Authorize to view this page.");
		}
		return "viewuser";
	}

	public String edituser() {		 
		servletRequest.setAttribute("url", "viewuser");
		User users = (User) getSession().get("user_details");
		if (users == null) {
			addActionMessage("Not Authorize to view this page.");
			return ERROR;
		}
		if(!servletRequest.getMethod().equalsIgnoreCase("POST"))
		{
		   ((SessionMap) this.getSession()).invalidate();
			return ERROR;
		}
		((SessionMap) this.getSession()).invalidate();
		this.getSession().put("user_details", users);  
		if (users.getRole().equalsIgnoreCase("Admin")) {	 
			UserManagerDBdao ulist = new UserManagerDBdao();
			System.out.println("userid---"+userId);
			if (!validateuserid(userId)) {
				addActionMessage("Invalid User ID");
				return "edituser";
			}
			user = ulist.editUser(Integer.parseInt(userId));
			if(user==null)
			{
				addActionMessage("No Record Found(s).");
			}
		} else {
			addActionMessage("Not Authorize to view this page.");
		}
		return "edituser";
	}

	public String updateuser() {
		System.out.println("updateuser");
		servletRequest.setAttribute("url", "viewuser");
		User users = (User) getSession().get("user_details");
		if (users == null) {
			addActionMessage("Not Authorize to view this page.");
			return ERROR;
		}
		if(!servletRequest.getMethod().equalsIgnoreCase("POST"))
		{
		   ((SessionMap) this.getSession()).invalidate();
			return ERROR;
		}
		((SessionMap) this.getSession()).invalidate();
		this.getSession().put("user_details", users);  
		if (users.getRole().equalsIgnoreCase("Admin")) {			 
			user = user;
			UserManagerDBdao ulist = new UserManagerDBdao();
			String emailRegex = "[a-zA-Z0-9_.]+@[a-zA-Z0-9]+.[a-zA-Z]{2,3}[.] {0,1}[a-zA-Z]+";
			String regex = "\\d{10}";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(user.getMobile());
			if (!matcher.matches()) {
				addFieldError("mobNo", "Please enter valid 10 digit mobile no");
				return "edituser";
			}
			if (!Pattern.matches(emailRegex, user.getEmail())) {
				addFieldError("email", "Please enter valid Email Id");
				return "edituser";
			}
			if (user.getEmail().trim().length() > 40) {
				addFieldError("email", "Please enter valid Email Id");
				return "edituser";
			}
			if (!validateUserName(user.getLoginId().trim())) {
				addFieldError("loginId", "User id should be 3 to 30 Alphanumeric characters.");
				return "edituser";
			}
			if (!validateUserName(user.getUserName().trim())) {
				addFieldError("userName", "User Name should be 3 to 30 Alphanumeric characters.");
				return "edituser";
			}
			if (!(user.getStatus().trim().equals("Y") || user.getStatus().trim().equals("N"))) {
				addFieldError("status", "Status should be Y or N.");
				return "edituser";
			}
			if (!validateUserName2(user.getDesignation().trim())) {
				addFieldError("designation", "designation should be 2 to 30 Alphanumeric characters.");
				return "edituser";
			}
			if (!validateUserName2(user.getRole().trim())) {
				addFieldError("role", "Role should be 3 to 30 Alphanumeric characters.");
				return "edituser";
			}
			if (!validateuserid(user.getUserId())) {
				addActionMessage("Invalid User ID");
				return "edituser";
			}
			if (ulist.chekUsertwo(user)) {
				addActionMessage("User Id already Exit.  " + "<a href=View!viewuser.action>View User Details</a>");
				return "edituser";
			}

			if (ulist.updateuser(user)) {
				addActionMessage(
						"User Details Updated Successfully.  " + "<a href=View!viewuser.action>View User Details</a>");
				return "updateuser";
			} else {
				addActionMessage("Error Generated.....");
				return "edituser";
			}
		} else {
			addActionMessage("Not Authorize to view this page.");
		}
		return "edituser";
	}

	public String home() {
		servletRequest.setAttribute("url", "home");
		User user = (User) getSession().get("user_details");
		if (user == null) {
			addActionMessage("Not Authorize to view this page.");
			return ERROR;
		}
		if(!servletRequest.getMethod().equalsIgnoreCase("GET"))
		{
		   ((SessionMap) this.getSession()).invalidate();
			return ERROR;
		}
		((SessionMap) this.getSession()).invalidate();
		this.getSession().put("user_details", user);   
		return "home";
	}
 
	public String loginsuccess() {	 
		User user = (User) getSession().get("user_details");
		if (user == null) {
			addActionMessage("Not Authorize to view this page.");
			return ERROR;
		}
		if(!servletRequest.getMethod().equalsIgnoreCase("GET"))
		{
			((SessionMap) this.getSession()).invalidate();
			return ERROR;
		}	
		((SessionMap) this.getSession()).invalidate();
		this.getSession().put("user_details", user);  
		return "loginsuccess";
		 
	}
public String editdetails() {	 
		User user = (User) getSession().get("user_details");
		if (user == null) {			 
			return ERROR;
		} 
		if(!servletRequest.getMethod().equalsIgnoreCase("GET"))
		{
			((SessionMap) this.getSession()).invalidate();
			return ERROR;
		}	
		if (!user.getRole().equalsIgnoreCase("Admin")) 
		{	((SessionMap) this.getSession()).invalidate();		 
			return ERROR;
		}
		((SessionMap) this.getSession()).invalidate();
			this.getSession().put("user_details", user); 
			addActionMessage(
					"User Details Updated Successfully.  " + "<a href=View!viewuser.action>View User Details</a>");
		return "updateuser";
		 
	}
public String saveuser() {		
	
		User user = (User) getSession().get("user_details");
		if (user == null) {
			addActionMessage("Not Authorize to view this page.");
			return ERROR;
		}
		if(!servletRequest.getMethod().equalsIgnoreCase("GET"))
		{
			((SessionMap) this.getSession()).invalidate();
			return ERROR;
		}		 
		if (!user.getRole().equalsIgnoreCase("Admin")) {
			((SessionMap) this.getSession()).invalidate();
			return ERROR;
		    }		 
		else {			 
			((SessionMap) this.getSession()).invalidate();
			this.getSession().put("user_details", user); 
			addActionMessage("User Details Sucessfully Saved. " +"<a href=add!adduser.action>Add More users</a>");			 
		return "saveuser";
		}
	}
	public String execute() {

		log.info("LoginAction");
		if(!servletRequest.getMethod().equalsIgnoreCase("POST"))
		{
			return ERROR;
		}
		 
		servletRequest.setAttribute("url", "home");
		String result = "input";
		if (!validateUserName(userId.trim())) {
			addActionMessage("User id should be 3 to 30 Alphanumeric characters.");
			return result;
		}

		if (password.trim() == "" || password.trim().length() <= 0) {
			addActionMessage("Please Enter Password");
			return result;
		}

		if (password.trim() == "" || password.trim().length() < 6) {
			addActionMessage("Password should be 6 to 30 characters.");
			return result;
		}

		if (password.trim() == "" || password.trim().length() > 30) {
			addActionMessage("Password should be 6 to 30 characters.");
			return result;
		}
		// Login authentication with Active Directory
        UserManagerDBdao userManagerDBdao = new UserManagerDBdao();
        try {
			user = userManagerDBdao.authenticate(getUserId().trim(),getPassword().trim());
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        ((SessionMap) this.getSession()).invalidate();
		this.getSession().put("user_details", user); // FOR THE WHOLE SESSION/////////////////////
		if (user != null) {
			System.out.println("user login"+user.getRole());
			addActionMessage("Login Successful "+user.getUserName()+"--"+user.getStatus());
			result = "loginsuccess";
		} else {
			addActionMessage("Not authorized to access the application. Please contact System Admin");
			return result;
		}

		String ipAddress = null;
		if (servletRequest.getHeader("X-Forwarded-For") == null) {
			ipAddress = servletRequest.getRemoteAddr();

		} else {
			ipAddress = servletRequest.getHeader("X-Forwarded-For");
		}
		Calendar calendar = new GregorianCalendar();
		String am_pm;
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		if (calendar.get(Calendar.AM_PM) == 0)
			am_pm = "AM";
		else
			am_pm = "PM";
		String currentTime = hour + ":" + minute + ":" + second + ":" + am_pm;
		HttpSession httpServletRequest = servletRequest.getSession();
		log.info("Session id of user is " + servletRequest.getSession().getId());
		log.info("ip Address -->" + ipAddress);
		log.info("Date of Login -->" + CommonUtil.now("dd-MM-yyyy"));
		log.info("Time of Login -->" + currentTime);
		if (user != null) {
			CommonDBdao commonDBdao = new CommonDBdao();
			if (commonDBdao.acessLogin(user.getUserId(), servletRequest.getSession().getId(),
					CommonUtil.now("dd-MM-yyyy"), ipAddress)) {
				log.info("USER ENTERD");

			}
		}
		if (user == null) {
			log.info("IP HIT----->" + ipAddress);
		}

		return result;
	}

	public String add() {

		return null;
	}

	public String delete() {

		return null;
	}

	public String edit() {

		return null;
	}

	public String save() {

		return null;
	}

	public String search() {

		return null;
	}

	public String update() {

		return null;
	}

	public void setRequest(Map arg0) {

	}

	public String getCustType1() {
		return custType1;
	}

	public void setCustType1(String custType1) {
		this.custType1 = custType1;
	}

	public String getHiddenId() {
		return hiddenId;
	}

	public void setHiddenId(String hiddenId) {
		this.hiddenId = hiddenId;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

	}

}
