package com.pilaf.sdc.core.user.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class UserActivationCodeDO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String code;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotNull
    private UserDO user;

    private boolean terminated;

    public UserActivationCodeDO() {
	super();
    }

    public UserActivationCodeDO(String code, UserDO user) {
	super();
	this.code = code;
	this.user = user;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public UserDO getUser() {
	return user;
    }

    public void setUser(UserDO user) {
	this.user = user;
    }

    public boolean isTerminated() {
	return terminated;
    }

    public void setTerminated(boolean terminated) {
	this.terminated = terminated;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((code == null) ? 0 : code.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + (terminated ? 1231 : 1237);
	result = prime * result + ((user == null) ? 0 : user.hashCode());
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
	UserActivationCodeDO other = (UserActivationCodeDO) obj;
	if (code == null) {
	    if (other.code != null)
		return false;
	} else if (!code.equals(other.code))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (terminated != other.terminated)
	    return false;
	if (user == null) {
	    if (other.user != null)
		return false;
	} else if (!user.equals(other.user))
	    return false;
	return true;
    }

}
