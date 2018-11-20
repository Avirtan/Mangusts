package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Connections;

public class Comment {

	private String title,text;
	public Comment() {
		
	}
	public Comment(String title,String text) {
		this.title = title;
		this.text = text;
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
	public void AddComment(String text, int id_user, int id_post) {
		Connections conn = new Connections();
		Connection c= conn.getConnections();
		try {
			Statement stmt = c.createStatement();
			stmt.executeUpdate("Insert into comments (comment,id_user,id_post) Values ('"+ text +"','"+ id_user +"','"+ id_post+"');");
			stmt.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<String> getComments(int id){
		
		Connections conn = new Connections();
		Connection c= conn.getConnections();
		ArrayList<String> comment;
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT comment FROM comments where id_post = "+id+";");
			comment = new ArrayList<String>();
			while(rs.next()) {
				comment.add(rs.getString("comment"));
			}
			stmt.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return comment;
	}
public ArrayList<Integer> getUsers(int id){
		
		Connections conn = new Connections();
		Connection c= conn.getConnections();
		ArrayList<Integer> comment;
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id_user FROM comments where id_post = "+id+";");
			comment = new ArrayList<Integer>();
			while(rs.next()) {
				comment.add(rs.getInt("id_user"));
			}
			stmt.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return comment;
	}
}
