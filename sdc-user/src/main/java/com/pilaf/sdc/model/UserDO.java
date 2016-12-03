package com.pilaf.sdc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SDCUser")
public class UserDO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9057454444230924105L;

	// docker exec backend_user_1 env

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String login;

	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "User [id=" + getId() + ", login=" + login + ", password=" + password + "]";
	}

}
