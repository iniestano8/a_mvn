package net.gzl.service.impl;

import java.util.List;

import net.gzl.dao.RoleDao;
import net.gzl.entity.Role;
import net.gzl.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleDao roleDao;
	
	public boolean save(Role role) {
		roleDao.save(role);
		return true;
	}

	public boolean update(Role role) {
		roleDao.update(role);
		return true;
	}

	public boolean delete(int id) {
		roleDao.delete(id);
		return true;
	}

	public Role getById(int id) {
		return roleDao.getById(id);
	}

	public List<Role> getList(Role role) {
		return roleDao.getList(role);
	}

}
