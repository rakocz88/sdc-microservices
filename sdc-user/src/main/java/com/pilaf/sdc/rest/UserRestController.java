package com.pilaf.sdc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pilaf.sdc.model.UserDO;
import com.pilaf.sdc.repository.UserRepository;

@Controller
public class UserRestController {

	@Autowired
	private UserRepository repository;
	
	

	@RequestMapping("/")
	@ResponseBody
	public String helloWorld() {
		UserDO user = new UserDO();
		user.setLogin("dupa2");
		user.setPassword("dupa2");
		repository.save(user);
		
		return user.toString();
	}

}
