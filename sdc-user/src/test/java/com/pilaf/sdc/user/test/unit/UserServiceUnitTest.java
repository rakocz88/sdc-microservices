package com.pilaf.sdc.user.test.unit;

import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.pilaf.sdc.user.model.AddressDO;
import com.pilaf.sdc.user.model.ContactDO;
import com.pilaf.sdc.user.model.Country;
import com.pilaf.sdc.user.model.UserDO;
import com.pilaf.sdc.user.model.UserType;
import com.pilaf.sdc.user.repository.UserRepository;
import com.pilaf.sdc.user.service.UserService;
import com.pilaf.sdc.user.test.help.SdcTestConstants;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceUnitTest implements SdcTestConstants {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@Before
	public void injectMocks() {
		PageRequest pageRequestFor5ASCRows = new PageRequest(0, 5, Direction.ASC, "login");
		PageRequest pageRequestFor5DescRows = new PageRequest(0, 5, Direction.DESC, "login");
		PageRequest pageRequestForNext5Rows = new PageRequest(1, 5, Direction.ASC, "login");
		PageRequest pageRequestFor10Rows = new PageRequest(0, 10, Direction.ASC, "login");
		Mockito.when(userRepository.findAll(pageRequestFor5ASCRows))
				.thenReturn(new PageImpl<UserDO>(Arrays.asList(new UserDO[] { user1, user2, user3, user4, user5 })));
		Mockito.when(userRepository.findAll(pageRequestForNext5Rows))
				.thenReturn(new PageImpl<UserDO>(Arrays.asList(new UserDO[] { user6, user7, user8, user9 })));
		Mockito.when(userRepository.findAll(pageRequestFor10Rows)).thenReturn(new PageImpl<UserDO>(
				Arrays.asList(new UserDO[] { user1, user2, user3, user4, user5, user6, user7, user8, user9, user10 })));
		Mockito.when(userRepository.findAll(pageRequestFor5DescRows))
				.thenReturn(new PageImpl<UserDO>(Arrays.asList(new UserDO[] { user10, user9, user8, user7, user6 })));
		Mockito.when(userRepository.save(userWithLogin)).thenReturn(userWithLogin);
		Mockito.when(userRepository.save(userWithLoginAndPassword)).thenReturn(userWithLoginAndPassword);
		Mockito.when(userRepository.save(userWithFullData)).thenReturn(userWithFullData);
		Mockito.when(userRepository.findByLogin(LOGIN_NAME)).thenReturn(userWithLogin);

	}

	@Test
	public void amountOfDataUnitTest() {
		Page<UserDO> userPage = userService.getAll(0, 5, Direction.ASC.name(), "login");
		assertThat("Wrong size for page request 5", userPage.getNumberOfElements() == 5);
		userPage = userService.getAll(0, 10, Direction.ASC.name(), "login");
		assertThat("Wrong size for page request 10", userPage.getNumberOfElements() == 10);
	}

	@Test
	public void nextPageAmountUnitTest() {
		Page<UserDO> userPage = userService.getAll(1, 5, Direction.ASC.name(), "login");
		assertThat("Wrong size for for next page request", userPage.getNumberOfElements() == 4);

	}

	@Test
	public void sortUnitTest() {
		Page<UserDO> userPage = userService.getAll(0, 5, Direction.ASC.name(), "login");
		List<UserDO> userList = userPage.getContent();
		assertThat("Wrong user for asceding sorting at position 1. User should be " + user1.getLogin() + " but is "
				+ userList.get(0).getLogin(), userList.get(0).getLogin().equals(user1.getLogin()));
		assertThat("Wrong user for asceding sorting at position 5", userList.get(4).equals(user5));
		userPage = userService.getAll(0, 5, Direction.DESC.name(), "login");
		userList = userPage.getContent();
		assertThat("Wrong user for desc sorting at position 1", userList.get(0).equals(user10));
		assertThat("Wrong user for desc sorting at position 5", userList.get(4).equals(user6));
	}

	@Test
	public void saveUserWithLoginUnitTest() {
		UserDO user = userService.createUser(userWithLogin);
		assertThat("Wrong user data", userWithLogin.equals(user));
	}

	@Test
	public void saveUserWithLoginAndPasswordUnitTest() {
		UserDO user = userService.createUser(userWithLoginAndPassword);
		assertThat("Wrong user data", userWithLoginAndPassword.equals(user));
	}

	@Test
	public void saveUserAllFieldUnitTest() {
		UserDO user = userService.createUser(userWithFullData);
		assertThat("Wrong user data", userWithFullData.equals(user));
	}

	@Test
	public void findUserByNameUnitTest() {
		UserDO user = userService.findUserByLogin(LOGIN_NAME);
		assertThat("Wrong user data", userWithLogin.equals(user));
	}

}
