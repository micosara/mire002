package com.spring.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class SessionExpiredCheckFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String url = "/WEB-INF/views/security/sessionOut.jsp";

		String message = " 중복 로그인이 확인되었습니다.\\n" + 
					" 다시 로그인하면 다른 장치에서 로그인은 취소됩니다.";

		request.setAttribute("message", message);

		request.getRequestDispatcher(url).forward(request, response);
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
