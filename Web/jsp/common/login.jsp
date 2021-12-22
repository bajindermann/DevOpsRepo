<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>

<% 
response.setHeader("pragma","no-cache");//HTTP 1.1 
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Cache-Control","no-store"); 
response.addDateHeader("Expires", -1); 
response.setDateHeader("max-age", 0); 
//response.setIntHeader ("Expires", -1); //prevents caching at the proxy server 
response.addHeader("cache-Control", "private"); 

%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
     <script src="${pageContext.request.contextPath}/js/user.js"></script>
    <title>Login - CAIRN</title>
  </head>
  
  
  
  <body>
 <s:if test="#session.user_details==null">
    <section class="material-half-bg">
      <div class="cover"></div>
    </section>
    <section class="login-content">
      <div class="logo">
        <center><img src="images/cairn-india-logo.png"></center>
        <h2>Weather Monitoring System </h2> 
      </div>
       
      <div class="login-box">
        <s:form action="Login" name="frmLogin" cssClass="login-form" onsubmit="return validation(this.form)">
        <s:if
							test="actionMessages != null && actionMessages.size > 0 || 
                            actionErrors != null && actionErrors.size > 0 || fieldError!=null && fieldError.size>0">
							<div class="form-group align-self-end">
							<font size="2px" color="red" !important>
							<s:fielderror />
							<s:actionerror />
							<s:fielderror />
							<s:actionmessage />
							</font>
                            </div>     
						</s:if>
          <h3 class="login-head"><i class="fa fa-lg fa-fw fa-user"></i>SIGN IN</h3>
          <div class="form-group">
            <label class="control-label">USERNAME</label>
            <input name="userId" id="userId" class="form-control" type="text" placeholder="User ID" autofocus>
             <span  id="userIderror" style="color: red"></span>
            <p class="error_message_login_username"></p>
          </div>
          <div class="form-group">
            <label class="control-label">PASSWORD</label>
            <input name="password" id="password" class="form-control" type="password" placeholder="Password">
            <span  id="passworderror" style="color: red"></span>
           	<p class="error_message_login_password"></p>
          </div>
         
          <div class="form-group btn-container">
            <button id="login_btn" name="login_btn" type="submit" class="btn btn-primary btn-block" ><i class="fa fa-sign-in fa-lg fa-fw"></i>SIGN IN</button>   
             <%--<s:submit id="login_btn" cssClass="btn btn-primary btn-block,fa fa-sign-in fa-lg fa-fw" value="SIGN IN" action="Login" method="execute" />--%>
          </div>
        </s:form>
       
      </div>
    </section>
    <!-- Essential javascripts for application to work-->
     
   <SCRIPT src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"
		type=text/javascript></SCRIPT>
	<SCRIPT src="${pageContext.request.contextPath}/js/popper.min.js"
		type=text/javascript></SCRIPT>
	<SCRIPT src="${pageContext.request.contextPath}/js/bootstrap.min.js"
		type=text/javascript></SCRIPT>
    <script src="js/main.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <script src="${pageContext.request.contextPath}/js/plugins/pace.min.js"></script>
    <script type="text/javascript">
      // Login Page Flipbox control
      $('.login-content [data-toggle="flip"]').click(function() {
      	$('.login-box').toggleClass('flipped');
      	return false;
      });
      </script> 
  </s:if>
<s:else>  
  <% response.sendRedirect("/cairnwx/Login!home.action"); %>   
  </s:else>  
  </body> 
</html>
 