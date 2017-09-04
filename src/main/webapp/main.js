/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});



$('.Rbtn').click(function(){
   var x = document.getElementById("fnm").value;
    if (x === "") {
        alert(" First Name must be filled out");
       javascript:return false;
       
    }
});


$('.Rbtn').click(function(){
   var x = document.getElementById("lnm").value;
    if (x === "") {
        alert(" Last Name must be filled out");
       javascript:return false;
       
    }
});


$('.Rbtn').click(function(){
   var x = document.getElementById("emai").value;
    if (x === "") {
        alert(" email must be filled out");
       javascript:return false;
       
    }
});



$('.Rbtn').click(function(){
   var x = document.getElementById("ph").value;
    if (x === "") {
        alert(" Phone  must be filled out");
       javascript:return false;
       
    }
});


$('.Rbtn').click(function(){
   var x = document.getElementById("pw").value;
    if (x === "") {
        alert(" Password must be filled out");
       javascript:return false;
       
    }
});






$('.Lbtn').click(function(){
   var x = document.getElementById("emaiL").value;
    if (x === "") {
        alert(" e-mail must be filled out");
       javascript:return false;
       
    }
});


$('.Lbtn').click(function(){
   var x = document.getElementById("pws").value;
    if (x === "") {
        alert(" Password must be filled out");
       javascript:return false;
       
    }
});









//email validation
function keychk() { 
var x=document.getElementById("emaiL").value;  
var atposition=x.indexOf("@");  
var dotposition=x.lastIndexOf(".");  
if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
  alert("Please enter a valid e-mail address");  
  javascript:return false;  
  }  
  }
  
  
  function keychk() {
var x=document.getElementById("emaiR").value;  
var atposition=x.indexOf("@");  
var dotposition=x.lastIndexOf(".");  
if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
  alert("Please enter a valid e-mail address");  
  javascript:return false;  
  }  
  }


//phn validation

function numchk(){  
var num=document.getElementById("ph").value;  
if (isNaN(num) && num.length!=='10'){  
  alert("Enter Numeric value of 10 Digit only");  
 javascript:return false;
}else{  
  javascript:return true;
  }  
}  