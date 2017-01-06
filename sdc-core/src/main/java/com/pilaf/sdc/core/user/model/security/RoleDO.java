package com.pilaf.sdc.core.user.model.security;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.pilaf.sdc.core.user.model.UserDO;

@Entity
public class RoleDO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserDO> users;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Role_Privilege", joinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilegeId", referencedColumnName = "id"))
    private List<PrivilegeDO> privileges;

    public RoleDO() {
	super();
    }

    public RoleDO(String name) {
	super();
	this.name = name;
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

    public List<UserDO> getUsers() {
	return users;
    }

    public void setUsers(List<UserDO> users) {
	this.users = users;
    }

    public List<PrivilegeDO> getPrivileges() {
	return privileges;
    }

    public void setPrivileges(List<PrivilegeDO> privileges) {
	this.privileges = privileges;
    }

}
