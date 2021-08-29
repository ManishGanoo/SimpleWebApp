package org.simplewebapp.beans;

public class Posts{
	private int Id;
	private int UserId;
	private String Title;
	private String Body;
	
	public Posts() {
		
	}
	
	public Posts (int id, int userid, String title, String body) {
		this.Id = id;
		this.UserId = userid;
		this.Title = title;
		this.Body = body;
	}
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		this.Id = id;
	}
	
	public int getUserId() {
		return UserId;
	}
	
	public void setUserId(int userid) {
		this.UserId = userid;
	}
	
	public String getTitle() {
		return Title;
	}
	
	public void setTitle(String title) {
		this.Title = title;
	}
	
	public String getBody() {
		return Body;
	}
	
	public void setBody(String body) {
		this.Body = body;

	}
	
}
