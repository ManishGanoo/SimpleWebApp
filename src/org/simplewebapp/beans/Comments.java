package org.simplewebapp.beans;

public class Comments {
	private int Id;
	private int PostId;
	private String Name;
	private String Email;
	private String Body;
	
	public Comments() {
		
	}
	
	public Comments (int id, int postid, String name, String email, String body) {
		this.Id = id;
		this.PostId = postid;
		this.Name = name;
		this.Email = email;
		this.Body = body;
	}
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		this.Id = id;
	}
	
	public int getPostId() {
		return PostId;
	}
	
	public void setPostId(int postid) {
		this.PostId = postid;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		this.Email = email;
	}
	
	public String getBody() {
		return Body;
	}
	
	public void setBody(String body) {
		this.Body = body;
	}
}
