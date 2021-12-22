package com.consulting.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.consulting.common.vo.NameValue;
import com.consulting.dao.UserManagerDBdao; 
import com.consulting.vo.User;

public class UserAction extends BaseAction implements ServletRequestAware {

	private List<NameValue> locationList = new ArrayList<NameValue>();
	private static Pattern usrNamePtrn = Pattern.compile("^([a-zA-Z0-9])+([\\s\\w@._-]{2,30})+$");
	private static Pattern usrNamePtrn2 = Pattern.compile("^([a-zA-Z0-9])+([\\s\\w@._-]{1,30})+$");

	public static boolean validateUserName(String userName) {

		Matcher mtch = usrNamePtrn.matcher(userName);
		if (mtch.matches()) {
			return true;
		}
		return false;
	}

	public static boolean validateUserName2(String userName) {

		Matcher mtch = usrNamePtrn2.matcher(userName);
		if (mtch.matches()) {
			return true;
		}
		return false;
	}

	public List<NameValue> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<NameValue> locationList) {
		this.locationList = locationList;
	}

	private HttpServletRequest servletRequest;
	private String userName;
	private String userId;
	private String mobNo;
	private String email;
	private String designation;
	private String location;
	private String status;
    private String role;
    
    
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	@Override
	public void setRequest(Map arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

	}

	@Override
	public String execute() {
		servletRequest.setAttribute("url", "adduser");
		User user = (User) getSession().get("user_details");
		if (user == null) {
			addActionMessage("Not Authorize to view this page.");
			return ERROR;
		}
		if(!servletRequest.getMethod().equalsIgnoreCase("POST"))
		{
		   ((SessionMap) this.getSession()).invalidate();
			return ERROR;
		}
		((SessionMap) this.getSession()).invalidate();
		this.getSession().put("user_details", user);  
		if (user.getRole().equalsIgnoreCase("Admin")) {
			UserManagerDBdao us = new UserManagerDBdao();
			if (us.chekUser(userId)) {
				addActionMessage("User ID already exists.  " + "<a href=add!adduser.action>Add More users</a>");
				return "adduser";
			}
			if (us.chekUsercount() >= 40) {
				addActionMessage("You can't add more than 40 users .");
				return "adduser";
			} else {
				if (us.adduser(userName, userId, mobNo, email, designation, role, status)) {
					addActionMessage(
							"User Details Sucessfully Saved.  " + "<a href=add!adduser.action>Add More users</a>");
					return "saveuser";
				} else {
					addActionMessage("Error Generated....");
					return "adduser";
				}
			}
		} else {
			addActionMessage("Not Authorize to view this page.");
		}
		return "adduser";
	}

	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String search() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate() {
		servletRequest.setAttribute("url", "adduser");	 
        String emailRegex = "[a-zA-Z0-9_.]+@[a-zA-Z0-9]+.[a-zA-Z]{2,3}[.] {0,1}[a-zA-Z]+";
		String regex = "\\d{10}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mobNo);
		if (!matcher.matches()) {
			addFieldError("mobNo", "Please enter valid 10 digit mobile no");
		}
		if (!Pattern.matches(emailRegex, email.trim())) {
			addFieldError("email", "Please enter valid Email Id");
		}
		if (email.length() > 40) {
			addFieldError("email", "Please enter valid Email Id");
		}
        
		if (!validateUserName(userId.trim())) {
			addFieldError("userId", "User id should be 3 to 30 Alphanumeric characters.");
		}
		if (!validateUserName(userName.trim())) {
			addFieldError("userName", "User Name should be 3 to 30 Alphanumeric characters.");
		}
		if (!(status.trim().equals("Y") || status.trim().equals("N"))) {
			addFieldError("status", "Status should be Y or N.");
		}
		if (!validateUserName2(designation.trim())) {
			addFieldError("designation", "designation should be 2 to 30 Alphanumeric characters.");
		}
		 
	}
}
