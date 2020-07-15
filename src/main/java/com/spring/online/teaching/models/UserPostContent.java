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
	@JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
	public Tag tag;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id", referencedColumnName = "post_id")
	public PostContent postcontent;

//	@Column(name = "unique_key")
//	public String uniqueKey;

	public UserPostContent() {
	}

	public UserPostContent(Tag tag) {
		super();
		this.tag = tag;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag= tag;
	}

	public PostContent getPostcontent() {
		return postcontent;
	}

	public void setPostcontent(PostContent postcontent) {
		this.postcontent = postcontent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((postcontent == null) ? 0 : postcontent.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
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
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserPostContent [id=" + id + ", user=" + tag + ", postcontent=" + postcontent + "]";
	}

	

	

}
