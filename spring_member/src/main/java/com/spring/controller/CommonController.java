package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	

	@GetMapping("/common/loginForm")
	public void loginForm() {};
	
	
	@GetMapping("/security/accessDenied")
	public void accessDenied() {}
}
