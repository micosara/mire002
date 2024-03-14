package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.MemberDAO;
import com.spring.dto.MenuVO;
import com.spring.service.MemberService;
import com.spring.service.MenuService;

@Controller
public class CommonController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private MenuService menuService;

	@GetMapping("/index.do")
	public ModelAndView main(String mCode, HttpSession session, ModelAndView mnv) throws Exception {
		String url = "/common/indexPage";

		List<MenuVO> menuList = menuService.getMainMenuList();

		if (mCode != null) {
			MenuVO menu = menuService.getMenuByMcode(mCode);
			mnv.addObject("menu", menu);
		}

		mnv.addObject("menuList", menuList);
		mnv.setViewName(url);
		return mnv;
	}

	@GetMapping("/common/loginForm")
	public ModelAndView loginForm(ModelAndView mnv, String retUrl) throws Exception {
		String url = "/common/loginForm";
		mnv.addObject("retUrl", retUrl);
		mnv.setViewName(url);
		return mnv;
	}

	@GetMapping("/common/loginTimeOut")
	public String loginTimeOut(Model model) throws Exception {

		String url = "/security/sessionOut";

		model.addAttribute("message", "세션이 만료되었습니다.\\n다시 로그인 하세요!");
		return url;
	}
//	@PostMapping("/common/login")
//	public ModelAndView loginPost(String id, String pwd, String retUrl,
//								  HttpSession session, 
//								  RedirectAttributes rttr,
//								  ModelAndView mnv)throws Exception{
//		String url="redirect:/index.do";
//		
//		try {
//			memberService.login(id, pwd);
//			
//			MemberVO member = memberDAO.selectMemberById(id);
//			
//			session.setAttribute("loginUser", member);
//			session.setMaxInactiveInterval(60*6);
//			
//			session.getServletContext().setAttribute("loginUser", member.getId());
//			
//			if(retUrl!=null && !retUrl.isEmpty()) {
//				url="redirect:"+retUrl;
//			}
//			
//		}catch(NotFoundIdentityException | InvalidPasswordException e) {
//			url="redirect:/common/loginForm?retUrl="+retUrl;
//			// rttr.addAttribute(attributeValue) : 주소줄 데이터 전달
//			rttr.addFlashAttribute("message",e.getMessage()); //requset 전달방식
//		}
//		
//		mnv.setViewName(url);
//		return mnv;
//	}
//	
//	@GetMapping("/common/logout")
//	public ModelAndView logout(String id,HttpSession session, ModelAndView mnv)throws Exception{
//		String url="redirect:/";
//	
//		session.invalidate();
//		session.getServletContext().removeAttribute("loginUser");;
//		
//		mnv.setViewName(url);
//		return mnv;
//	}
//	

}
