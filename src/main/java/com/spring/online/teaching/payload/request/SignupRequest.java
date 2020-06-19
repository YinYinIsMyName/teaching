package com.spring.online.teaching.payload.request;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class SignupRequest {

	@NotBlank
	private String name;
	@NotBlank
	private String email;
	@NotBlank
	private String password;

	@NotBlank
	private String confirm_password;
	private int role_id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

}
