package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.PageMaker;
import com.spring.dto.MemberVO;

public interface SearchMemberService extends MemberService{

	List<MemberVO> searchList(PageMaker pageMaker)throws SQLException;
}
