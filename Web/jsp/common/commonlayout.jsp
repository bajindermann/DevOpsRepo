<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>SISL Govt-Sales</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Main CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css">
<!-- Font-icon css-->
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title><tiles:getAsString name="title"/></title>
</head>
<body topmargin="0">
<table width="100%" border="0" cellspacing="0" align="center" >
  
  <tr>
  	<td width="100%"><tiles:insertAttribute name="body"/></td>
  </tr>
  
</table> 

<SCRIPT src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"
		type=text/javascript></SCRIPT>
	<SCRIPT src="${pageContext.request.contextPath}/js/popper.min.js"
		type=text/javascript></SCRIPT>
	<SCRIPT src="${pageContext.request.contextPath}/js/bootstrap.min.js"
		type=text/javascript></SCRIPT>
	<SCRIPT src="${pageContext.request.contextPath}/js/plugins/pace.min.js"
		type=text/javascript></SCRIPT>
	<SCRIPT src="${pageContext.request.contextPath}/js/main.js"
		type=text/javascript></SCRIPT>
	<SCRIPT
		src="${pageContext.request.contextPath}/js/plugins/bootstrap-datepicker.min.js"
		type=text/javascript></SCRIPT>
	<SCRIPT
		src="${pageContext.request.contextPath}/js/plugins/jquery.dataTables.min.js"
		type=text/javascript></SCRIPT>
	<SCRIPT
		src="${pageContext.request.contextPath}/js/plugins/dataTables.bootstrap.min.js"
		type=text/javascript></SCRIPT>
	<SCRIPT
		src="${pageContext.request.contextPath}/js/plugins/dataTables.buttons.min.js"
		type=text/javascript></SCRIPT>
	<SCRIPT
		src="${pageContext.request.contextPath}/js/plugins/jszip.min.js"
		type=text/javascript></SCRIPT>
	<SCRIPT
		src="${pageContext.request.contextPath}/js/plugins/vfs_fonts.js"
		type=text/javascript></SCRIPT>
	<SCRIPT
		src="${pageContext.request.contextPath}/js/plugins/buttons.html5.min.js"
		type=text/javascript></SCRIPT>
</body>
</html>
          