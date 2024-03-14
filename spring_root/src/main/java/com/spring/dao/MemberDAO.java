package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.MemberVO;

public interface MemberDAO {
	
	
	MemberVO selectMemberById(String id)throws SQLException;
	
	List<String> selectMemberAuthoritiesById(String id) throws SQLException;
}
