package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Connections;

public class Posts {
	
	private String title;
	private String text;
	private int id;
	public Posts() {
		
	}
	public Posts(String title, String text, int id) {
		this.title = title;
		this.text = text;
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	public ArrayList<String> getPost(int id) {
		Connections conn = new Connections();
		Connection c= conn.getConnections();
		ArrayList<String> post;
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM posts where id = "+id+";");
			post = new ArrayList<String>();
			while(rs.next()) {
				post.add(rs.getString("title"));
				post.add(rs.getString("text"));
			}
			stmt.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return post;
	}
	public ArrayList<Posts> getPosts() {
		Connections conn = new Connections();
		Connection c= conn.getConnections();
		ArrayList<Posts> posts;
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM posts;");
			posts = new ArrayList<Posts>();
			while(rs.next()) {
				posts.add(new Posts(rs.getString("title"),rs.getString("text"),rs.getInt("id")));
			}
			stmt.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return posts;
	}
	/*select c.comments,u.name from comments c, posts p,users u where (c.id_post = 2) and (u.id = 6);*/
}
