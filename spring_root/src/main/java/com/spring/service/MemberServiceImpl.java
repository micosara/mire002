package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIdentityException;

public class MemberServiceImpl implements MemberService{

	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public MemberVO login(String id, String pwd) throws NotFoundIdentityException, InvalidPasswordException, SQLException {
		
		MemberVO member = memberDAO.selectMemberById(id);
		
		if(member==null) throw new NotFoundIdentityException();
		if(!pwd.equals(member.getPwd())) throw new InvalidPasswordException();
		
		List<String> authorities = memberDAO.selectMemberAuthoritiesById(id);
		member.setAuthorities(authorities);
		
		
		return member;
	}

}




