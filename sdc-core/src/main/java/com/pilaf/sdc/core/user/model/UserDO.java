package com.pilaf.sdc.core.user.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.pilaf.sdc.core.json.UserJSON;

@Entity
@Table(name = "SDCUser")
public class UserDO {

    /**
     * 
     */
    private static final long serialVersionUID = -9057454444230924105L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;

    private String password;

    private String firstName;

    private String surname;

    private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressDO address;

    @ElementCollection(targetClass = UserType.class)
    @Enumerated(EnumType.STRING)
    private List<UserType> userType;

    @OneToOne(cascade = CascadeType.ALL)
    private ContactDO contact;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "User_role", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id"))
    private List<RoleDO> roles;

    private boolean active;

    public UserDO() {
	super();
    }

    public UserDO(UserJSON userJson) {
	super();
	this.login = userJson.getLogin();
	this.password = userJson.getPassword();
	this.firstName = userJson.getFirstName();
	this.surname = userJson.getSurname();
	this.userType = userJson.getUserType();
	this.birthDate = userJson.getBirthDate();
	this.contact = userJson.getContact();
	this.address = userJson.getAddress();
    }

    public UserDO(String login) {
	super();
	this.login = login;
    }

    public UserDO(String login, String password) {
	super();
	this.login = login;
	this.password = password;
    }

    public UserDO(String login, String password, String firstName, String surname, LocalDate birthDate,
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

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }

    public List<RoleDO> getRoles() {
	return roles;
    }

    public void setRoles(List<RoleDO> roles) {
	this.roles = roles;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (active ? 1231 : 1237);
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
	result = prime * result + ((contact == null) ? 0 : contact.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((login == null) ? 0 : login.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((surname == null) ? 0 : surname.hashCode());
	result = prime * result + ((userType == null) ? 0 : userType.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	UserDO other = (UserDO) obj;
	if (active != other.active)
	    return false;
	if (address == null) {
	    if (other.address != null)
		return false;
	} else if (!address.equals(other.address))
	    return false;
	if (birthDate == null) {
	    if (other.birthDate != null)
		return false;
	} else if (!birthDate.equals(other.birthDate))
	    return false;
	if (contact == null) {
	    if (other.contact != null)
		return false;
	} else if (!contact.equals(other.contact))
	    return false;
	if (firstName == null) {
	    if (other.firstName != null)
		return false;
	} else if (!firstName.equals(other.firstName))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (login == null) {
	    if (other.login != null)
		return false;
	} else if (!login.equals(other.login))
	    return false;
	if (password == null) {
	    if (other.password != null)
		return false;
	} else if (!password.equals(other.password))
	    return false;
	if (surname == null) {
	    if (other.surname != null)
		return false;
	} else if (!surname.equals(other.surname))
	    return false;
	if (userType == null) {
	    if (other.userType != null)
		return false;
	} else if (!userType.equals(other.userType))
	    return false;
	return true;
    }

}
