 <% 
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");	     
	    response.setHeader("Pragma","no-cache");
	    response.setHeader("Expires","0");
	    
	    if (session.getAttribute("user_details")==null) {
	        response.sendRedirect("/home.jsp");
	     }  
	  %>