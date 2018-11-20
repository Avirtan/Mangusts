package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connections  c;
	private Connection conn;
	private Statement stmt;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession se = request.getSession(true);
		if(se.getAttribute("user") != null) {
			request.getRequestDispatcher("WEB-INF/Index.jsp").forward(request, response);
		}else 
			request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		String l,p;
		c= new Connections();
		int id = 0;
		HttpSession se = request.getSession(true);
		conn = c.getConnections();
		boolean f = false;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users;");
			while(rs.next()) {
				l = rs.getString("login").trim().toString();
				p = rs.getString("password").trim().toString();
				if(login.equals(l) && pass.equals(p)) {
					id = rs.getInt("id");
					f = true;
					break;
				}
			}
			if(f) {
				if(se.getAttribute("user") == null) {
					se.setAttribute("user", login);
					se.setAttribute("id_user",id);
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(f) {
			response.sendRedirect(request.getContextPath()+"/Index");
		}
		else {
			request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
		}
	}

}
