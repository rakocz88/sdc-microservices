package com.pilaf.sdc.mail.json;

import java.io.Serializable;

import com.pilaf.sdc.mail.enums.MailResponseMsg;

public class MailResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3920963831736257212L;

	private MailResponseMsg response;

	public MailResponse() {
		super();
	}

	public MailResponse(MailResponseMsg response) {
		super();
		this.response = response;
	}

	public MailResponseMsg getResponse() {
		return response;
	}

	public void setResponse(MailResponseMsg response) {
		this.response = response;
	}

}
