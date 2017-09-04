<%-- 
    Document   : linkverification
    Created on : 3 Sep, 2017, 9:39:51 PM
    Author     : Abhijit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="css/style.css">
     
        <title>ACCOUNT VERIFICATION</title>
    </head>
    <body>
       
        <%
       
            
           String email= request.getParameter("email").toString();
        Connection Conn = null;
	PreparedStatement PrepareStat = null;
	
 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
	
		}
 
		try {
                    
			Conn = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12192611", "sql12192611", "XWch1xppLf");
			if (Conn != null) {
				
			} else {
				
			}
                    }
                catch (SQLException e)
                {
			
			e.printStackTrace();
		
		}
                
                
                try {
			String insertQueryStatement = "SELECT email temp SET verify=? WHERE email=?";
 
			PrepareStat = Conn.prepareStatement(insertQueryStatement);
			PrepareStat.setString(1, "1");
			PrepareStat.setString(2, email);
			
			
			PrepareStat.executeUpdate();
			
                        out.println("VERIFIED");
		} catch (
 
		SQLException e) {
			e.printStackTrace();
                      
		}
                
                
                
                
                
                
		try {
			String uq = "UPDATE temp SET verify=? WHERE email=?";
 
			PrepareStat = Conn.prepareStatement(uq);
			PrepareStat.setString(1, "1");
			PrepareStat.setString(2, email);
			
			
			PrepareStat.executeUpdate();
			
                       // out.println("VERIFIED");
		} catch (
 
		SQLException e) {
			e.printStackTrace();
                      
		}
	
 
%>


 <div class="login-page">
      
      
  <div class="form">
      
      <%
          
          out.println("VERIFIED");
          /*
      
      <form class="register-form" method="get" action="Register">
       <input type="text" name="fname" placeholder="FIRST NAME">
            <br>
            <input type="text" name="lname" placeholder="LAST NAME">
            <br>
            <input type="text" name="email" placeholder="ENTER EMAILID">
            <br>
            <input type="text" name="pwd" id="pas" placeholder="CREATE PASSWORD">
            <br>
            <input type="text" name="phn" placeholder="ENTER PHONE">
             <button>create</button>
      <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>
      
      
      <form class="login-form" method="get" action="Login">
      <input type="text" name="email" placeholder="Enter Email">
            <input type="text" name="pwd" placeholder="Enter Password">
      <button>login</button>
      <p class="message">Not registered? <a href="#">Create an account</a></p>
    </form>
                */
              
              %>
  </div>
      
      
</div>
 







    </body>
</html>
