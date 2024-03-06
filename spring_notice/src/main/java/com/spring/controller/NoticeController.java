package com.spring.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.command.PageMaker;
import com.spring.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@GetMapping("/main")
	public String main() {
		String url = "/notice/main";
		return url;
	}

	@GetMapping("/list")
	public String list(PageMaker pageMaker, Model model) throws Exception {
		String url = "/notice/list";

		Map<String, Object> dataMap = noticeService.list(pageMaker);

		model.addAllAttributes(dataMap);
		
		return url;
	}
//	@GetMapping("/detail")
//	
//	@GetMapping("/registForm")
//	
//	@PostMapping("/regist")
//	
//	@GetMapping("/modifyForm")
//	
//	@PostMapping("/modify")
//	
//	@PostMapping("/remove")
}
