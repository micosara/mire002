package com.spring.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException{
		HttpServletRequest httpReq = (HttpServletRequest) request;
		
		String url = httpReq.getRequestURI().replace(httpReq.getContextPath(), "");
		System.out.println("url:"+url);
		if(url.indexOf("/resources")==0) {
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session = httpReq.getSession();
		String loginUser = (String)session.getServletContext().getContext("/").getAttribute("loginUser");
		
		//String id = httpReq.getParameter("loginUser");
		
		if(loginUser!=null) {
			session.setAttribute("loginUser", loginUser);
			chain.doFilter(request, response);
		}else {
			session.invalidate();
			
			String retUrl = httpReq.getRequestURI();
			
			String queryString = httpReq.getQueryString();
			if (queryString != null) {
				retUrl="?"+ queryString;
			}
			System.out.println(retUrl);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('세션이 만료되었습니다.\\n다시 로그인 하세요.');");
			out.println("window.parent.location.href='/common/loginForm.do?retUrl="+retUrl+"';");
			out.println("</script>");
		}
		
	}

}
