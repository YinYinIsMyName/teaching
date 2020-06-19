package com.spring.online.teaching.payload.response;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String username;
	private String password;

	public JwtResponse(String token, String username, String password) {
		super();
		this.token = token;
		this.username = username;
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + ", username=" + username + ", password=" + password + "]";
	}
	

}
