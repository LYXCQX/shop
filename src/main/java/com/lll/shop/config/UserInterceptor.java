package com.lll.shop.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class UserInterceptor implements HandlerInterceptor {

	/**
	 * 在请求处理之前进行调用（Controller方法调用之前）
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

		System.out.println("被one拦截，放行...");
		return true;

		/*
		 * if (true) { returnErrorResponse(response,
		 * IMoocJSONResult.errorMsg("被one拦截...")); }
		 * 
		 * return false;
		 */
	}

	/**
	 * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView mv)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行 （主要是用于进行资源清理工作）
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}
}
