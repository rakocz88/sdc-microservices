package com.pilaf.sdc.user.json;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.pilaf.sdc.user.model.AddressDO;
import com.pilaf.sdc.user.model.ContactDO;
import com.pilaf.sdc.user.model.UserDO;
import com.pilaf.sdc.user.model.UserType;

public class UserJSON implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6486594618665001529L;

	private Long id;

	private String login;

	private String password;

	private String firstName;

	private String surname;

	private LocalDate birthDate;

	private AddressDO address;

	private List<UserType> userType;

	private ContactDO contact;

	public UserJSON() {
		super();
	}

	public UserJSON(String login, String password, String firstName, String surname, LocalDate birthDate,
			AddressDO address, List<UserType> userType, ContactDO contact) {
		super();
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.surname = surname;
		this.birthDate = birthDate;
		this.address = address;
		this.userType = userType;
		this.contact = contact;
	}

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public AddressDO getAddress() {
		return address;
	}

	public void setAddress(AddressDO address) {
		this.address = address;
	}

	public List<UserType> getUserType() {
		return userType;
	}

	public void setUserType(List<UserType> userType) {
		this.userType = userType;
	}

	public ContactDO getContact() {
		return contact;
	}

	public void setContact(ContactDO contact) {
		this.contact = contact;
	}

}