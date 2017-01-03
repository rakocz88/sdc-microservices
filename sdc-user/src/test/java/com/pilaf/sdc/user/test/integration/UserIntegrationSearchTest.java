// package com.pilaf.sdc.user.test.integration;
//
// import static org.hamcrest.MatcherAssert.assertThat;
//
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
//
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.test.SpringApplicationContextLoader;
// import org.springframework.boot.test.TestRestTemplate;
// import org.springframework.boot.test.WebIntegrationTest;
// import org.springframework.http.ResponseEntity;
// import org.springframework.test.annotation.DirtiesContext;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
// import com.pilaf.sdc.user.UserWebApp;
// import com.pilaf.sdc.user.model.UserDO;
// import com.pilaf.sdc.user.repository.UserRepository;
// import com.pilaf.sdc.user.test.help.SdcTestConstants;
//
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = UserWebApp.class, loader =
// SpringApplicationContextLoader.class)
// @WebIntegrationTest(randomPort = true)
// @DirtiesContext
// public class UserIntegrationSearchTest implements SdcTestConstants {
//
// @Value("${local.server.port}")
// protected int port;
//
// @Autowired
// protected UserRepository userRepository;
//
// @Before
// public void beforeTest() {
// initUserData();
// }
//
// private void initUserData() {
// List<UserDO> users = getUsersData();
// users.stream().forEach(user -> userRepository.save(user));
// }
//
// private List<UserDO> getUsersData() {
// List<UserDO> userList = new ArrayList<UserDO>();
// userList.add(new UserDO(USER_NAME_1));
// userList.add(new UserDO(USER_NAME_2));
// userList.add(new UserDO(USER_NAME_3));
// userList.add(new UserDO(USER_NAME_4));
// userList.add(new UserDO(USER_NAME_5));
// userList.add(new UserDO(USER_NAME_6));
// userList.add(new UserDO(USER_NAME_7));
// userList.add(new UserDO(USER_NAME_8));
// userList.add(new UserDO(USER_NAME_9));
// userList.add(new UserDO(USER_NAME_10));
// userList.add(new UserDO(USER_NAME_11));
// return userList;
// }
//
// // @Test
// // public void searchFilterUsers() {
// // Map<String, String> uriVariables = new HashMap<>();
// // List entity = new TestRestTemplate().getForEntity("http://localhost:" +
// // this.port + "/user/all/0/5/ASC/login",
// // CustomPageImpl.class, uriVariables).getBody();
// // System.err.println(entity);
// // }
//
// @Test
// public void searchUserByLogin() {
// Map<String, String> uriVariables = new HashMap<>();
// ResponseEntity<UserDO> entity = new TestRestTemplate().getForEntity(
// "http://localhost:" + this.port + "/user/byLogin/" + USER_NAME_1,
// UserDO.class, uriVariables);
// UserDO returnedUser = entity.getBody();
// assertThat("Wrong userName", USER_NAME_1.equals(returnedUser.getLogin()));
// }
//
// }
