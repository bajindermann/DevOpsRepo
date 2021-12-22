function validationaddpo(value) {
	var ck_username = /^[A-Za-z0-9_.-\s]{2,80}$/;
	var degrex = /^[A-Za-z0-9_.-\s]{1,30}$/;
	var num = /^[0-9]{1,30}$/;
	var locrex = /^[A-Za-z-]{3,20}$/;
	var mobrex = /^(?:(?:\+|0{0,2})91(\s*[\-]\s*)?|[0]?)?[7896]\d{9}$/;
	var emailrex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

	if (document.getElementById('cname').value.trim() == ""
			|| document.getElementById('cname').value.trim() == null) {
		document.getElementById("cnameerror").innerHTML = 'Please Enter Customer Name.';
		document.getElementById('cname').focus();
		return false;
	} else {
		document.getElementById("cnameerror").innerHTML = '';
	}
	if (!ck_username.test(document.getElementById('cname').value.trim())) {
		document.getElementById("cnameerror").innerHTML = 'Please Enter Alphanumeric Characters between 3 to 50.';
		document.getElementById('cname').focus();
		return false;
	} else {
		document.getElementById("cnameerror").innerHTML = '';
	}
	if (document.getElementById('accountManager').value.trim() == ""
			|| document.getElementById('accountManager').value.trim() == null) {
		document.getElementById("accountManagererror").innerHTML = 'Please Enter Account Manager.';
		document.getElementById('accountManager').focus();
		return false;
	} else {
		document.getElementById("accountManagererror").innerHTML = '';
	}
	if (!ck_username.test(document.getElementById('accountManager').value
			.trim())) {
		document.getElementById("accountManagererror").innerHTML = 'Please Enter Alphanumeric Characters between 3 to 50.';
		document.getElementById('accountManager').focus();
		return false;
	} else {
		document.getElementById("accountManagererror").innerHTML = '';
	}

	if (document.getElementById('PONo').value.trim() == ""
			|| document.getElementById('PONo').value.trim() == null) {
		document.getElementById("PONoerror").innerHTML = 'Please Enter Purchase Order No.';
		document.getElementById('PONo').focus();
		return false;
	} else {
		document.getElementById("PONoerror").innerHTML = '';
	}
	if (!ck_username.test(document.getElementById('PONo').value.trim())) {
		document.getElementById("PONoerror").innerHTML = 'Please Enter Alphanumeric Characters between 3 to 50.';
		document.getElementById('PONo').focus();
		return false;
	} else {
		document.getElementById("PONoerror").innerHTML = '';
	}

	if (document.getElementById('PODate').value.trim() == ""
			|| document.getElementById('PODate').value.trim() == null) {
		document.getElementById("PODateerror").innerHTML = 'Please Enter Purchase Order Date';
		document.getElementById('PODate').focus();
		return false;
	} else {
		document.getElementById("PODateerror").innerHTML = '';
	}

	if (document.getElementById('LastDeliveryDate').value.trim() == ""
			|| document.getElementById('LastDeliveryDate').value.trim() == null) {
		document.getElementById("LastDeliveryDateerror").innerHTML = 'Please Enter Last Delivery Date.';
		document.getElementById('LastDeliveryDate').focus();
		return false;
	} else {
		document.getElementById("LastDeliveryDateerror").innerHTML = '';
	}

	if (document.getElementById('POStatus').value.trim() == '-Select PO Status-'
			|| document.getElementById('POStatus').value.trim() == null) {
		document.getElementById("POStatuserror").innerHTML = 'Please Select PO Status';
		document.getElementById('POStatus').focus();
		return false;
	} else {
		document.getElementById("POStatuserror").innerHTML = '';
	}

	if (document.getElementById('POValue').value.trim() == ""
			|| document.getElementById('POValue').value.trim() == null) {
		document.getElementById("POValueerror").innerHTML = 'Please Enter PO Value(Without tax).';
		document.getElementById('POValue').focus();
		return false;
	} else {
		document.getElementById("POValueerror").innerHTML = '';
	}
	if (!num.test(document.getElementById('POValue').value.trim())) {
		document.getElementById("POValueerror").innerHTML = 'Please Enter Only Number.';
		document.getElementById('POValue').focus();
		return false;
	} else {
		document.getElementById("POValueerror").innerHTML = '';
	}

	if (document.getElementById('GST').value.trim() == '-Select GST-'
			|| document.getElementById('GST').value.trim() == null) {
		document.getElementById("GSTerror").innerHTML = 'Please select GST';
		document.getElementById('GST').focus();
		return false;
	} else {
		document.getElementById("GSTerror").innerHTML = '';
	}

	if (document.getElementById('ProjectName').value.trim() == ""
			|| document.getElementById('ProjectName').value.trim() == null) {
		document.getElementById("ProjectNameerror").innerHTML = 'Please Enter Project name.';
		document.getElementById('ProjectName').focus();
		return false;
	} else {
		document.getElementById("ProjectNameerror").innerHTML = '';
	}
	if (!ck_username.test(document.getElementById('ProjectName').value.trim())) {
		document.getElementById("ProjectNameerror").innerHTML = 'Please Enter Alphanumeric Characters between 3 to 50.';
		document.getElementById('ProjectName').focus();
		return false;
	} else {
		document.getElementById("ProjectNameerror").innerHTML = '';
	}

	if (document.getElementById('POFile').value.trim() == ""
			|| document.getElementById('POFile').value.trim() == null) {
		document.getElementById("POFileerror").innerHTML = 'Please Upload Purchase Order copy.';
		document.getElementById('POFile').focus();
		return false;
	} else {
		document.getElementById("POFileerror").innerHTML = '';
	}

	if (document.getElementById('total').value.trim() == ""
			|| document.getElementById('total').value.trim() == null
			|| document.getElementById('total').value.trim() < 100) {
		document.getElementById("totalerror").innerHTML = 'Please Enter Payment Terms';
		document.getElementById('total').focus();
		return false;
	} else {
		document.getElementById("totalerror").innerHTML = '';
	}

	if (document.getElementById('cusContactName').value.trim() == ""
			|| document.getElementById('cusContactName').value.trim() == null) {
		document.getElementById("cusContactNameerror").innerHTML = 'Please Enter Contact Person Name.';
		document.getElementById('cusContactName').focus();
		return false;
	} else {
		document.getElementById("cusContactNameerror").innerHTML = '';
	}
	if (!ck_username.test(document.getElementById('cusContactName').value
			.trim())) {
		document.getElementById("cusContactNameerror").innerHTML = 'Please Enter Alphanumeric Characters between 3 to 50.';
		document.getElementById('cusContactName').focus();
		return false;
	} else {
		document.getElementById("cusContactNameerror").innerHTML = '';
	}
	if (document.getElementById('cusContactDesg').value.trim() == ""
			|| document.getElementById('cusContactDesg').value.trim() == null) {
		document.getElementById("cusContactDesgerror").innerHTML = 'Please Enter Contact Person Designation.';
		document.getElementById('cusContactDesg').focus();
		return false;
	} else {
		document.getElementById("cusContactDesgerror").innerHTML = '';
	}
	if (!ck_username.test(document.getElementById('cusContactDesg').value
			.trim())) {
		document.getElementById("cusContactDesgerror").innerHTML = 'Please Enter Alphanumeric Characters between 3 to 50.';
		document.getElementById('cusContactDesg').focus();
		return false;
	} else {
		document.getElementById("cusContactDesgerror").innerHTML = '';
	}
	if (!emailrex.test(document.getElementById('cusContactEmail').value.trim())) {
		document.getElementById("cusContactEmailerror").innerHTML = 'Please Enter valid Email ID.';
		document.getElementById('cusContactEmail').focus();
		return false;
	} else {
		document.getElementById("cusContactEmailerror").innerHTML = '';
	}

	if (!(/^\d{10}$/.test(document.getElementById('cMobNo').value.trim()))) {
		document.getElementById("cMobNoerror").innerHTML = 'Please Enter valid 10 digit Mob No, ex.9811111111.';
		document.getElementById('cMobNo').focus();
		return false;
	} else {
		document.getElementById("cMobNoerror").innerHTML = '';
	}

}