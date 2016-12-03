package com.pilaf.sdc.json;

import java.io.Serializable;

import com.pilaf.sdc.model.UserDO;

public class UserJSON implements Serializable {

	private Long id;

	private String login;

	private String password;

	public UserJSON() {
		super();
	}

	public UserJSON(Long id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public UserJSON(UserDO userDO) {
		super();
		this.id = userDO.getId();
		this.login = userDO.getLogin();
		this.password = userDO.getPassword();
	}

}
