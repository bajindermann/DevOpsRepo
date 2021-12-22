package com.consulting.common.vo;
 import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Address;
 import javax.mail.Authenticator;
 import javax.mail.Message;
 import javax.mail.PasswordAuthentication;
 import javax.mail.Session;
 import javax.mail.Transport;
 import javax.mail.internet.InternetAddress;
 import javax.mail.internet.MimeMessage;

 import com.sun.mail.util.MailSSLSocketFactory;

 
public class sendMail {
    Logger log = Logger.getLogger(this.getClass());
     private static final String PROP_FILE = "/common.properties";
   Properties prop = new Properties();

    public boolean sendmail(String To, String Fromemail, String Fromname,
	    String Subject, String body, String Name) throws IOException
	     {
	boolean flag = false;
	InputStream inputStream = sendMail.class.getResourceAsStream(PROP_FILE);	 
	prop.load(inputStream);
    Properties props = new Properties();
    props.put("mail.smtp.host", prop.getProperty("HOST"));
    props.put("mail.smtp.port", prop.getProperty("SMTP"));	     
    props.put("mail.smtp.auth", "true");	    
    MailSSLSocketFactory sf = null;
    try {
      sf = new MailSSLSocketFactory();
    } catch (GeneralSecurityException e) {
      e.printStackTrace();
    } 
    sf.setTrustAllHosts(true);   
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.debug", "true");
    props.put("mail.smtp.socketFactory.port", prop.getProperty("SMTP"));
    System.out.println("SSL enable");
    props.put("mail.smtp.socketFactory.fallback", "false");
    props.put("mail.smtp.ssl.enable", "false");
    props.put("mail.smtp.ssl.socketFactory", sf);
    Session ses = Session.getDefaultInstance(props, 
        new Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(prop.getProperty("ADMIN_EMAIL"), prop.getProperty("USERPASSWORD"));
          }
        });    
	MimeMessage message = new MimeMessage(ses);	 
	body = " <html>Dear "
		+ Name
		+ ",<br><br>"
		+ " You have now an \n\n"
		+ " access to SISL Govt-Sales App ."
		
+" <p>The following are your account details to log into the system :User name  "
+ body
+ "  respectively. \n\n</p><br>"
		 
		+ " \n</p>"	;	 

		 
    try {
	message.setContent(body, "text/html");
	message.setSubject(Subject);
	Address address = new InternetAddress(Fromemail, Fromname);
	message.setFrom(address);
    Address toaddress = new InternetAddress(To);
	message.setRecipient(Message.RecipientType.TO, toaddress);    
	message.saveChanges();   
    Transport.send((Message)message);     
	flag = true;
    }catch (Exception e) {
	      e.printStackTrace();
	    } 
	return flag;
    }
 private class SMTPAuthenticator extends javax.mail.Authenticator {
	public PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(prop.getProperty("ADMIN_EMAIL"),
		    prop.getProperty("USERPASSWORD"));
	
		
	}
    }
 }
