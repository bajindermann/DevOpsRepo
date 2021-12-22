<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>

 <% 
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");	     
	    response.setHeader("Pragma","no-cache");
	    response.setHeader("Expires","0");	    
	    if (session.getAttribute("user_details")==null) {
	        response.sendRedirect("/home.jsp");
	     }  
	  %>
</head>

<main class="app-content">
      <div class="app-title">
        <h1> SISL Govt-Sales Order Mgmt. System
      </h1>
      </div>
     <div class="app-title">
     
      &#8226; SISL Infotech is a leading system integrator in India, helping customers bring automation to their business functions with IT software and services. We take immense pride in serving needs of public and corporate enterprises with the best of IT, IoT, analytics and AI solutions.<br><br>
		   
		  
 


    </div>
    </main>