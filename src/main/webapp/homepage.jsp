<%-- 
    Document   : homepage
    Created on : 3 Sep, 2017, 11:22:03 PM
    Author     : Abhijit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
      <link rel="stylesheet" href="css/style.css">
      <title>HOME-PAGE</title>
    </head>
   
<body>
           
<div class="login-page">
            
  <div class="form" id="frm">
      
      <form class="register-form" method="get" action="Register">
           
             <input type="text" name="fname" placeholder="FIRST NAME" id="fnm">
                
             <input type="text" name="lname" placeholder="LAST NAME"id="lnm">
               
             <input type="text" name="email" id="emaiR" placeholder="ENTER EMAILID" onblur="keychk()" >
               
             <input type="text" name="pwd" placeholder="CREATE PASSWORD" id="pw">
               
             <input type="text" name="phn" placeholder="ENTER PHONE" id="ph"  onblur="numchk()" >
            
                <button class="Rbtn">create</button>
                    
                <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>
      
      
     
    
               
               
               
    <form class="login-form" method="get" action="Login">
            
        <input type="text" name="email" id="emaiL" placeholder="Enter Email" onblur="keychk()">
            
             <input type="text" name="pwd" placeholder="Enter Password" id="pws">
             
             <button class="Lbtn">login</button>
             
                 <p class="message">Not registered? <a href="#">Create an account</a></p>
                 
    </form>
      
    
  </div>
      
</div>
    
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="main.js"></script>
</body>
</html>
