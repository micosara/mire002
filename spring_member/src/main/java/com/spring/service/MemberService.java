package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.MemberVO;

public interface MemberService {
	
	List<MemberVO> list()throws SQLException;
	MemberVO detail(String id) throws SQLException;
	void regist(MemberVO member) throws SQLException;
	void modify(MemberVO member) throws SQLException;
	void remove(String id) throws SQLException;
}





