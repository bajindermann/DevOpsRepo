<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");	     
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
response.setDateHeader("Expires",-1);
 
if (session.getAttribute("user_details")==null) {
	response.sendRedirect(request.getContextPath() + "/home.jsp");
 }  
%>
 
</body>
</html>