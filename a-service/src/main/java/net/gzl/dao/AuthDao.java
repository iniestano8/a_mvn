package net.gzl.dao;

import java.util.List;

import net.gzl.entity.Auth;

public interface AuthDao {

	public void save(Auth auth);

	public void update(Auth auth);
	
	public void delete(int id);
	
	public Auth getById(int id);
	
	public List<Auth> getList(Auth auth);
	
	public List<Auth> getByIds(List<String> ids);
	
}
