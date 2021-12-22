<%@page import="com.consulting.vo.User" %>
  <%@ taglib prefix="s" uri="/struts-tags"%>
  <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>

<% 
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");	     
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0"); 
response.setHeader("X-XSS-Protection","1; mode=block");
response.setHeader("X-Frame-Options", "DENY"); 
response.setHeader("X-Content-Type-Options", "nosniff");
response.setHeader("Content-Security-Policy-Report-Only", "default-src 'self'; script-src 'self' 'unsafe-inline'; object-src 'none'; style-src 'self' 'unsafe-inline'; img-src 'self'; media-src 'none'; frame-src 'none'; font-src 'self'; connect-src 'self'; report-uri REDACTED");
response.setHeader("X-Content-Security-Policy-Report-Only", "default-src 'self'; script-src 'self' 'unsafe-inline'; object-src 'none'; style-src 'self' 'unsafe-inline'; img-src 'self'; media-src 'none'; frame-src 'none'; font-src 'self'; connect-src 'self'; report-uri REDACTED");
%>
	  <s:if test="#session.user_details!=null">
  <HEAD>
  
  <script src="${pageContext.request.contextPath}/js/user.js"></script>
  </HEAD> 
<main class="app-content">
<h3>User information is not updated, duplicate request detected.</h3>
<h4>Possible Reasons are:</h4>
<ul>
	<li>Back button usage to submit form again</li>
	<li>Double click on Submit button</li>
	<li>Using "Reload" Option in browser</li>
</ul>
<br> 
 </main>
 </s:if>