package org.khshrd.app.model;

public class User {
	private int id;
	private String Username;
	private String password;
	private String gender;
	private String email;
	private String phone;
	private String addres;
	public User(){
		
	}
	public User(int id,String username,String gender, String email, String phone, String addres) {
		super();
		this.id=id;
		Username = username;
		this.gender=gender;
		this.email = email;
		this.phone = phone;
		this.addres = addres;
		
	}
	public String getGender(){
		return gender;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	
}
