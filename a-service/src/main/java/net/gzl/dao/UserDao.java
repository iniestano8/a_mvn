package net.gzl.dao;

import java.util.List;

import net.gzl.entity.User;

public interface UserDao {

	public void save(User user);
	
	public void update(User user);
	
	public void delete(int id);
	
	public User getById(int id);
	
	public List<User> getList(User user);
	
	public User getByNameAndPwd(User user);
	
}
