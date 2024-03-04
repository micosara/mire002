package com.spring.service;

import java.sql.SQLException;

import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIdentityException;

public interface MemberService {
	
	void login(String id, String pwd)throws NotFoundIdentityException,
										    InvalidPasswordException,
										    SQLException;
}
