package net.gzl.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gzl.admin.controller.BaseController;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		if(BaseController.isLogin(request)){
			return true;
		}
		response.sendRedirect("/login/toLogin");
		return false;
	}
	
}
