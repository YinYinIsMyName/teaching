package com.spring.online.teaching.payload.response;

import com.spring.online.teaching.models.ERole;

public class MessageResponse {

	private String username;
	private ERole name;

	public MessageResponse() {
	}

	public MessageResponse(String username, ERole rolename) {
		super();
		this.username = username;
		this.name = rolename;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ERole getRolename() {
		return name;
	}

	public void setRolename(ERole rolename) {
		this.name = rolename;
	}

	@Override
	public String toString() {
		return "MessageResponse [username=" + username + ", rolename=" + name + "]";
	}

}
