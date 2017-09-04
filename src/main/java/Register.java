/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.Connection;
import java.sql.SQLException;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


/**
 *
 * @author Abhijit
 */
@WebServlet(urlPatterns = {"/Register"})
public class Register extends HttpServlet {
     
      static Connection Conn = null;
      static PreparedStatement PrepareStat = null;
      static PreparedStatement ps = null;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
           // out.println("Abhijit");
            
           String st=null,op=null,rt,jdbcSt = null;
           
           
                 String fname = request.getParameter("fname");
                 String lname = request.getParameter("lname");
                 String email = request.getParameter("email");
                 String phn = request.getParameter("phn");
                 String pwd = request.getParameter("pwd");
                 
                 
                 
                JDBCConnection(st);
                
             if(st!=null)
             {  jdbcSt =JDBCConnection(st);
                 out.println("JDBC CONNECTION ERROR");
             }
             
                 //registration(fname, lname, email, phn, pwd,op);
               //  out.println( registration(fname, lname, email, phn, pwd,op) );
                 rt = registration(fname, lname, email, phn, pwd,op);
           
         
          //   linkSendStatus = SendVerification.SendMail(email);
                 
            request.setAttribute("rt", rt);
            request.getRequestDispatcher("final.jsp").forward(request, response);
             
            /* request.setAttribute("jdbcSt", jdbcSt);
             request.getRequestDispatcher("final.jsp").forward(request, response);
            
            request.setAttribute("registerStatus", registerStatus);
            request.getRequestDispatcher("final.jsp").forward(request, response);
            
            if(flag==1)
              request.setAttribute("registerStatus", "register");
            request.getRequestDispatcher("final.jsp").forward(request, response);
              */
             
        }
    }

       
     private static String JDBCConnection(String st) 
        {
          
		try 
                    {
			Class.forName("com.mysql.jdbc.Driver");
		    } 
          
                catch (ClassNotFoundException e)
                    {
			e.printStackTrace();
			
                    }
 
		try 
                    {
			
			Conn = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12192611", "sql12192611", "XWch1xppLf");
			if (Conn != null)
                             {
                                                                                      /*-------Connection Successful*/
                             } 
                        
                        else {
                            st="Connection=null! [IN TRY]";
                             }
                    }
                catch (SQLException e) 
                    {
			e.printStackTrace();
                          st="ERROR! [IN CATCH]" ;
                       
                    }
                return st;
                       
	}
 
    
    
    private static String registration(String fname, String lname, String email, String phn, String pwd, String op) 
        {
 
            
       boolean stx =false;
      try{

			 ps =Conn.prepareStatement
                             ("select * from temp where email=?");
         ps.setString(1, email);
         
         
         
         ResultSet rs =ps.executeQuery();
         stx = rs.next();
         
         }
      catch(SQLException e)
      {
          e.printStackTrace();
      }
            
         if(stx){
                op="Email Already registered. Please Log In.";
           
            return op;
                    }
            
         else{
             
           SendVerification.SendMail(email);
                
            try {
                    String insertS = "INSERT  INTO  temp  VALUES  (?,?,?,?,?,?)";
 
			PrepareStat = Conn.prepareStatement(insertS);
			
                        PrepareStat.setString(1, fname);
			PrepareStat.setString(2, lname);
			PrepareStat.setString(3, email);
			PrepareStat.setString(4, phn);
			PrepareStat.setString(5, pwd);
			PrepareStat.setString(6, "0");
		
                        PrepareStat.executeUpdate();
                       op="A Activation Mail is send to your e-mail id. Check your e-mail and click on the link to Activate Your Registration.";
                   
                }
            catch (SQLException e) 
                {
			e.printStackTrace();
                        op="Error!";
                      
		}
             }
            return op;
	
        }
        
        
 
   
    
    
    
    
    
    
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
