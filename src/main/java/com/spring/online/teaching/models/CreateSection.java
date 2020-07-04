package com.spring.online.teaching.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "create_sections")
public class CreateSection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "create_section_id", unique = true, nullable = false)
	private long create_section_id;
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "create_section_uniquecode")
	private String uniqueKey;
	@Column(name = "classname", nullable = false)
	private String classname;
	@Column(name = "section")
	private String section;
	@Column(name = "room")
	private String room;
	@Column(name = "subject")
	private String subject;
	@Column(name = "stream")
	private int stream;
	@Column(name = "show_items")
	private boolean show_items;
	@Column(name = "get_time")
	private String currentTime;

	public CreateSection() {
	}

	public CreateSection(int user_id, String uniquekey, String classname, String subject, String room, String section,
			int stream, boolean show_items, String currentTime) {
		super();
		this.user_id = user_id;
		this.uniqueKey = uniquekey;
		this.classname = classname;
		this.subject = subject;
		this.room = room;
		this.section = section;
		this.stream = stream;
		this.show_items = show_items;
		this.currentTime = currentTime;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUniquekey() {
		return uniqueKey;
	}

	public void setUniquekey(String uniquekey) {
		this.uniqueKey = uniquekey;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getStream() {
		return stream;
	}

	public void setStream(int stream) {
		this.stream = stream;
	}

	public boolean isShow_items() {
		return show_items;
	}

	public void setShow_items(boolean show_items) {
		this.show_items = show_items;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	@Override
	public String toString() {
		return "CreateSection [user_id=" + user_id + ", uniquekey=" + uniqueKey + ", classname=" + classname
				+ ", section=" + section + ", room=" + room + ", subject=" + subject + ", stream=" + stream
				+ ", show_items=" + show_items + ", currentTime=" + currentTime + "]";
	}

}
