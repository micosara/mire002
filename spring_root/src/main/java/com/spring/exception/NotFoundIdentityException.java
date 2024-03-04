package com.spring.exception;

public class NotFoundIdentityException extends Exception{

	public NotFoundIdentityException() {
		super("존재하지 않는 아이디입니다.");
	}
}
