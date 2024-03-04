package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.PageMaker;
import com.spring.dto.AttachVO;
import com.spring.dto.PdsVO;

public interface PdsService {

	//목록
	List<PdsVO> searchList(PageMaker pageker) throws SQLException;
	
	//등록
	void regist(PdsVO pds)throws SQLException;
	
	//읽기
	void increaseViewCnt(int pno) throws SQLException;
	
	PdsVO getPds(int pno) throws SQLException;
	
	//수정
	void modify(PdsVO pds) throws SQLException;
	
	//삭제
	void remove(int pno) throws SQLException;
	
	//파일조회
	AttachVO getAttachByAno(int ano)throws SQLException;
	
	//파일삭제
	void removeAttachByAno(int ano)throws SQLException;
}





