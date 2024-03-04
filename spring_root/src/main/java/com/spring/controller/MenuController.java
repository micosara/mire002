package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.MenuVO;
import com.spring.service.MenuService;

@RestController
public class MenuController {

	@Autowired
	private MenuService menuService;

	@GetMapping("/subMenu")
	public List<MenuVO> subMenuToJSON(String mCode) throws Exception {
		List<MenuVO> menuList = menuService.getSubMenuList(mCode);
		return menuList;
	}

}
