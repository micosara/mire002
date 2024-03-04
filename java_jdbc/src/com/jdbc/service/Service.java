package com.jdbc.service;

import java.util.List;

import com.jdbc.dto.VO;

public interface Service<E extends VO> {

	List<E> list() throws Exception;
	E detail(String id) throws Exception;
	void regist(E e) throws Exception;
	void modify(E e) throws Exception;
	void remove(String id) throws Exception;
}
