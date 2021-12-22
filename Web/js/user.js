function validation(value)
{
	var ck_username = /^[A-Za-z0-9_.-]{3,30}$/;
    if(document.getElementById('userId').value.trim()==""||document.getElementById('userId').value.trim()==null)
	  {
	     document.getElementById("userIderror").innerHTML = 'Please Enter User ID.';
	     document.getElementById('userId').focus();
	      return false;
	  }
    else
    	{
    	 document.getElementById("userIderror").innerHTML = '';
    	}
       if (!ck_username.test(document.getElementById('userId').value.trim())) {
    	   document.getElementById("userIderror").innerHTML = 'Please Enter Alphanumeric Characters between 3 to 30.';
  	        document.getElementById('userId').focus();
  	      return false;
    	  }
       else
		   	{
		   	 document.getElementById("userIderror").innerHTML = '';
		   	}
    if(document.getElementById('password').value.trim()==""||document.getElementById('password').value.trim()==null)
	  {
	     document.getElementById("passworderror").innerHTML = 'Please Enter Password';
	     document.getElementById('password').focus();
	      return false;
	  }
  else
  	{
  	 document.getElementById("passworderror").innerHTML = '';
  	}
} 

function validationadduser(value)
{
	var ck_username = /^[A-Za-z0-9_.-\s]{2,30}$/;
	var degrex = /^[A-Za-z0-9_.-\s]{1,30}$/;
	var locrex = /^[A-Za-z-]{3,20}$/;
	var mobrex=/^(?:(?:\+|0{0,2})91(\s*[\-]\s*)?|[0]?)?[7896]\d{9}$/;
	var emailrex= /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(document.getElementById('uname').value.trim()==""||document.getElementById('uname').value.trim()==null)
	  {
	     document.getElementById("unameerror").innerHTML = 'Please Enter User Name.';
	     document.getElementById('uname').focus();
	      return false;
	  }
    else
    	{
    	 document.getElementById("unameerror").innerHTML = '';
    	}
       if (!ck_username.test(document.getElementById('uname').value.trim())) {
    	   document.getElementById("unameerror").innerHTML = 'Please Enter Alphanumeric Characters between 3 to 30.';
  	        document.getElementById('uname').focus();
  	      return false;
    	  }
       else
		   	{
		   	 document.getElementById("unameerror").innerHTML = '';
		   	}
       if(document.getElementById('uid').value.trim()==""||document.getElementById('uid').value.trim()==null)
 	  {
 	     document.getElementById("uiderror").innerHTML = 'Please Enter User ID.';
 	     document.getElementById('uid').focus();
 	      return false;
 	  }
     else
     	{
     	 document.getElementById("uiderror").innerHTML = '';
     	}
        if (!ck_username.test(document.getElementById('uid').value.trim())) {
     	   document.getElementById("uiderror").innerHTML = 'Please Enter Alphanumeric Characters between 3 to 30.';
   	        document.getElementById('uid').focus();
   	      return false;
     	  }
        else
 		   	{
 		   	 document.getElementById("uiderror").innerHTML = '';
 		   	}
        if(!mobrex.test(document.getElementById('mobno').value.trim()))
   	  {
   	     document.getElementById("mobnoerror").innerHTML = 'Please Enter valid 10 digit Mob No, ex.9811111111.';
   	     document.getElementById('mobno').focus();
   	      return false;
   	  }
       else
       	{
       	 document.getElementById("mobnoerror").innerHTML = '';
       	}
        if(!emailrex.test(document.getElementById('email').value.trim()))
     	  {
     	     document.getElementById("emailerror").innerHTML = 'Please Enter valid Email ID.';
     	     document.getElementById('email').focus();
     	      return false;
     	  }
         else
         	{
         	 document.getElementById("emailerror").innerHTML = '';
         	}
        if(document.getElementById('designation').value.trim()==""||document.getElementById('designation').value.trim()==null)
  	  {
  	     document.getElementById("designationerror").innerHTML = 'Please Enter Designation.';
  	     document.getElementById('designation').focus();
  	      return false;
  	  }
      else
      	{
      	 document.getElementById("designationerror").innerHTML = '';
      	}
         if (!degrex.test(document.getElementById('designation').value.trim())) {
      	   document.getElementById("designationerror").innerHTML = 'Please Enter Alphanumeric Characters between 3 to 30.';
    	        document.getElementById('designation').focus();
    	      return false;
      	  }
         else
  		   	{
  		   	 document.getElementById("designationerror").innerHTML = '';
  		   	}
         if(document.getElementById('location').value.trim()==""||document.getElementById('location').value.trim()==null)
     	  {
     	     document.getElementById("locationerror").innerHTML = 'Please Select  Location.';
     	     document.getElementById('location').focus();
     	      return false;
     	  }
         else
         	{
         	 document.getElementById("locationnerror").innerHTML = '';
         	}
            if (!locrex.test(document.getElementById('location').value.trim())) {
         	   document.getElementById("locationerror").innerHTML = 'Please Select Location.';
       	        document.getElementById('location').focus();
       	      return false;
         	  }
            else
     		   	{
     		   	 document.getElementById("locationnerror").innerHTML = '';
     		   	}
            if (document.getElementById('status').value.trim()=='Y' || document.getElementById('status').value.trim()=='N') {
            	document.getElementById("status").innerHTML = '';
          	  }
             else
      		   	{
      		   	 
      		     document.getElementById("statuserror").innerHTML = 'Please Select Status.';
   	             document.getElementById('status').focus();
   	             return false;
      		   	}
}  