package com;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comment;
import model.Posts;
import model.User;
/**
 * Servlet implementation class Post
 */
@WebServlet("/Post")
public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Post() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.id  = Integer.parseInt(request.getParameter("p"));
			ArrayList<String> post = new Posts().getPost(id);
			request.setAttribute("title", post.get(0));
			request.setAttribute("text", post.get(1));
			ArrayList<String> comments = new Comment().getComments(id);
			ArrayList<Integer> users_id = new Comment().getUsers(id);
			ArrayList<String> users_name = new ArrayList<String>();
			for(Integer user_id: users_id) {
				users_name.add( new User().getName(user_id));
			}
			ArrayList<String []> users_comments = new ArrayList<String[]>();
			for(int i = 0 ; i < comments.size();i++) {
				String[] user_comment = new String[2];
				user_comment[0] = users_name.get(i);
				user_comment[1] = comments.get(i);
				users_comments.add(i,user_comment);
			}
			request.setAttribute("users_comments", users_comments);
		}catch(Exception ex){
			ex.getMessage();
		}
		request.getRequestDispatcher("WEB-INF/Post.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String comm  = request.getParameter("comm");
		if(comm.length() < 5) {
			response.sendRedirect(request.getContextPath()+"/Post?p="+this.id);
		}else{
			HttpSession se = request.getSession(true);
			int id  = Integer.parseInt(se.getAttribute("id_user").toString());
			new Comment().AddComment(comm, id, this.id);
			response.sendRedirect(request.getContextPath()+"/Post?p="+this.id);
		}
		}
		
	}
