package com.spring.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import com.spring.dto.MemberVO;
import com.spring.security.User;
import com.spring.service.SearchMemberService;

public class SecurityContextChainFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
		SecurityContext context = (SecurityContext) session
		  .getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		
		UsernamePasswordAuthenticationToken auth = null;
		
		String login_id = (String) request.getServletContext().getContext("/").getAttribute("loginUser");
		if (login_id == null) {
			session.invalidate();
			chain.doFilter(request, response);
			return;
		}
		
		
		if (context == null) {
			context = SecurityContextHolder.getContext();

			ApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:com/spring/context/root-context.xml");
			SearchMemberService service = ctx.getBean("searchMemberService", 
					SearchMemberService.class);
			try {
				MemberVO member = service.detail(login_id);
				User user = new User(member);
				auth = new UsernamePasswordAuthenticationToken(member.getId(), member.getPwd(),
						user.getAuthorities());
				auth.setDetails(user);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		context.setAuthentication(auth);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, 
				context);
		
		chain.doFilter(request, response);
		

		
	}

}
