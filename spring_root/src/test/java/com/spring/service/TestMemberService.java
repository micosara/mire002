package com.spring.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dto.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/root-context.xml")
public class TestMemberService {
	
	@Autowired
	private MemberService memberService;
	
	@Test
	public void testMemberVO() throws Exception{
		String id = "mimi";
		String pwd ="mimi";
		
		MemberVO member = memberService.login(id, pwd);
		
		System.out.println(member.getAuthorities());
		Assert.assertNotNull(member.getAuthorities());
		
	}
}






