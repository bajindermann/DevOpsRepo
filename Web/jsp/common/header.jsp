 

 <%@ page import="com.consulting.vo.User"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.io.*"  %>
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
<html lang="en">
  <head>   
    <meta name="description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <!-- Twitter meta-->
    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:site" content="@pratikborsadiya">
    <meta property="twitter:creator" content="@pratikborsadiya">
    <!-- Open Graph Meta-->
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="Vali Admin">
    <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme">
    <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin">
    <meta property="og:image" content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png">
    <meta property="og:description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <title>SISL Govt-Sales</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  </head>
    
  <body class="app sidebar-mini"> 
    
    <header class="app-header" style="padding:5px"><a class="app-header__logo" href="#"><img class="app-sidebar__user-avatar" src="images/logo-1-1.png" alt="User Image" style="width:100px"></a>
      <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
      <!-- Navbar Right Menu-->
      <ul class="app-nav">
         
        <!-- User Menu-->
		<!-- <li><img class="app-sidebar__user-avatar" src="images/cairn-india-logo.png" alt="User Image"> 
           
          </li> -->
 
              
      
        <li class="dropdown"><a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu"><i class="fa fa-user fa-lg"></i></a>
          <ul class="dropdown-menu settings-menu dropdown-menu-right">
            
            <!-- <li><a class="dropdown-item" href="page-user.html"><i class="fa fa-user fa-lg"></i> Profile</a></li> -->
            <li><a  <%= request.getContextPath() %> class="dropdown-item" href="logoff.action"><i class="fa fa-sign-out fa-lg"></i> Logout</a></li>
          </ul>
        </li>
      </ul>
    </header>
    <s:if test="#session.user_details==null">
  <main class="app-content">
<h3>Your current session has expired.</h3>
 
<ul>
	<li>Please <a href="/cairnwx/home.jsp">Click Here</a> to log in again</a></li>
	 
</ul>
<br> 
 </main>
</s:if>
    </body>
    </html>