package com.spring.online.teaching.payload.response;

import com.spring.online.teaching.models.ERole;

public class RoleResponse {

	private String username;
	private ERole role_name;
	private String password;
    private int userId;
	public RoleResponse() {
	}

	public RoleResponse(int userId,String username, ERole role_name,String password) {
		super();
		this.username = username;
		this.role_name = role_name;
		this.password = password;
		this.userId= userId;
	}
   
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ERole getRole_name() {
		return role_name;
	}

	public void setRole_name(ERole role_name) {
		this.role_name = role_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RoleResponse [username=" + username + ", role_name=" + role_name + ", password=" + password + "]";
	}

	
    
}
