package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Reg")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connections  c;
	private Connection conn;
	private Statement stmt;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*ResultSet rs = stmt.executeQuery("SELECT * FROM comments  INNER  JOIN  users ON users.id = comments.id_user where users.id = 6;");
		while(rs.next())
			System.out.println(rs.getString("comments")+rs.getString("id_user"));*/
		request.getRequestDispatcher("WEB-INF/registration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String login = request.getParameter("login");
		String pass_1 = request.getParameter("pass_1");
		String pass_2 = request.getParameter("pass_2");
		boolean flag = true; 
		ArrayList<String> error  = new ArrayList<String>();
		c= new Connections();
		conn = c.getConnections();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users;");
			while(rs.next()) {
				String log = rs.getString("login").trim();
				if(log.equals(login))
				{
					flag = false;
					break;
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(login.length() >= 5  && pass_1.length() >= 5 && pass_1.equals(pass_2) && flag) {
			try {
				stmt.executeUpdate("Insert into users (login,password) Values ('"+ login +"','"+ pass_1+"');");
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("WEB-INF/registration.jsp").forward(request, response);
				return;
			}
			request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
		}else {
			if(!flag) {
				error.add("Логин уже существует");
			}
			if(login.length() < 5)
				error.add("Логин > 5");
			if(pass_1.length() < 5)
				error.add("Пароль > 5");
			if(!pass_1.equals(pass_2))
				error.add("Пароли не совпадают");
			request.setAttribute("error", error);
			request.getRequestDispatcher("WEB-INF/registration.jsp").forward(request, response);
		}
		
	}

}
