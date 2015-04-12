package net.gzl.service.impl;

import java.util.List;

import net.gzl.dao.UserDao;
import net.gzl.entity.User;
import net.gzl.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;
	
	public boolean save(User user) {
		userDao.save(user);
		return true;
	}

	public boolean update(User user) {
		userDao.update(user);
		return true;
	}

	public boolean delete(int id) {
		userDao.delete(id);
		return true;
	}

	public User getById(int id) {
		return userDao.getById(id);
	}

	public List<User> getList(User user) {
		return userDao.getList(user);
	}

	public User getByNameAndPwd(User user) {
		return userDao.getByNameAndPwd(user);
	}
	
}
