package net.gzl.service.impl;

import java.util.List;

import net.gzl.dao.AuthDao;
import net.gzl.entity.Auth;
import net.gzl.service.IAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authService")
public class AuthServiceImpl implements IAuthService {

	@Autowired
	private AuthDao authDao;
	
	public boolean save(Auth auth) {
		authDao.save(auth);
		return true;
	}

	public boolean update(Auth auth) {
		authDao.update(auth);
		return true;
	}

	public boolean delete(int id) {
		authDao.delete(id);
		return true;
	}

	public Auth getById(int id) {
		return authDao.getById(id);
	}

	public List<Auth> getList(Auth auth) {
		return authDao.getList(auth);
	}

	public List<Auth> getByIds(List<String> ids) {
		return authDao.getByIds(ids);
	}

}
