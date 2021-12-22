function Checkfiles2()
{

var re="['+%]";
var fup = document.getElementById('upload');



var fileName = fup.value;



if(fup.value.match(re))
{
alert("Please remove any special symbol written in your file name");
return false;
}

var ext = fileName.substring(fileName.lastIndexOf('.') + 1);

if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "doc" || ext=="pdf" || ext == "docx" ) 

{
document.getElementById('txtMessage').style.display = "";
return true;
 
}
else
{
alert("Please Upload  Valid Format ");

fup.focus();

return false;

}
 
}