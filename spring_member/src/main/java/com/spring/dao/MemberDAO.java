package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.MemberVO;

public interface MemberDAO {
	
	List<MemberVO> selectList()throws SQLException;
	MemberVO selectMemberById(String id)throws SQLException;
	void insertMember(MemberVO member)throws SQLException;
	void updateMember(MemberVO member)throws SQLException;
	void deleteMember(String id)throws SQLException;
	
}
