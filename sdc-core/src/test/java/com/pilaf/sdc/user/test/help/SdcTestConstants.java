package com.pilaf.sdc.user.test.help;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.pilaf.sdc.core.user.model.AddressDO;
import com.pilaf.sdc.core.user.model.ContactDO;
import com.pilaf.sdc.core.user.model.Country;
import com.pilaf.sdc.core.user.model.UserDO;
import com.pilaf.sdc.core.user.model.UserType;

public interface SdcTestConstants {
	public static final String USER_NAME_1 = "Adam";
	public static final String USER_NAME_2 = "Kamil";
	public static final String USER_NAME_3 = "Bogdan";
	public static final String USER_NAME_4 = "Marcin";
	public static final String USER_NAME_5 = "Janina";
	public static final String USER_NAME_6 = "Krystna";
	public static final String USER_NAME_7 = "Bozena";
	public static final String USER_NAME_8 = "Witek";
	public static final String USER_NAME_9 = "Borys";
	public static final String USER_NAME_10 = "Grzegorz";
	public static final String USER_NAME_11 = "Padora";
	public static final String EXAMLE_USER_1_NAME = "name";

	public static final UserDO user1 = new UserDO(EXAMLE_USER_1_NAME);
	public static final UserDO user2 = new UserDO(EXAMLE_USER_1_NAME + 1);
	public static final UserDO user3 = new UserDO(EXAMLE_USER_1_NAME + 2);
	public static final UserDO user4 = new UserDO(EXAMLE_USER_1_NAME + 3);
	public static final UserDO user5 = new UserDO(EXAMLE_USER_1_NAME + 4);
	public static final UserDO user6 = new UserDO(EXAMLE_USER_1_NAME + 5);
	public static final UserDO user7 = new UserDO(EXAMLE_USER_1_NAME + 6);
	public static final UserDO user8 = new UserDO(EXAMLE_USER_1_NAME + 7);
	public static final UserDO user9 = new UserDO(EXAMLE_USER_1_NAME + 8);
	public static final UserDO user10 = new UserDO(EXAMLE_USER_1_NAME + 9);

	public static final String LOGIN_NAME = "login1";
	public static final String PASSWORD_NAME = "pass1";
	public static final String PHONE_NR_1 = "123123456";

	public static final String USER_FIRST_NAME = "filip";
	public static final String USER_SURNAME = "Cos";
	public static final String EMAIL_NAME_1 = "example@ex.pl";
	public static final ContactDO CONTACT_1 = new ContactDO(PHONE_NR_1, EMAIL_NAME_1);
	public static final AddressDO ADDRESS_1 = new AddressDO("123-12", "Wroclaw", "DS", Country.POLAND, "23", "2a");
	public static final LocalDate USER_BIRTH_DATE = LocalDate.of(1990, 2, 20);
	public static final List<UserType> LIST_TYPE_LIST = Arrays
			.asList(new UserType[] { UserType.PHOTOGRAPHER, UserType.USER });

	public static final UserDO userWithLogin = new UserDO(LOGIN_NAME);
	public static final UserDO userWithLoginAndPassword = new UserDO(LOGIN_NAME, PASSWORD_NAME);
	public static final UserDO userWithFullData = new UserDO(LOGIN_NAME, PASSWORD_NAME, USER_FIRST_NAME, USER_SURNAME,
			USER_BIRTH_DATE, ADDRESS_1, LIST_TYPE_LIST, CONTACT_1);

}
