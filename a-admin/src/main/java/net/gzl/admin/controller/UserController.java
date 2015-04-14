package net.gzl.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@RequestMapping("/")
	public ModelAndView toIndex(ModelAndView mav){
		
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/toInfoEdit")
	public ModelAndView toInfoEdit(ModelAndView mav, HttpServletRequest request){
		mav.getModel().put("user", getLoginUser(request));
		mav.getModel().put("authes", getAuthesByLoginUser(request));
		mav.getModel().put("title", "title");
		mav.setViewName("/basicInfo/info-edit");
		return mav;
	}
	
}
