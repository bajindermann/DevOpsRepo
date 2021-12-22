package com.consulting.action.interceptor;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

 
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class Security implements Interceptor {

    private static final long serialVersionUID = 1L;

    static Logger log = Logger.getLogger(Security.class);   

    public void destroy() {
    }

    public void init() {
    }
    public String intercept(ActionInvocation invoication) throws Exception {
    	ServletActionContext.getResponse().setHeader("Cache-Control", "no-store, no-cache, must-revalidate");    	 
    	ServletActionContext.getResponse().setHeader("Pragma", "no-cache");
    	ServletActionContext.getResponse().setHeader("Expires", "0");
    	ServletActionContext.getResponse().setHeader("X-XSS-Protection","1; mode=block");
    	ServletActionContext.getResponse().setHeader("X-Frame-Options", "DENY");
    	ServletActionContext.getResponse().setHeader("X-Content-Type-Options", "nosniff");
    	ServletActionContext.getResponse().setHeader("Strict-Transport-Security","max-age=31536000; includeSubdomains");
    	ServletActionContext.getResponse().setHeader("Content-Type", "text/html");  
    	ServletActionContext.getResponse().setHeader("Content-Security-Policy-Report-Only", "default-src 'self'; script-src 'self' 'unsafe-inline'; object-src 'none'; style-src 'self' 'unsafe-inline'; img-src 'self'; media-src 'none'; frame-src 'none'; font-src 'self'; connect-src 'self'; report-uri REDACTED");
    	ServletActionContext.getResponse().setHeader("X-Content-Security-Policy-Report-Only", "default-src 'self'; script-src 'self' 'unsafe-inline'; object-src 'none'; style-src 'self' 'unsafe-inline'; img-src 'self'; media-src 'none'; frame-src 'none'; font-src 'self'; connect-src 'self'; report-uri REDACTED");    	 
        System.out.println("request served attt " + System.currentTimeMillis());
    	//log.info("Security");
    	//log.info("request served at " + System.currentTimeMillis());
    	 
    	return invoication.invoke(); 
	 
    }

}
