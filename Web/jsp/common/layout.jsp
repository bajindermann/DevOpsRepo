
 <% 
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");	     
	    response.setHeader("Pragma","no-cache");
	    response.setHeader("Expires","0");
	    
	    if (session.getAttribute("user_details")==null) {
	        response.sendRedirect("/home.jsp");
	     }  
	  %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.io.*"%>

<!DOCTYPE html>
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
</head>
<body class="app sidebar-mini">
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="leftsidebar" />
	<tiles:insertAttribute name="body" />
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

	<script type="text/javascript">
     $(document).ready(function (){
    	 $(document).ready(function(){
    	        $('#weatherfrm').attr('autocomplete', 'off');
    	    });
         var table = $('.datatable').DataTable({
             dom: 'Bfrtip',
             buttons: [
                 'excelHtml5',
                 'csvHtml5',
                  
             ],
             'responsive': true,
             "order": [[ 0, "asc" ]],
         });
 		
        
         
         $('.datePicker2').datepicker({
      	    format: "dd-mm-yyyy",
      	   startDate: '0',
              endDate: '+2d',
          	autoclose: true,
          	todayHighlight: true
        });
         $('.datePicker').datepicker({
       	    format: "dd-mm-yyyy",
       	       
           	autoclose: true,
           	todayHighlight: true
         });
         
         $('.datePicker1').datepicker({
      	    format: "dd-mm-yyyy",
      	  startDate: '01-04-2018',          
          	autoclose: true,
          	todayHighlight: true
        });
         
         $('.datePicker3').datepicker({
       	    format: "dd-mm-yyyy",
       	   startDate: '01-04-2018',
               endDate: '-1d',
           	autoclose: true,
           	todayHighlight: true
         });
     });
    
     
      var data = {
      	labels: ["January", "February", "March", "April", "May"],
      	datasets: [
      		{
      			label: "My First dataset",
      			fillColor: "rgba(220,220,220,0.2)",
      			strokeColor: "rgba(220,220,220,1)",
      			pointColor: "rgba(220,220,220,1)",
      			pointStrokeColor: "#fff",
      			pointHighlightFill: "#fff",
      			pointHighlightStroke: "rgba(220,220,220,1)",
      			data: [65, 59, 80, 81, 56]
      		},
      		{
      			label: "My Second dataset",
      			fillColor: "rgba(151,187,205,0.2)",
      			strokeColor: "rgba(151,187,205,1)",
      			pointColor: "rgba(151,187,205,1)",
      			pointStrokeColor: "#fff",
      			pointHighlightFill: "#fff",
      			pointHighlightStroke: "rgba(151,187,205,1)",
      			data: [28, 48, 40, 19, 86]
      		}
      	]
      };
      var pdata = [
      	{
      		value: 300,
      		color: "#46BFBD",
      		highlight: "#5AD3D1",
      		label: "Complete"
      	},
      	{
      		value: 50,
      		color:"#F7464A",
      		highlight: "#FF5A5E",
      		label: "In-Progress"
      	}
      ]
      
      var ctxl = $("#lineChartDemo").get(0).getContext("2d");
      var lineChart = new Chart(ctxl).Line(data);
      
      var ctxp = $("#pieChartDemo").get(0).getContext("2d");
      var pieChart = new Chart(ctxp).Pie(pdata);
    </script>
    
     <script>
  $(document).ready(function(){
    var count = 2;
    $(".add").click(function () {
         var html = '';
         html += '<tr id="TextBoxDiv'+count+'">';
         html += '<td class="center-div">'+count+'</td>';
         html += '<td><select name="purchaseOrder.oemName" class="form-control item_category" data-sub_category_id="'+count+'"><option value="Checkpoint">Checkpoint</option><option value="CISCO">CISCO</option><option value="Citrix">Citrix</option><option value="Commvault">Commvault</option><option value="Dell EMC">Dell EMC</option><option value="Edgecore">Edgecore</option><option value="Enterprise DB">Enterprise DB</option><option value="ESRI">ESRI</option><option value="F5">F5</option><option value="Forcepoint">Forcepoint</option><option value="Fortinet">Fortinet</option><option value="Gemalto">Gemalto</option><option value="Hitachi Vantara">Hitachi Vantara</option><option value="HP India">HP India</option><option value="HPE">HPE</option><option value="Huawei">Huawei</option><option value="IBM">IBM</option><option value="Juniper">Juniper</option><option value="McAfee">McAfee</option><option value="Microfocus">Microfocus</option><option value="Nutanix">Nutanix</option><option value="Qlik">Qlik</option><option value="Redhat">Redhat</option><option value="Symantec">Symantec</option><option value="Trend Micro">Trend Micro</option><option value="Veeam">Veeam</option><option value="Veritas">Veritas</option><option value="Vmware">Vmware</option><option value="Zimbra">Zimbra</option></select></td>';
         html += '<td><input type="text" name="purchaseOrder.oemDescription" value="" id="oemDescription" class="form-control"/></td>';
         html += '<td><input type="text" name="purchaseOrder.oemAmount" value="" id="oemAmount" class="form-control"/></td>';
         html += '<td><select name="purchaseOrder.warranty" class="form-control item_category" data-sub_category_id="'+count+'"><option value="0">0 Year</option><option value="1">1 Year</option><option value="2">2 Year</option><option value="3">3 Year</option><option value="4">4 Year</option><option value="5">5 Year</option><option value="6">6 Year</option><option value="7">7 Year</option></select></td>';
         html +='<td>&nbsp;</td>';
         $('tbody').append(html);
          count++;
          if(count>10){
              alert("Only 10 rows allow");
              return false;
          }

    });
      $(".remove").click(function () {
        if(count==1){
            alert("No more textbox to remove");
            return false;
        }   
        count--;
      $("#TextBoxDiv" + count).remove();
    });

  });
</script>

</body>
</html>