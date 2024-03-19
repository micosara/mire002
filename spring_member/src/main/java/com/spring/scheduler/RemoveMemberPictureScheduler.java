package com.spring.scheduler;

import java.io.File;

import com.spring.dao.SearchMemberDAO;

public class RemoveMemberPictureScheduler {
	private SearchMemberDAO memberDAO;
	public void setSearchMemberDAO(SearchMemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	private String picturePath;
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	
	public void removePicture() throws Exception {
		File dir = new File(picturePath);
		File[] files = dir.listFiles();

		if (files != null)
			for (File file : files) {
				//System.out.println(file.getName());
				if(memberDAO.selectMemberByPicture(file.getName())==null) {
					file.delete();
					System.out.println("delete file : "+file.getName());
				}
			}

	}
}
