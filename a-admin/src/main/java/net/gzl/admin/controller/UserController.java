package net.gzl.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/toIndex")
	public ModelAndView toIndex(ModelAndView mav){
		
		mav.setViewName("index");
		return mav;
	}
	
}