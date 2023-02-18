package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.config.DatabaseConnection;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection con = DatabaseConnection.getConnection();
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		boolean flag=true;             
		try {
			Statement stm = con.createStatement();			
			ResultSet rs = stm.executeQuery("select user_id,password from Admin;");
			while(rs.next()) {
				if(userid.equals(rs.getString(1))&& password.equals(rs.getString(2))) {
					flag=false;
					RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("/main.html");
					rd.forward(request, response);
				}
			}
			if(flag==true) {
				out.print("Invalid userid and password");
				RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("/login.html");
				rd.forward(request, response);
				
			}
			
		}catch(Exception e) {
			out.print("inside catch");
			e.getMessage();		
		}
		
	}

}
