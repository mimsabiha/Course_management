package cse.web.bean;

public class User {
	
	private int id;
	private String user_name;
	private String full_name;
	private String type;
	private String pass_word;
	
	
	
	public User(int id, String user_name, String full_name, String type, String pass_word) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.full_name = full_name;
		this.type = type;
		this.pass_word = pass_word;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	
	
	
	
	
	
	
	
	
	

}
