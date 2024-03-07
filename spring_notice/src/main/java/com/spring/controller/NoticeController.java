package com.spring.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.josephoconnell.html.HTMLInputFilter;
import com.spring.command.PageMaker;
import com.spring.dto.NoticeVO;
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
	@GetMapping("/detail")
	public String detail(int nno,
						@RequestParam(defaultValue = "")String from,
						HttpServletRequest request)throws Exception{
		String url="/notice/detail";
		
		NoticeVO notice = null;
		if(from.equals("list")) {
			notice=noticeService.detail(nno);
			url="redirect:/detail.do?nno="+nno;
		}else {
			notice=noticeService.getNotice(nno);
		}
		
		request.setAttribute("notice", notice);
		
		return url;
	}
	
	@GetMapping("/modifyForm")
	public String modifyForm(int nno,Model model)throws Exception{
		String url="/notice/modify";
		
		NoticeVO notice = noticeService.getNotice(nno);
		
		model.addAttribute("notice",notice);
		return url;
	}
	
	@PostMapping("/modify")
	public ModelAndView modifyPost(NoticeVO notice,
								   HttpServletRequest request,
								   ModelAndView mnv)throws Exception{
		String url = "redirect:/detail.do?nno="+notice.getNno();

		notice.setTitle(HTMLInputFilter.htmlSpecialChars(notice.getTitle()));
		notice.setContent(HTMLInputFilter.htmlSpecialChars(notice.getContent()));
		
		noticeService.modify(notice);
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@GetMapping("/remove")
	public String remove(int nno,RedirectAttributes rttr)throws Exception{
		String url="redirect:/detail.do";
		
		noticeService.remove(nno);
		
		rttr.addAttribute("nno",nno);
		rttr.addFlashAttribute("from","remove");
		
		return url;
	}
	
	@GetMapping("/registForm")
	public String registForm()throws Exception{
		String url="/notice/regist";
		return url;
	}
	
	@PostMapping("/regist")
	public String regist(NoticeVO notice, RedirectAttributes rttr) throws Exception {
		String url="redirect:/list.do";
		
		notice.setTitle(HTMLInputFilter.htmlSpecialChars(notice.getTitle()));
		notice.setContent(HTMLInputFilter.htmlSpecialChars(notice.getContent()));
		
		noticeService.regist(notice);
		
		rttr.addAttribute("page",1);
		rttr.addAttribute("perPageNum",10);
		rttr.addAttribute("searchType","");
		rttr.addAttribute("keyword","");
		
		rttr.addFlashAttribute("from","regist");
		return url;
	}

}
