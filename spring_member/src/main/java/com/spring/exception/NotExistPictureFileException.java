package com.spring.exception;

public class NotExistPictureFileException extends Exception{
	
	public NotExistPictureFileException() {
		super("업로드 이미지 파일이 없습니다.");
	}
}
