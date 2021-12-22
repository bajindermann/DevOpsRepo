function confirmDelete() {

  return confirm("Are you sure you want to delete");
}
function openPopup(url) {
	//alert("" + url);
	window.open("" + url, "myWindow", "status = 1, height = 300, width = 600, resizable = 0");
}

// JScript source code



function ShowHide(obj)
{
    //alert("hello");
    if (document.getElementById(obj).style.display == "")
    {
        document.getElementById(obj).style.display = "none";
    }
    
    else if (document.getElementById(obj).style.display == "none")
    {
        document.getElementById(obj).style.display = "";
    }
}

// JScript source code

function ShowHide(obj)
{
    //alert("hello");
    if (document.getElementById(obj).style.display == "")
    {
        document.getElementById(obj).style.display = "none";
    }
    
    else if (document.getElementById(obj).style.display == "none")
    {
        document.getElementById(obj).style.display = "";
    }
}

function CreateNewVersion(obj)
{
    //alert(obj);
    if (obj == "CreateOnlineVersion")
    {
        document.getElementById("CreateOnlineVersion").style.display = "";
        document.getElementById("UploadFile").style.display = "none";
    }
    else if (obj == "UploadFile")
    {
        document.getElementById("CreateOnlineVersion").style.display = "none";
        document.getElementById("UploadFile").style.display = "";
    }
}

function permission(obj)
{
    //alert(obj);
    if (obj == "DM_Doc_View_Cont")
    {
        document.getElementById("DM_Doc_View_Cont").style.display = "";
        document.getElementById("SecurityCont").style.display = "none";
    }
    else if (obj == "SecurityCont")
    {
        document.getElementById("DM_Doc_View_Cont").style.display = "none";
        document.getElementById("SecurityCont").style.display = "";
    }
}

function popUpWindow(url, width, height, x, y)
{
	wind = window.open(url, "_blank", "width=" +width+ ",height=" +height+ ",scrollbars=yes");
	if(x != null && y != null)
	{
		wind.moveTo(x, y);
	}else
	{
		x = (screen.width/2)  - (width/2);
		y = (screen.height/2) - (height/2);
		wind.moveTo(x, y);
		//alert( width + ", " +height+ "\n" +screen.width+ "x" +screen.height +"\nx: "+ x +", y: "+ y);
	}
}

// for ERP page

function validationERP() {	 
	if (document.getElementById("accountType").value == "salaryType" || document.getElementById("accountType").value == "invoiceType") { 
	
	if (document.getElementById("fromDate").value == "") {
		alert("Please enter from date");
		return false;
	}
	if (document.getElementById("toDate").value == "") {
        alert('Please enter To date');
        return false;
    }
	}
	return true;
}