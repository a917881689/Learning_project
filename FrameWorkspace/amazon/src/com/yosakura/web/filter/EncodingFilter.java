package com.yosakura.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 1.请求乱码过滤
		request.setCharacterEncoding("UTF-8");
		// 2.响应乱码错误
		response.setContentType("text/html;charset=UTF-8");
		// 3.放行
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
}
