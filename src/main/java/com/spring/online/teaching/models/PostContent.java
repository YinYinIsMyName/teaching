package com.spring.online.teaching.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "post_content")
public class PostContent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id", unique = true, nullable = false)
	private long post_id;
	@Column(name = "share_content", nullable = true)
	private String share_content;
	@Column(name = "post_option")
	private String postOption;
	@Column(name = "schedule_date")
	private String scheduleDate;
	@Column(name = "schedule_time")
	private String scheduleTime;
	@Column(name = "user_id")
	private long userId;
	@Column(name = "create_id")
	private long createId;
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "user_post_content", joinColumns = @JoinColumn(name = "post_id"), 
//	inverseJoinColumns = @JoinColumn(name = "user_id"))
	@JsonBackReference
	@OneToMany(mappedBy = "postcontent", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserPostContent> userIds = new HashSet<UserPostContent>();

	public PostContent() {
	}

	public PostContent(String share_content, String post_option, String schedule_date, String schedule_time,
			long createId, long userId) {
		super();
		this.share_content = share_content;
		this.postOption = post_option;
		this.scheduleDate = schedule_date;
		this.scheduleTime = schedule_time;
		this.createId = createId;
		this.userId = userId;
	}

	public long getPost_id() {
		return post_id;
	}

	public long getCreateId() {
		return createId;
	}

	public void setCreateId(long createId) {
		this.createId = createId;
	}

	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}

	public String getShare_content() {
		return share_content;
	}

	public void setShare_content(String share_content) {
		this.share_content = share_content;
	}

	public String getPostOption() {
		return postOption;
	}

	public void setPostOption(String post_option) {
		this.postOption = post_option;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String schedule_date) {
		this.scheduleDate = schedule_date;
	}

	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(String schedule_time) {
		this.scheduleTime = schedule_time;
	}

	public Set<UserPostContent> getUserIds() {
		return userIds;
	}

	public void setUserIds(Set<UserPostContent> userIds) {
		this.userIds = userIds;
	}

	@Override
	public String toString() {
		return "PostContent [post_id=" + post_id + ", share_content=" + share_content + ", postOption=" + postOption
				+ ", scheduleDate=" + scheduleDate + ", scheduleTime=" + scheduleTime + ", createId=" + createId
				+ ", userIds=" + userIds +"]";
	}

}
