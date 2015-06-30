package net.gzl.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/articleManage")
public class ArticleController extends BaseController {

	@RequestMapping("")
	public ModelAndView toIndex(ModelAndView mav, HttpServletRequest request) {
		mav.getModel().put("user", getLoginUser(request));
		mav.getModel().put("authes", getAuthesByLoginUser(request));
		mav.setViewName("article/article-manage");
		return mav;
	}
	
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(ModelAndView mav, HttpServletRequest request) {
		mav.getModel().put("user", getLoginUser(request));
		mav.getModel().put("authes", getAuthesByLoginUser(request));
		mav.setViewName("article/article-add");
		return mav;
	}
	
}
