package net.gzl.admin.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController extends BaseController {

	@RequestMapping("")
	public String logout(HttpServletResponse response){
		Cookie cookie = new Cookie("user",null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "redirect:login/toLogin";
	}
	
}
