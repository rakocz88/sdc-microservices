package com.pilaf.sdc.user.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pilaf.sdc.user.model.UserDO;
import com.pilaf.sdc.user.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public Page<UserDO> getAll(int page, int size, String direction, String sortField) {
		PageRequest pageRequest = new PageRequest(page, size, Direction.fromString(direction), sortField);
		return userRepository.findAll(pageRequest);
	}

	public UserDO createUser(UserDO userDo) {
		return userRepository.save(userDo);
	}

	public UserDO findUserByLogin(String userLogin) {
		return userRepository.findByLogin(userLogin);
	}

	public UserDO registerUser(UserDO userDO) {
		restTe
		return null;
	}

}
