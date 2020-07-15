package com.spring.online.teaching.payload.response;

public class ContentResponse {

	private long createId;
	private String content;
	private Long postId;
	private String postOption;
	private String schedule_date;
	private String schedule_time;

	public ContentResponse() {
	}

	public long getCreateId() {
		return createId;
	}

	public ContentResponse(long createId, long postId, String content, String postOption, String schedule_date,
			String schedule_time) {
		super();
		this.createId = createId;
		this.postId = postId;
		this.content = content;
		this.postOption = postOption;
		this.schedule_date = schedule_date;
		this.schedule_time = schedule_time;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public void setCreateId(long createId) {
		this.createId = createId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSchedule_date() {
		return schedule_date;
	}

	public void setSchedule_date(String schedule_date) {
		this.schedule_date = schedule_date;
	}

	public String getSchedule_time() {
		return schedule_time;
	}

	public void setSchedule_time(String schedule_time) {
		this.schedule_time = schedule_time;
	}

	public String getPostOption() {
		return postOption;
	}

	public void setPostOption(String postOption) {
		this.postOption = postOption;
	}

	@Override
	public String toString() {
		return "ContentResponse [createId=" + createId + ", content=" + content + ", postId=" + postId + ", postOption="
				+ postOption + ", schedule_date=" + schedule_date + ", schedule_time=" + schedule_time + "]";
	}

	

}
