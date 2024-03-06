package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.PageMaker;
import com.spring.dto.NoticeVO;

public interface NoticeService {
	public Map<String, Object> list(PageMaker pageMaker) throws SQLException;
	public NoticeVO detail(int nno) throws SQLException;
	public NoticeVO getNotice(int nno) throws SQLException;
	public void regist(NoticeVO notice) throws SQLException;
	public void modify(NoticeVO notice) throws SQLException;
	public void remove(int nno) throws SQLException;
	
	
}
