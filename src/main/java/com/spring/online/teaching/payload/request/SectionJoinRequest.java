package com.spring.online.teaching.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SectionJoinRequest {

	@NotBlank
	@Size(min = 1, max = 20)
	private String unique_code;

	public SectionJoinRequest() {
	}

	public SectionJoinRequest(@NotBlank @Size(min = 1, max = 20) String unique_code) {
		super();
		this.unique_code = unique_code;
	}

	public String getUnique_code() {
		return unique_code;
	}

	public void setUnique_code(String unique_code) {
		this.unique_code = unique_code;
	}

	@Override
	public String toString() {
		return "SectionJoinRequest [unique_code=" + unique_code + "]";
	};

}
