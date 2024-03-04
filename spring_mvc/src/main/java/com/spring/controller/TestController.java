package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public void hello(){}
	
	@GetMapping("/commons/login")
	public void login() {}
	
	@GetMapping("/commons/main")
	public void main() {}
	
	@PostMapping("/commons/login")
	public String login(String id, String pwd,HttpSession session) {
		String url="redirect:/commons/main";
		
		String targetID="mimi";
		String targetPWD="mimi";
		
		if(id.equals(targetID)) {
			if(pwd.equals(targetPWD)) { //로그인 성공
				session.setAttribute("loginUser", id);
				session.setMaxInactiveInterval(10);
			}else {//패스워드가 불일치
				url="redirect:/commons/login?error=2";
			}
		}else {//아이디가 불일치
			url="redirect:/commons/login?error=1";
		}
		
		return url;
	}
}













