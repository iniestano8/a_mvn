package net.gzl.admin.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gzl.entity.User;
import net.gzl.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ValidateUtil;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/toLogin")
	public String toLogin(HttpServletRequest request){
		if(getLoginUser(request) != null){
			return "redirect:/";
		}
		return "login";
	}
	
	@RequestMapping("")
	public String login(User user, HttpServletResponse response){
		user = userService.getByNameAndPwd(user);
		if(ValidateUtil.isValid(user)){
			Cookie cookie = new Cookie("user", user.toJsonStr());
			response.addCookie(cookie);
		}
		return "redirect:/";
	}
	
}
