package com.pilaf.sdc.user.json;

import java.io.Serializable;

public class SimpleResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2621573373711679574L;
	private String responseString;

	public SimpleResponse() {
		super();
	}

	public SimpleResponse(String responseString) {
		super();
		this.responseString = responseString;
	}

	public String getResponseString() {
		return responseString;
	}

	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}

}
