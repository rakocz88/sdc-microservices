package com.pilaf.sdc.user.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pilaf.sdc.user.json.SimpleResponse;
import com.pilaf.sdc.user.json.UserJSON;
import com.pilaf.sdc.user.model.UserActivationCodeDO;
import com.pilaf.sdc.user.model.UserDO;
import com.pilaf.sdc.user.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserRestController {

	private UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping(value = "/all/{page}/{size}/{direction}/{sortField}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Page<UserDO> getAllUsers(@PathVariable("page") int page, @PathVariable("size") int size,
			@PathVariable("direction") String direction, @PathVariable("sortField") String sortField) {
		return userService.getAll(page, size, direction, sortField);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public UserDO saveUser(@RequestBody UserJSON userJSon) {
		return userService.createUser(new UserDO(userJSon));
	}

	@RequestMapping(value = "byLogin/{login}", method = RequestMethod.GET)
	public UserDO getUserByLogin(@PathVariable("login") String login) {

		return userService.findUserByLogin(login);
	}

	@RequestMapping(value = "register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserDO registerUser(@RequestBody UserJSON userJson) {
		return userService.registerUser(new UserDO(userJson));
	}

	@RequestMapping(value = "register/activate", method = RequestMethod.POST)
	public SimpleResponse activateUser(@RequestBody UserJSON userJson) {
		userService.activateUser(userJson.getId(), userJson.getActivateCode());
		return new SimpleResponse("User activated");
	}

	@RequestMapping(value = "code/{userid}", method = RequestMethod.GET)
	public List<UserActivationCodeDO> getCodesByUser(@PathVariable("userid") Long userid) {
		return userService.getActivationCodesByUserId(userid);
	}
}
