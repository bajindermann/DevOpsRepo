package com.consulting.action;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.dispatcher.SessionMap;

 
 

public class LogOffAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public String add() {

	return null;
    }

    public String delete() {

	return null;
    }

    public String edit() {

	return null;
    }

    public String execute() {
    	 
	getSession().remove("user_details");
	getSession().clear();	
	((SessionMap) getSession()).invalidate();
	
    return SUCCESS;

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

}
