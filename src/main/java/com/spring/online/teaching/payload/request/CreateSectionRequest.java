package com.spring.online.teaching.payload.request;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateSectionRequest {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();  
    String formattedDate = dtf.format(now);
	@NotBlank
	@Size(min = 3, max = 50)
	private String classname;
	@Size(min = 1, max = 20)
	private String section;
	@Size(min = 3, max = 50)
	private String subject;
	@Size(min = 3, max = 50)
	private String room;
	private String unique_code;
	private int stream = 1;
	private boolean show_items = false;
	private String date_time = formattedDate;

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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getUnique_code() {
		return unique_code;
	}

	public void setUnique_code(String unique_code) {
		this.unique_code = unique_code;
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

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	@Override
	public String toString() {
		return "CreateSectionRequest [now=" + now + ", classname=" + classname + ", section=" + section + ", subject="
				+ subject + ", room=" + room + ", unique_code=" + unique_code + ", stream=" + stream + ", show_items="
				+ show_items + ", date_time=" + date_time + "]";
	}

	

}
