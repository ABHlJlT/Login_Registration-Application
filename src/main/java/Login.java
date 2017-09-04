
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

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Abhijit
 */
@WebServlet(urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	static Connection con = null;
	static PreparedStatement ps = null;
	static String op;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String output = "";
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("email");
			String pwd = request.getParameter("pwd");

			if (checkLogin(email, pwd)) {
				output = "Login Successful.  Hello ".concat(op);
			} else {
				output = "Login Failed. Invalid Email or Password!";
			}

			request.setAttribute("output", output);
			request.getRequestDispatcher("final.jsp").forward(request, response);

		}

	}

	public static boolean checkLogin(String email, String pwd) {
		boolean st = false;
		try {

			// loading drivers for mysql
			Class.forName("com.mysql.jdbc.Driver");

			// creating connection with the database
			con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12192611", "sql12192611",
					"XWch1xppLf");
			ps = con.prepareStatement("select * from temp where email=? and pwd=? and verify=?");
			ps.setString(1, email);
			ps.setString(2, pwd);
			ps.setString(3, "1");

			ResultSet rs = ps.executeQuery();
			st = rs.next();
			op = rs.getString("fname");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return st;
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
	}

}
