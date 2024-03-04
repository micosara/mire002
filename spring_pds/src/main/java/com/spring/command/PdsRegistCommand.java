package com.spring.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.PdsVO;

public class PdsRegistCommand {
	private String title;
	private String content;
	private String writer;
	private List<MultipartFile> uploadFile;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public List<MultipartFile> getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(List<MultipartFile> uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	public PdsVO toPdsVO(){
		PdsVO pds = new PdsVO();
		pds.setContent(this.content);
		pds.setTitle(this.title);
		pds.setWriter(this.writer);
		
		return pds;
	}
}
