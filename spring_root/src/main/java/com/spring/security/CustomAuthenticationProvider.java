package com.spring.security;

import java.sql.SQLException;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.dto.MemberVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIdentityException;
import com.spring.service.MemberService;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	private MemberService memberService;
	public void setMemberService(MemberService memberService){
		this.memberService = memberService;
	}
	
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String login_id = (String) auth.getPrincipal(); // 로그인 시도한 ID를 가져온다
		String login_pwd = (String) auth.getCredentials(); // 로그인 시도한 Password 를 가져온다.
		
		try {
			MemberVO member = memberService.login(login_id, login_pwd);
			
			UserDetails authUser = new User(member);
			
			boolean invalidCheck = authUser.isAccountNonExpired() 
					&& authUser.isAccountNonLocked()
					&& authUser.isCredentialsNonExpired() 
					&& authUser.isEnabled();
			if (invalidCheck) {
				//로그인 성공
				// 스프링 시큐리티 내부 클래스로 인증 토큰 생성한다.
				UsernamePasswordAuthenticationToken result 
							= new UsernamePasswordAuthenticationToken(
						authUser.getUsername(), authUser.getPassword(), 
						authUser.getAuthorities());
				// 전달할 내용을 설정한 후
				result.setDetails(authUser);
				// 리턴한다. successHandler로 전송된다.
				return result;
				
			}else {
				//로그인실패
				throw new BadCredentialsException("유효하지 않는 계정입니다.");
			}
			
		} catch (NotFoundIdentityException | InvalidPasswordException e) {
			//로그인 실패
			throw new BadCredentialsException(e.getMessage());		
			
		} catch (SQLException e) {
			//에러 발생
			e.printStackTrace();
			throw new AuthenticationServiceException("서버 장애로 서비스가 불가합니다.");
		}
		
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
