<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/menu.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/standard.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet" />
<title><tiles:getAsString name="title"/></title>
</head>
<body topmargin="0">
 <% 
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");	     
	    response.setHeader("Pragma","no-cache");
	    response.setHeader("Expires","0");
	    
	    if (session.getAttribute("user_details")==null) {
	        response.sendRedirect("/home.jsp");
	     }  
	  %>
<table width="100%" border="0" cellspacing="0" align="center" >
  
  <tr>
  	<td width="100%"><tiles:insertAttribute name="body"/></td>
  </tr>
  
</table> 
</body>
</html>
          