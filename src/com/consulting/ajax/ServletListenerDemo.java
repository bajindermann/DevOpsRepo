package com.consulting.ajax;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.apache.log4j.Logger;
import com.consulting.common.CommonUtil;
import com.consulting.dao.CommonDBdao;
import com.consulting.vo.User;

public class ServletListenerDemo implements

HttpSessionActivationListener, HttpSessionAttributeListener,
		HttpSessionBindingListener, HttpSessionListener,ServletContextListener {

	private static final Logger log = Logger
			.getLogger(ServletListenerDemo.class);

	public void sessionDidActivate(HttpSessionEvent arg0) {
		System.out.println(" sessionDidActivate " + arg0.getSource());

	}

	public void sessionWillPassivate(HttpSessionEvent arg0) {
		System.out.println(" sessionWillPassivate " + arg0);

	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {

		//log.info("AttributeAdded" + arg0.getName());
		log.info("AttributeAdded=" + arg0.getValue());
		if (arg0.getName().equals("loginDetails")) {
			User user = (User) arg0.getValue();

			//log.info("USER"+user.getCandidateId());
			log.info("USER ID--->" + user.getUserId());
			log.info("USER Name--->" + user.getUserName());
			//log.info("AttributeAdded " + arg0.getName()+""+user.getCandidateId());
			//log.info("AttributeAdded=" + arg0.getValue()+""+user.getCandidateId());
		}

	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		log.info(" attributeRemoved =" + arg0.getValue());
		log.info("attributeRemoved" + arg0.getName());

	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {

		log.info("attributeReplaced" + arg0.getName());

	}

	public void valueBound(HttpSessionBindingEvent arg0) {
		log.info(" valueBound " + arg0.getName());

	}

	public void sessionCreated(HttpSessionEvent arg0) {
		log.info("Session Created ID-->" + arg0.getSession().getId());

	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		
		log.info(" Session Destroyed at Login out Time ID-->"
				+ arg0.getSession().getId());
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
		log.info("Date of Login -->" + CommonUtil.now("dd-MM-yyyy"));
		log.info("Time of Login -->" + currentTime);
		
		CommonDBdao commonDBdao=new CommonDBdao();
		if(commonDBdao.acessLogOut(arg0.getSession().getId(), CommonUtil.now("dd-MM-yyyy")))
		{
			log.info("Log Out Sucessfully");
		}

	}

	public void valueUnbound(HttpSessionBindingEvent arg0) {
		log.info("Session is destorying"+arg0.getSession().getId());
		log.info("Session Last Access Time"+arg0.getSession().getLastAccessedTime());
		
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		
		log.info("Context is Destorying");
		
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		log.info("Context is Init");
		
	}

	 

}
