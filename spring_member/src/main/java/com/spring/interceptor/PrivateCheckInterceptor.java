package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.dto.MemberVO;

public class PrivateCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, 
							 HttpServletResponse response, Object handler)
			throws Exception {
		boolean result=true;
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		String target_id = request.getParameter("id");
		
		if(!loginUser.getId().equals(target_id)) {
			result=false;
			request.getRequestDispatcher("/WEB-INF/views/security/accessDenied.jsp")
					.forward(request, response);
		}
		
		
		return result;
	}


}
