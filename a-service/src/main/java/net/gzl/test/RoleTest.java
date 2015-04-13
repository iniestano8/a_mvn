package net.gzl.test;

import net.gzl.entity.Role;
import net.gzl.service.IRoleService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:*applicationContext.xml"})
public class RoleTest {

	@Autowired
	private IRoleService roleService;
	
	@Test
	public void saveTest(){
		Role role = new Role();
		role.setName("超级管理员");
		role.setAuthes("1-2-3-4-5");
		System.err.println(roleService.save(role));
	}
	
}
