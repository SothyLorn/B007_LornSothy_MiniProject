package org.khshrd.app.model;

public class User {
	private int uid;
	private String username;
	private String pass;
	private String gender;
	private String email;
	private String phone;
	private String address;
	private String hashcode;
	public User(){
		
	}
	public User(int uid,String username,String pass,String gender, String email, String phone, String address,String hashcode) {
		super();
		this.uid=uid;
		this.username = username;
		this.pass=pass;
		this.gender=gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hashcode=hashcode;
		
	}
	public String getHashcode(){
		return hashcode;
	}
	public void setUser_has(String hashcode){
		this.hashcode=hashcode;
	}
	public String getGender(){
		return gender;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	public int getUid() {
		return uid;
	}
	public void setId(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String password) {
		this.pass = password;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
