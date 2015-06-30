package net.gzl.admin.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import net.gzl.entity.Auth;
import net.gzl.entity.Role;
import net.gzl.entity.User;
import net.gzl.service.IAuthService;
import net.gzl.service.IRoleService;
import net.gzl.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import util.ValidateUtil;

@Controller
public class BaseController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IAuthService authService;
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("/")
	public ModelAndView toIndex(ModelAndView mav, HttpServletRequest request){
		mav.getModel().put("user", getLoginUser(request));
		mav.getModel().put("authes", getAuthesByLoginUser(request));
		mav.setViewName("index");
		return mav;
	}
	
	public static boolean isLogin(HttpServletRequest request){
		boolean flag = false;
		Cookie[] cookies = request.getCookies();
		if(ValidateUtil.isValid(cookies)){
			for(Cookie cookie : cookies){
				if("user".equals(cookie.getName())){
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
	
	protected User getLoginUser(HttpServletRequest request) {
		User user = null;
		Cookie[] cookies = request.getCookies();
		if(ValidateUtil.isValid(cookies)){
			for(Cookie cookie : cookies){
				if("user".equals(cookie.getName())){
					user = User.getUserFromJson(cookie.getValue());
					break;
				}
			}
		}
		if(ValidateUtil.isValid(user)){
			user = userService.getList(user).get(0);
		}
		return user;
	}
	
	protected Role getRoleByLoginUser(HttpServletRequest request){
		Role role = new Role();
		User user = getLoginUser(request);
		if(!ValidateUtil.isValid(user)){
			return null;
		}
		String roleStr = getLoginUser(request).getRoles();
		if(ValidateUtil.isValid(roleStr)){
			String[] roleArr = roleStr.split("-");
			if(ValidateUtil.isValid(roleArr)){
				role = roleService.getById(Integer.parseInt(roleArr[0]));
			}
		}
		return role;
	}
	
	protected List<Auth> getAuthesByLoginUser(HttpServletRequest request){
		List<Auth> authes = null;
		Role role = getRoleByLoginUser(request);
		if(!ValidateUtil.isValid(role)){
			return null;
		}
		String authStr = getRoleByLoginUser(request).getAuthes();
		if(ValidateUtil.isValid(authStr)){
			String[] authArr = authStr.split("-");
			authes = authService.getByIds(Arrays.asList(authArr));
		}
		return authes;
	}
	
}
