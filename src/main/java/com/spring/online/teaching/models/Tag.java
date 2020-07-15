package com.spring.online.teaching.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tag")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tag_id", unique = true, nullable = false)
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "unique_code")
	private String uniqueCode;

	public Tag() {
	}

	public Tag(String username, String uniqueCode) {
		super();
		this.username = username;
		this.uniqueCode = uniqueCode;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	@Override
	public String toString() {
		return "Tag [username=" + username + ", uniqueCode=" + uniqueCode + "]";
	}

}