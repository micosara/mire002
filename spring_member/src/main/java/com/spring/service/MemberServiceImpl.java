package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;

public class MemberServiceImpl implements MemberService{

	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public List<MemberVO> list() throws SQLException {
		return memberDAO.selectList();
	}

	@Override
	public MemberVO detail(String id) throws SQLException {
		return memberDAO.selectMemberById(id);
	}

	@Override
	public void regist(MemberVO member) throws SQLException {
		memberDAO.insertMember(member);
		
	}

	@Override
	public void modify(MemberVO member) throws SQLException {
		memberDAO.updateMember(member);
		
	}

	@Override
	public void remove(String id) throws SQLException {
		memberDAO.deleteMember(id);
	}

}
