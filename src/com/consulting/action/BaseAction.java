/**
 * 
 */
package com.consulting.action;

/**
 * @author SK
 * 
 */
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport implements SessionAware,
	RequestAware {
 
    private static final long serialVersionUID = 1L;

    private Map session;

    protected Logger log = Logger.getLogger(this.getClass());

    public String menu = null;

    public abstract String execute();

    public abstract String edit();

    public abstract String update();

    public abstract String delete();

    public abstract String add();

    public abstract String save();

    public abstract String search();
    
     

   public void setSession(Map session) {
	this.session = session;
    }

    public Map getSession() {
	return session;
    } 

    public String getMenu() {
	return menu;
    }

    public void setMenu(String menu) {
	this.menu = menu;
    }

}