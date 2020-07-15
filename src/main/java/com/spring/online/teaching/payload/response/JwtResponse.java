package com.spring.online.teaching.payload.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> role;
	private int userId;

	public JwtResponse(String token, String username, String password, int userId,
			Collection<? extends GrantedAuthority> role) {
		super();
		this.token = token;
		this.username = username;
		this.password = password;
		this.role = role;
		this.userId = userId;
	}
    
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Collection<? extends GrantedAuthority> getRole() {
		return role;
	}

	public void setRole(Collection<? extends GrantedAuthority> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", userId=" + userId + "]";
	}

}
