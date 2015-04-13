package net.gzl.test;

import java.util.List;

import net.gzl.entity.User;
import net.gzl.service.IUserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:*applicationContext.xml"})
public class UserTest {

	@Autowired
	private IUserService userService;
	
	@Test
	public void save(){
		User user = new User();
		user.setName("jason");
		user.setPassword("123");
		user.setRoles("1");
		System.err.println(userService.save(user));
	}
	
	@Test
	public void getListTest(){
		User user = new User();
		user.setName("tom");
		user.setRoles("1");
		List<User> list = userService.getList(user);
		System.err.println(list.size());
	}
	
	@Test
	public void getByNameAndPwdTest(){
		User user = new User();
		user.setName("tom");
		user.setPassword("123");
		System.err.println(userService.getByNameAndPwd(user).toJsonStr());
	}
	
}
