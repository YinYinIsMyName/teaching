package com.spring.online.teaching.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post_comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id", unique = true, nullable = false)
	private long cId;
	@Column(name = "comment_text", nullable = false)
	private String commentText;
	@Column(name = "time")
	private String currentTime;
	@Column(name = "post_id")
	private long postId;
	@Column(name = "user_id")
	private long userId;

	public Comment() {
	}

	public Comment(String commentText, String currentTime, long postId, long userId) {
		super();
		this.commentText = commentText;
		this.currentTime = currentTime;
		this.postId = postId;
		this.userId = userId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Comment [cId=" + cId + ", commentText=" + commentText + ", currentTime=" + currentTime + ", postId="
				+ postId + ", userId=" + userId + "]";
	}

}
