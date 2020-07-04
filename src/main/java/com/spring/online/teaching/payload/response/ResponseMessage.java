package com.spring.online.teaching.payload.response;

public class ResponseMessage {

	private String msg = null;

	public ResponseMessage(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ResponseMessage [msg=" + msg + "]";
	}

}
