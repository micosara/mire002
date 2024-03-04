package com.spring.command;

public class MemberModifyCommand extends MemberRegistCommand{
	private String oldPicture;
	
	
	public String getOldPicture() {
		return oldPicture;
	}
	public void setOldPicture(String oldPicture) {
		this.oldPicture = oldPicture;
	}
	
}
