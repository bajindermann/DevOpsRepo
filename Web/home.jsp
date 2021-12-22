<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
        response.addHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        response.addHeader("Cache-Control","pre-check=0,post-check=0");
        response.setDateHeader("Expires",0);
%>     
 <%@ taglib prefix="s" uri="/struts-tags"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <title>SISL Infotech| Login</title>
  <style type="text/css">
    .bg-main{
      position: absolute;
    z-index: 999;
    width: 100%;
    opacity: 0.7;
    height: 80px;
    border-bottom: 1px #5a5a5a solid;
    background-color: #424242  !important;
    }
    .custom-form{
      padding: 40px 30px 30px;
    }
    .errorMessage{
    	color:red;
    }
    #login-form>ul{
    	list-style: none;
    }
  </style>
</head>

<body> 
  <header class="bg-main">
    <div class="container">
      <nav class="navbar navbar-expand-lg navbar-light">
        <a class="navbar-brand" href="javascript:void(0)">
          <img src="${pageContext.request.contextPath}/images/logo.png" style="height: 50px;width: 105px;">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        </div>
      </nav>
    </div>
  </header>
  <section class="banner">
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img class="d-block w-100" src="${pageContext.request.contextPath}/images/slider.jpg">
            </div>
          </div>
        </div>
        <div class="overlap" style="background:none;top: -58px;">
          <div class="container">
            <div class="row px-4">
              <div class="col-md-7 text-light">
                <div class="text-box-center">
                    <h1>Test Web App</h1>
                    <p>SISL Infotech is a leading system integrator in India, helping customers bring  automation to their business functions with IT software and services. We take immense pride in serving needs of public and corporate enterprises with the best of IT, IoT, analytics and AI Solutions.</p>
                </div>   
              </div>
              <div class="col-md-5">
                <div class="form-wrap">
                 <div class="login-wrap">
                    <h2>Login</h2>
                    <s:form action="Loginaction" id="login-form" name="frmlogin" cssClass="custom-form">
                       <s:if
	test="actionMessages != null && actionMessages.size > 0 || 
actionErrors != null && actionErrors.size > 0 || fieldError!=null && fieldError.size>0">
 							 
							    <s:fielderror/>
								<s:actionerror />								 
								<s:actionmessage /> 
				 		 
					</s:if>
                      <div class="form-group">
             <input type="text" name="userId" id="userid" class="form-control" placeholder="Username" autocomplete="off" label="userid"> 
                        <!--  <s:textfield name="userId" id="userid" cssClass="form-control" label="userId"/> --> 
                       <s:fielderror><s:param value="%{'userId'}" /></s:fielderror> 
                      </div>
                      <div class="form-group">
                    <input type="password" name="password" id="password" class="form-control" placeholder="Password" autocomplete="off" label="password">  
                       <!--<s:password name="password" id="password" cssClass="form-control" label="password" />-->                      
                       <s:fielderror><s:param value="%{'password'}" /></s:fielderror>
                      </div> 
                       
                      <s:submit name="Submit" type="submit" cssClass="btn-block mt-4  btn btn-theme"
									value="Submit" method="execute" />
                    </s:form>
                 </div>
                </div>
              </div>
            </div>
            </div>
        </div>
  </section>
  <footer class="footer" style="background: #0e0e0e;">
      <div class="container" style="">
        <div class="row pt-3">
          <div class="col-md-12 text-center">
            <p>
              Copyright &copy;2020 All right reserved |
              <a href="https://www.sislinfotech.com" target="_blank">SISL Infotech Pvt Ltd</a>
            </p>
          </div>
        </div>
      </div>
    </footer>
  <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
  
</body>
</html>