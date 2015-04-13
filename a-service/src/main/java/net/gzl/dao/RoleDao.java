package net.gzl.dao;

import java.util.List;

import net.gzl.entity.Role;

public interface RoleDao {

	public void save(Role role);
	
	public void update(Role role);
	
	public void delete(int id);
	
	public Role getById(int id);
	
	public List<Role> getList(Role role);
	
}
