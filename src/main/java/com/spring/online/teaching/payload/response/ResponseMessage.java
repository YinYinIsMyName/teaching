package com.spring.online.teaching.payload.response;

public class ResponseMessage {

	private String msg = null;
	private Boolean isTrue = true;

	public ResponseMessage() {
	}

	public ResponseMessage(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Boolean getIsTrue() {
		return isTrue;
	}

	public void setIsTrue(Boolean isTrue) {
		this.isTrue = isTrue;
	}

	@Override
	public String toString() {
		return "ResponseMessage [msg=" + msg + ", isTrue=" + isTrue + "]";
	}
}
