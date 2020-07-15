package com.spring.online.teaching.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = "name"),
		@UniqueConstraint(columnNames = "email"), @UniqueConstraint(columnNames = "password"),
		@UniqueConstraint(columnNames = "confirm_password") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	private int userId;
	private String name;
	private String email;
	private String password;
	private String confirm_password;
	private int role_id;
//	@JsonBackReference
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
//	private Role role;
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<UserPostContent> userIds = new HashSet<UserPostContent>();

	public User() {
	}

	public User(String name, String email, String password, String confirm_password, int role_id) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirm_password = confirm_password;
		this.role_id = role_id;
	}

	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int user_id) {
		this.userId = user_id;
	}

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

//	public Set<UserPostContent> getUserIds() {
//		return userIds;
//	}
//
//	public void setUserIds(Set<UserPostContent> userIds) {
//		this.userIds = userIds;
//	}

	@Override
	public String toString() {
		return "User [user_id=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", confirm_password=" + confirm_password + ", role_id=" + role_id + "]";
	}

}
