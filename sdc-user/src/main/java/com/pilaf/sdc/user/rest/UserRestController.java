package com.pilaf.sdc.user.rest;

import java.time.LocalDate;
import java.util.Arrays;
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

import com.pilaf.sdc.user.json.UserJSON;
import com.pilaf.sdc.user.model.AddressDO;
import com.pilaf.sdc.user.model.ContactDO;
import com.pilaf.sdc.user.model.Country;
import com.pilaf.sdc.user.model.UserDO;
import com.pilaf.sdc.user.model.UserType;
import com.pilaf.sdc.user.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserRestController {

	private UserService userService;

	private static final String LOGIN_NAME = "login1";
	private static final String PASSWORD_NAME = "pass1";
	private static final String PHONE_NR_1 = "123123456";

	private static final String USER_FIRST_NAME = "filip";
	private static final String USER_SURNAME = "Cos";
	private static final String EMAIL_NAME_1 = "example@ex.pl";
	private static final ContactDO CONTACT_1 = new ContactDO(PHONE_NR_1, EMAIL_NAME_1);
	private static final AddressDO ADDRESS_1 = new AddressDO("123-12", "Wroclaw", "DS", Country.POLAND, "23", "2a");
	private static final LocalDate USER_BIRTH_DATE = LocalDate.of(1990, 2, 20);
	private static final List<UserType> LIST_TYPE_LIST = Arrays
			.asList(new UserType[] { UserType.PHOTOGRAPHER, UserType.USER });

	private UserDO userWithFullData = new UserDO(LOGIN_NAME, PASSWORD_NAME, USER_FIRST_NAME, USER_SURNAME,
			USER_BIRTH_DATE, ADDRESS_1, LIST_TYPE_LIST, CONTACT_1);

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

}
