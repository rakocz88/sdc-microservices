package com.pilaf.sdc.core.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pilaf.sdc.core.json.MailMsg;
import com.pilaf.sdc.core.user.model.UserActivationCodeDO;
import com.pilaf.sdc.core.user.model.UserDO;
import com.pilaf.sdc.core.user.model.security.RoleDO;
import com.pilaf.sdc.core.user.repository.UserActivationCodeRepository;
import com.pilaf.sdc.core.user.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private MailService mailService;
    private CodeGenerator codeGenerator;
    private UserActivationCodeRepository userActivationCodeRepository;

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

    @Autowired
    public UserService(UserRepository userRepository, MailService mailService, CodeGenerator codeGenerator,
	    UserActivationCodeRepository userActivationCodeRepository) {
	super();
	this.userRepository = userRepository;
	this.mailService = mailService;
	this.codeGenerator = codeGenerator;
	this.userActivationCodeRepository = userActivationCodeRepository;
    }

    // @PreAuthorize("hasAuthority('" + Privileges.ADMIN_PRIVILEGE + "') or
    // hasAuthority('" + Privileges.USER_PRIVILEGE
    // + "')")
    public Page<UserDO> getAll(int page, int size, String direction, String sortField) {
	PageRequest pageRequest = new PageRequest(page, size, Direction.fromString(direction), sortField);
	return userRepository.findAll(pageRequest);
    }

    // @PreAuthorize("hasAuthority('" + Privileges.ADMIN_PRIVILEGE + "') or
    // hasAuthority('" + Privileges.USER_PRIVILEGE
    // + "')")
    public UserDO createUser(UserDO userDo) {
	return userRepository.save(userDo);
    }

    // @PreAuthorize("hasAuthority('" + Privileges.ADMIN_PRIVILEGE + "') or
    // hasAuthority('" + Privileges.USER_PRIVILEGE
    // + "')")
    public UserDO findActiveUserByLogin(String userLogin) {
	UserDO user = userRepository.findByLogin(userLogin);
	return user;
    }

    public UserDO registerUser(UserDO userDO) {
	userRepository.save(userDO);
	String code = codeGenerator.generateCode();
	MailMsg mailMsg = new MailMsg(code, "Witamy w SDC", userDO.getContact().getEmailAddress(), 1l);
	mailService.sendMail(mailMsg);
	userActivationCodeRepository.save(new UserActivationCodeDO(code, userDO));
	return userDO;
    }

    public String activateUser(Long userId, String requestCode) {
	UserDO userDO = userRepository.findOne(userId);
	String response = "Wrong code";
	List<UserActivationCodeDO> codesForUser = userActivationCodeRepository.findByUser(userDO);
	List<UserActivationCodeDO> filteredCodes = codesForUser.stream()
		.filter(activationCode -> requestCode.equals(activationCode.getCode()))
		.filter(activationCode -> activationCode.isTerminated() == false).collect(Collectors.toList());
	if (filteredCodes.size() > 0) {
	    userDO.setActive(true);
	    codesForUser.stream().forEach(code -> terminateCode(code));
	    response = "User activated.";
	}
	return response;
    }

    private void terminateCode(UserActivationCodeDO code) {
	code.setTerminated(true);
	userActivationCodeRepository.save(code);
    }

    public List<UserActivationCodeDO> getActivationCodesByUserId(Long userid) {
	UserDO user = userRepository.findOne(userid);
	return userActivationCodeRepository.findByUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	UserDO userDo = findActiveUserByLogin(username);
	User user = new User(userDo.getLogin(), userDo.getPassword(), userDo.isActive(), true, true, true,
		getAuthorities(userDo.getRoles()));
	detailsChecker.check(user);
	return user;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(List<RoleDO> roles) {
	List<GrantedAuthority> authorities = new ArrayList<>();
	for (RoleDO role : roles) {
	    List<GrantedAuthority> newAuthoritiesList = role.getPrivileges().parallelStream()
		    .map(privilege -> new SimpleGrantedAuthority(privilege.getName())).collect(Collectors.toList());
	    authorities.addAll(newAuthoritiesList);
	}

	return authorities;
    }

}
