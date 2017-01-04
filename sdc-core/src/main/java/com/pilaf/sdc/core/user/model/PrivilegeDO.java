package com.pilaf.sdc.core.user.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class PrivilegeDO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "privileges", cascade = CascadeType.ALL)
    private List<RoleDO> roles;

    public PrivilegeDO() {
	super();
    }

    public PrivilegeDO(String name) {
	super();
	this.name = name;
    }

    public PrivilegeDO(String name, List<RoleDO> roles) {
	super();
	this.name = name;
	this.roles = roles;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<RoleDO> getRoles() {
	return roles;
    }

    public void setRoles(List<RoleDO> roles) {
	this.roles = roles;
    }

}
