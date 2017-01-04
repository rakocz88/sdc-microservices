package com.pilaf.sdc.core.user.rest;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pilaf.sdc.core.json.SimpleResponse;
import com.pilaf.sdc.core.json.UserJSON;
import com.pilaf.sdc.core.user.model.Privileges;
import com.pilaf.sdc.core.user.model.UserActivationCodeDO;
import com.pilaf.sdc.core.user.model.UserDO;
import com.pilaf.sdc.core.user.service.TestBean;
import com.pilaf.sdc.core.user.service.UserService;

@RestController
@RequestMapping(value = "user")
@Transactional
public class UserRestController {

    private UserService userService;

    @Autowired
    private TestBean testBean;

    @Autowired
    public UserRestController(UserService userService) {
	super();
	this.userService = userService;
    }

    @RequestMapping(value = "/all/{page}/{size}/{direction}/{sortField}", method = RequestMethod.GET, produces = {
	    MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    @Secured("USERS")
    public Page<UserJSON> getAllUsers(@PathVariable("page") int page, @PathVariable("size") int size,
	    @PathVariable("direction") String direction, @PathVariable("sortField") String sortField) {
	Page<UserJSON> response = userService.getAll(page, size, direction, sortField)
		.map(userDo -> new UserJSON(userDo));
	return response;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = {
	    MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public UserDO saveUser(@RequestBody UserJSON userJSon) {
	return userService.createUser(new UserDO(userJSon));
    }

    @RequestMapping(value = "byLogin/{login}", method = RequestMethod.GET)
    public UserDO getUserByLogin(@PathVariable("login") String login) {

	return userService.findActiveUserByLogin(login);
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
