package net.gzl.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.gzl.entity.Auth;
import net.gzl.service.IAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/authManage")
public class AuthController extends BaseController {

	@Autowired
	private IAuthService authService;
	
	@RequestMapping("")
	public ModelAndView toIndex(HttpServletRequest request, ModelAndView mav){
		mav.getModel().put("user", getLoginUser(request));
		mav.getModel().put("authes", getAuthesByLoginUser(request));
		List<Auth> authes = authService.getList(null);
		mav.getModel().put("authes", authes);
		mav.setViewName("authManage");
		return mav;
	}
	
}
