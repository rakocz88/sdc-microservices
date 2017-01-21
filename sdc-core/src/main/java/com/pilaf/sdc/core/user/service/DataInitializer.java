package com.pilaf.sdc.core.user.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pilaf.sdc.core.user.model.ContactDO;
import com.pilaf.sdc.core.user.model.UserDO;
import com.pilaf.sdc.core.user.model.security.PrivilegeDO;
import com.pilaf.sdc.core.user.model.security.Privileges;
import com.pilaf.sdc.core.user.model.security.RoleDO;
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
	PrivilegeDO usersPrivilege = new PrivilegeDO(Privileges.USER_PRIVILEGE);
	PrivilegeDO mailPrivilege = new PrivilegeDO(Privileges.MAIL_PRIVILEGE);

	RoleDO adminRole = new RoleDO("Admin");
	RoleDO userRole = new RoleDO("User");

	adminRole.setPrivileges(Arrays.asList(new PrivilegeDO[] { usersPrivilege, mailPrivilege }));
	userRole.setPrivileges(Arrays.asList(new PrivilegeDO[] { mailPrivilege }));

	UserDO admin = new UserDO("admin", "a", "Jan", "Ham", null, null, null, new ContactDO(null, "email@m.pl"));

	admin.setRoles(Arrays.asList(new RoleDO[] { adminRole }));
	admin.setActive(true);

	UserDO user = new UserDO("user", "a", "Jan", "Ham", null, null, null, new ContactDO(null, "email2@m.pl"));
	user.setRoles(Arrays.asList(new RoleDO[] { userRole }));
	user.setActive(true);

	userRepository.save(user);
	userRepository.save(admin);

    }

}
