package com.pilaf.sdc.core.json;

import java.io.Serializable;

public class MailMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8762956063121045398L;

	private String msg;

	private String recipent;

	private Long sender;

	public MailMsg() {
		super();
	}

	public MailMsg(String msg, String recipent, Long sender) {
		super();
		this.msg = msg;
		this.recipent = recipent;
		this.sender = sender;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRecipent() {
		return recipent;
	}

	public void setRecipent(String recipent) {
		this.recipent = recipent;
	}

	public Long getSender() {
		return sender;
	}

	public void setSender(Long sender) {
		this.sender = sender;
	}

}
