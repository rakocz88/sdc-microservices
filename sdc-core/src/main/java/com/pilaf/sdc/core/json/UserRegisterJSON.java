package com.pilaf.sdc.core.json;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.pilaf.sdc.core.user.model.AddressDO;
import com.pilaf.sdc.core.user.model.ContactDO;
import com.pilaf.sdc.core.user.model.UserDO;
import com.pilaf.sdc.core.user.model.UserType;

public class UserRegisterJSON implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6486594618665001529L;

    private Long id;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String surname;

    @NotNull
    private LocalDate birthDate;

    private AddressDO address;

    private List<UserType> userType;

    private ContactDO contact;

    private List<String> roles;

    public UserRegisterJSON() {
	super();
    }

    public UserRegisterJSON(String login, String password, String firstName, String surname, LocalDate birthDate,
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

    public UserRegisterJSON(UserDO user) {
	this.id = user.getId();
	this.login = user.getLogin();
	this.password = user.getPassword();
	this.firstName = user.getFirstName();
	this.surname = user.getSurname();
	this.birthDate = user.getBirthDate();
	this.address = user.getAddress();
	this.userType = user.getUserType();
	this.contact = user.getContact();
	this.roles = (user.getRoles() == null) ? null
		: user.getRoles().parallelStream().map(role -> role.getName()).collect(Collectors.toList());
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

    public List<String> getRoles() {
	return roles;
    }

    public void setRoles(List<String> roles) {
	this.roles = roles;
    }

}
