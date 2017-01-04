package com.pilaf.sdc.core.user.service;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.pilaf.sdc.core.user.model.PrivilegeDO;
import com.pilaf.sdc.core.user.model.Privileges;
import com.pilaf.sdc.core.user.model.RoleDO;
import com.pilaf.sdc.core.user.model.Roles;
import com.pilaf.sdc.core.user.model.UserDO;
import com.pilaf.sdc.core.user.repository.PrivilegesRepository;
import com.pilaf.sdc.core.user.repository.RoleRepository;
import com.pilaf.sdc.core.user.repository.UserRepository;

@Component
@Transactional
// TODO add profile
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;

    @Autowired
    public DataInitializer(UserRepository userRepository, RoleRepository roleRepository,
	    PrivilegesRepository privilegesRepository) {
	super();
	this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
	PrivilegeDO usersPrivilege = new PrivilegeDO(Privileges.USERS.name());
	PrivilegeDO mailPrivilege = new PrivilegeDO(Privileges.MAIL.name());
	PrivilegeDO testPrivilege = new PrivilegeDO(Privileges.TEST.name());

	RoleDO adminRole = new RoleDO(Roles.ADMIN.name());
	RoleDO userRole = new RoleDO(Roles.USER.name());

	adminRole.setPrivileges(Arrays.asList(new PrivilegeDO[] { usersPrivilege, mailPrivilege, testPrivilege }));
	userRole.setPrivileges(Arrays.asList(new PrivilegeDO[] { mailPrivilege, testPrivilege }));

	UserDO admin = new UserDO("admin", "a");
	admin.setRoles(Arrays.asList(new RoleDO[] { adminRole }));
	admin.setActive(true);

	UserDO user = new UserDO("user", "a");
	user.setRoles(Arrays.asList(new RoleDO[] { userRole }));
	user.setActive(true);

	userRepository.save(user);
	userRepository.save(admin);

    }

}
