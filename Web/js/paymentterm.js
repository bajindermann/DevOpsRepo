$(".js-range-slider#range1").ionRangeSlider({
    skin: "big",
    min: 1,
    max: 100,
    from: 100,
    to: 100,
    grid: false,
    type: "single",
    //skin: "modern",
    skin: "round",
    //skin: "sharp",
    to_shadow: true,
    onFinish: function (data) {
    	$(this).next('input').val(data.to);
    }
});

$(".js-range-slider#range2").ionRangeSlider({
    skin: "big",
    
    min: 0,
    max: 100,
    from: 0,
    to: 100,
    grid: false,
    type: "single",
    //skin: "modern",
    skin: "round",
    //skin: "sharp",
    to_shadow: true,
    
    onFinish: function (data) {
    	$(this).next('input').val(data.to);
    }
});


$(".js-range-slider#range3").ionRangeSlider({
    skin: "big",
    min: 0,
    max: 100,
    from: 0,
    to: 100,
    grid: false,
    type: "single",
    //skin: "modern",
    skin: "round",
    //skin: "sharp",
    to_shadow: true,
    onFinish: function (data) {
    	$(this).next('input').val(data.to);
    }
});



$(".js-range-slider#range4").ionRangeSlider({
    skin: "big",
    min: 0,
    max: 100,
    from: 0,
    to: 100,
    grid: false,
    type: "single",
    //skin: "modern",
    skin: "round",
    //skin: "sharp",
    to_shadow: true,
    onFinish: function (data) {
    	$(this).next('input').val(data.to);
    }
});
 
 function updateTextInput1(val)
{ 
	
document.getElementById('range1').value;

	//alert("2");
	 updatetotal(1);
	 //myFunction1();
	
	
}
		    
function updateTextInput2(val)
{   
	document.getElementById('range2').value;
	updatetotal(2);
	//myFunction2(); 
	
}

function updateTextInput3(val) 
{
   document.getElementById('range3').value; 
   updatetotal(3);
	//myFunction3();
}
function updateTextInput4(val) 
{
   document.getElementById('range4').value; 
   updatetotal(4);
	//myFunction4();
}


function updatetotal(item) {
	//alert('updatetotal');
	var firstInput = document.getElementById('range1').value; 
	var secondInput = document.getElementById('range2').value; 
	var thirdInput = document.getElementById('range3').value; 
	var fourthInput = document.getElementById('range4').value;

	firstInput = (firstInput != '') ? parseInt(firstInput) : parseInt(0);
	secondInput = (secondInput != '') ? parseInt(secondInput) : parseInt(0);
	thirdInput = (thirdInput != '') ? parseInt(thirdInput) : parseInt(0);
	fourthInput = (fourthInput != '') ? parseInt(fourthInput) : parseInt(0);
	
	var total = parseInt(firstInput + secondInput + thirdInput + fourthInput);
	if( total <=100){
		document.getElementById('total').value = total;
		//document.getElementById('textInput'+item).value = total;
	} else {
		alert('Not Possible');
		document.getElementById('range'+item).value = '';
		
		
	}
    
}

function updatetotalsecond(val){
	var a =document.getElementById('range1').value;
	var b =document.getElementById('range2').value;
	var c=parseInt(a)+parseInt(b);
	
	document.getElementById('total').value=c;
	
	
}

function updatetotalthird(val){
	//alert("in thhird");
	var a =document.getElementById('range1').value;
	var b =document.getElementById('range2').value;
	var c =document.getElementById('range3').value;
	var d=parseInt(a)+parseInt(b)+parseInt(c);
	
	document.getElementById('total').value=d;
	
}

function updatetotalfourth(val){
	//alert("in thhird");
	var a =document.getElementById('range1').value;
	var b =document.getElementById('range2').value;
	var c =document.getElementById('range3').value;
	var d =document.getElementById('range4').value;
	var e=parseInt(a)+parseInt(b)+parseInt(c)+parseInt(d);
	
	document.getElementById('total').value=e;
	
}


function myFunction1() {
	//alert('myFunction11');
 	if(document.getElementById('total').value<100)
 	{
 		$("#range1").prop('disabled', false);
 		$("#range2").prop('disabled', false);
 		$("#range3").prop('disabled', false);
 		$("#range4").prop('disabled', false);
        
    	
        
	}
 	else
 		{
 		$("#range2").prop('disabled', true);
 		$("#range3").prop('disabled', true);
 		$("#range4").prop('disabled', true);
 		}
 	
 	
 	
 	}
	
function myFunction2() {
 	if(document.getElementById('total').value<100)
 	{
 		$("#range2").prop('disabled', false);
      
 		$("#range1").prop('disabled', false);
 		$("#range3").prop('disabled', false);
 		$("#range4").prop('disabled', false);
        
	}
 	else
 		{
 		$("#range1").prop('disabled', true);
 		$("#range3").prop('disabled', true);
 		$("#range4").prop('disabled', true);
 		}
 	
 	
 	
 	}

function myFunction3() {
 	if(document.getElementById('total').value<100)
 	{
 		$("#range3").prop('disabled', false);
      	
 		$("#range1").prop('disabled', false);
 		$("#range2").prop('disabled', false)
 		$("#range4").prop('disabled', false);
        
	}
 	else
 		{
 		$("#range1").prop('disabled', true);
 		$("#range2").prop('disabled', true)
 		$("#range4").prop('disabled', true);
 		}
 	
 	
 	
 	}
	

function myFunction4() {
 	if(document.getElementById('total').value<100)
 	{
 		$("#range3").prop('disabled', false);
      	
 		$("#range1").prop('disabled', false);
 		$("#range2").prop('disabled', false)
 		$("#range4").prop('disabled', false);
        
	}
 	else
 		{
 		$("#range1").prop('disabled', true);
 		$("#range2").prop('disabled', true)
 		$("#range3").prop('disabled', true);
 		}
 	
 	
 	
 	}
	


/*function updatetotal1(val) {
var a =	document.getElementById('textInput1').value
	
var b =	document.getElementById('textInput2').value
	}
*/
