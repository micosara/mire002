package com.spring.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.dto.MemberVO;

public class LoginCheckFilter implements Filter {

	private List<String> exURLs = new ArrayList<String>();

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;

		// 제외할 url 확인
		String reqUrl = httpReq.getRequestURI().replace(httpReq.getContextPath(), "");
		if (excludeCheck(reqUrl)) {
			chain.doFilter(request, response);
			return;
		}

		// login check
		HttpSession session = httpReq.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (loginUser != null) {
			chain.doFilter(request, response);
			return;
		}

		String contextPath = httpReq.getContextPath();
		String retUrl = httpReq.getRequestURI().replace(contextPath, "");

		String queryString = httpReq.getQueryString();
		if (queryString != null) {
			retUrl += "?" + queryString;
		}

		String url = httpReq.getContextPath() + "/common/loginForm.do?retUrl="+retUrl;
		httpResp.sendRedirect(url);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String paramExURLs = fConfig.getInitParameter("exclude");
		StringTokenizer token = new StringTokenizer(paramExURLs, ",");
		while (token.hasMoreTokens()) {
			exURLs.add(token.nextToken().trim());
		}
	}

	private boolean excludeCheck(String url) {
		boolean result = false;
		result = result || url.length() <= 1;
		for (String exURL : exURLs) {
			result = result || (url.indexOf(exURL) == 0);
		}
		return result;
	}

}
