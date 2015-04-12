package net.gzl.test;

import java.util.Arrays;
import java.util.List;

import net.gzl.constant.AuthTypeEnum;
import net.gzl.entity.Auth;
import net.gzl.service.IAuthService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:*applicationContext.xml"})
public class AuthTest {

	@Autowired
	private IAuthService authService;
	
	@Test
	public void saveTest(){
		Auth auth = new Auth();
		auth.setName("用户管理");
		auth.setParentId(0);
		auth.setMenu("/userManage");
		auth.setType(AuthTypeEnum.ALL.getValue());
		auth.setStyle("icon-user");
		
		System.err.println(authService.save(auth));
	}
	
	@Test
	public void updateTest(){
		Auth auth = new Auth();
		auth.setId(1);
		auth.setMenu("/authManage");
		
		System.err.println(authService.update(auth));
	}
	
	@Test
	public void deleteTest(){
		int id = 5;
		System.err.println(authService.delete(id));
	}
	
	@Test
	public void getByIdTest(){
		int id = 1;
		System.err.println(authService.getById(id).getMenu());
	}
	
	@Test
	public void getListTest(){
		Auth auth = new Auth();
		System.err.println(authService.getList(auth).size());
	}
	
	@Test
	public void getByIdsTest(){
		String idStr = "1-2-4";
		
		List<String> ids = Arrays.asList(idStr.split("-"));
		
		System.err.println(authService.getByIds(ids).size());
	}
	
}
