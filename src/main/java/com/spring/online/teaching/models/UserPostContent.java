package com.spring.online.teaching.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_post_content")
public class UserPostContent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	public User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id", referencedColumnName = "post_id")
	public PostContent postcontent;

	@Column(name = "unique_key")
	public String uniqueKey;

	public UserPostContent() {
	}

	public UserPostContent(User user, String uniqueKey) {
		super();
		this.user = user;
		this.uniqueKey = uniqueKey;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PostContent getPostcontent() {
		return postcontent;
	}

	public void setPostcontent(PostContent postcontent) {
		this.postcontent = postcontent;
	}

	public String getUniquekey() {
		return uniqueKey;
	}

	public void setUniquekey(String uniquekey) {
		this.uniqueKey = uniquekey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((postcontent == null) ? 0 : postcontent.hashCode());
		result = prime * result + ((uniqueKey == null) ? 0 : uniqueKey.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPostContent other = (UserPostContent) obj;
		if (id != other.id)
			return false;
		if (postcontent == null) {
			if (other.postcontent != null)
				return false;
		} else if (!postcontent.equals(other.postcontent))
			return false;
		if (uniqueKey == null) {
			if (other.uniqueKey != null)
				return false;
		} else if (!uniqueKey.equals(other.uniqueKey))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserPostContent [id=" + id + ", user=" + user + ", postcontent=" + postcontent + ", unique_key="
				+ uniqueKey + "]";
	}

}
