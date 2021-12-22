
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="#session.user_details!=null">

<%@page import="com.consulting.vo.User" %>
 <% 
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");	     
	    response.setHeader("Pragma","no-cache");
	    response.setHeader("Expires","0");
	    
	    if (session.getAttribute("user_details")==null) {
	    	response.sendRedirect("/home.jsp");
	     }  
	  %>
<%User user=(User) session.getAttribute("user_details"); %>
<%
if ((String) request.getAttribute("url")==null) {
    response.sendRedirect("/home.jsp");
 }   
String menu = (String) request.getAttribute("url");
 
%>

<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
    <aside class="app-sidebar">
        <div class="app-sidebar__user"> 
          <div>
             <h3  class="app-sidebar__user-name">SISL Govt-Sales</h3>
              <br>
            <p class="app-sidebar__user-designation"><i class="fa fa-user-circle user-circle" aria-hidden="true"></i><%=user.getUserName()%></p>
          </div>
        </div>
        <ul class="app-menu">
           <li><a <%if("home".equals(menu)){%> class="app-menu__item active" <%}else{%> class="app-menu__item" <%}%> href="home!home.action"><i class="app-menu__icon fa fa-home"></i><span class="app-menu__label">Home</span></a></li>
          <li <%if("adduser".equals(menu) || "viewuser".equals(menu) || "edit".equals(menu) || "changepassword".equals(menu)){%> class="treeview is-expanded"  <%}else{%>class="treeview"  <%} %>><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-user-o"></i><span class="app-menu__label">User Mgmt</span><i class="treeview-indicator fa fa-angle-right"></i></a>
            <ul class="treeview-menu">
               <li><a <%if("changepassword".equals(menu)){%> class="treeview-item active"  <%}else{%> class="treeview-item" <%} %> href="Login!changepassword.action"><i class="icon fa fa-circle-o"></i> Change Password</a></li>
			   <li><a <%if("adduser".equals(menu)){%> class="treeview-item active"  <%}else{%> class="treeview-item" <%} %> href="add!adduser.action"><i class="icon fa fa-circle-o"></i> Add User</a></li>
               <li><a <%if("viewuser".equals(menu)){%> class="treeview-item active"  <%}else{%> class="treeview-item" <%} %> href="View!viewuser.action"><i class="icon fa fa-circle-o"></i> View/Edit</a></li>
            </ul>
          </li> 
           <li <%if("oem".equals(menu) || "oemview".equals(menu)){%> class="treeview is-expanded"  <%}else{%>class="treeview"  <%} %>><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-list-alt"></i><span class="app-menu__label">OEM</span><i class="treeview-indicator fa fa-angle-right"></i></a>
            <ul class="treeview-menu">
                <li><a <%if("oem".equals(menu)){%> class="treeview-item active"  <%}else{%> class="treeview-item" <%} %> href="oem!saveoemdetails.action"><i class="icon fa fa-circle-o"></i> Add OEM Details</a></li>
               <li><a <%if("oemview".equals(menu)){%> class="treeview-item active"  <%}else{%> class="treeview-item" <%} %> href="oem!viewoemdetails.action"><i class="icon fa fa-circle-o"></i> View/Edit</a></li>
            </ul>
          </li>  
          
          <li <%if("po".equals(menu) || "viewpo".equals(menu)){%> class="treeview is-expanded"  <%}else{%>class="treeview"  <%} %>><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-plus-square-o"></i><span class="app-menu__label">Order Processing</span><i class="treeview-indicator fa fa-angle-right"></i></a>
            <ul class="treeview-menu">
                <li><a <%if("po".equals(menu)){%> class="treeview-item active"  <%}else{%> class="treeview-item" <%} %> href="addpo!saveorder.action"><i class="icon fa fa-circle-o"></i> Add PO</a></li>
               <li><a <%if("viewpo".equals(menu)){%> class="treeview-item active"  <%}else{%> class="treeview-item" <%} %> href="addpo!viewpo.action"><i class="icon fa fa-circle-o"></i> View/Edit</a></li>
            </ul>
          </li>   
  <li <%if("vendor".equals(menu) || "vendordetails".equals(menu)){%> class="treeview is-expanded"  <%}else{%>class="treeview"  <%} %>><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-handshake-o"></i><span class="app-menu__label">Vendor</span><i class="treeview-indicator fa fa-angle-right"></i></a>
            <ul class="treeview-menu">
                <li><a <%if("vendor".equals(menu)){%> class="treeview-item active"  <%}else{%> class="treeview-item" <%} %> href="vendor!pending.action"><i class="icon fa fa-circle-o"></i>Pending</a></li>
               <li><a <%if("vendordetails".equals(menu)){%> class="treeview-item active"  <%}else{%> class="treeview-item" <%} %> href="vendor!vendorlist.action"><i class="icon fa fa-circle-o"></i> Vendor Details</a></li>
            </ul>
             <li><a <%if("pbg".equals(menu)){%> class="app-menu__item active" <%}else{%> class="app-menu__item" <%}%> href="pbg!showpbgdetails.action"><i class="app-menu__icon fa fa-list-ul"></i> <span class="app-menu__label">PBG Details</span></a></li>
              
              <li <%if("invoice".equals(menu) || "invoicegenerated".equals(menu)){%> class="treeview is-expanded"  <%}else{%>class="treeview"  <%} %>><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-file-code-o"></i><span class="app-menu__label">Invoice</span><i class="treeview-indicator fa fa-angle-right"></i></a>
                <ul class="treeview-menu">
                <li><a <%if("invoice".equals(menu)){%> class="treeview-item active"  <%}else{%> class="treeview-item" <%} %> href="invoice!pending.action"><i class="icon fa fa-circle-o"></i>Pending</a></li>
               <li><a <%if("invoicegenerated".equals(menu)){%> class="treeview-item active"  <%}else{%> class="treeview-item" <%} %> href="invoice!generated.action"><i class="icon fa fa-circle-o"></i> Generated</a></li>
            </ul>
             
               <li <%if("pending".equals(menu) || "paymentrcvd".equals(menu)){%> class="treeview is-expanded"  <%}else{%>class="treeview"  <%} %>><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-money"></i><span class="app-menu__label">Payments</span><i class="treeview-indicator fa fa-angle-right"></i></a>
                <ul class="treeview-menu">
                <li><a <%if("pending".equals(menu)){%> class="treeview-item active"  <%}else{%> class="treeview-item" <%} %> href="payment!pending.action"><i class="icon fa fa-circle-o"></i>Pending</a></li>
               <li><a <%if("paymentrcvd".equals(menu)){%> class="treeview-item active"  <%}else{%> class="treeview-item" <%} %> href="payment!paymentrcvd.action"><i class="icon fa fa-circle-o"></i> Received</a></li>
            </ul>
            
            <li><a <%if("mis".equals(menu)){%> class="app-menu__item active" <%}else{%> class="app-menu__item" <%}%> href="home!home.action"><i class="app-menu__icon fa fa-info-circle"></i><span class="app-menu__label">MIS</span></a></li>
      </ul>
    </aside>
    </s:if>
    <s:else>    
  </s:else>  
  </body> 