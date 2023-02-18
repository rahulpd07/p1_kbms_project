package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.config.DatabaseConnection;

public class ProductValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductValidation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String id = request.getParameter("txt");
		PrintWriter out = response.getWriter();
		
		out.print(id);

		Connection con = DatabaseConnection.getConnection();

		boolean flag = true;
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select PRODUCT_ID from Product;");
			while (rs.next()) {
				if (id.equals(rs.getString(1))) {
					flag = false;
					request.setAttribute("ID", id);
					/*
					 * RequestDispatcher rd =(RequestDispatcher)
					 * request.getRequestDispatcher("ItemShow.jsp"); rd.forward(request, response);
					 */
					request.setAttribute("ID", id);
					request.getRequestDispatcher("ItemShow.jsp").forward(request, response);
				}
			}
			if (flag == true) {
				
				RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("/login.html");
				rd.forward(request, response);

			}

		} catch (Exception e) {
			out.print("product validation inside catch");
			e.getMessage();
		}

	}

}
