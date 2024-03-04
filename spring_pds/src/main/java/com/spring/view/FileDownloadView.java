package com.spring.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.View;

public class FileDownloadView implements View{

	private String contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	
	@Override
	public String getContentType() {
		return contentType;
	}

	@Override
	public void render(Map<String, ?> model, 
						HttpServletRequest request, HttpServletResponse response)
								throws Exception {
		
		String savedPath = (String) model.get("savedPath");
		String fileName = (String) model.get("fileName");
		
		// 보낼 파일 설정.
		File downloadFile = new File(savedPath + File.separator + fileName);
		FileInputStream inStream = new FileInputStream(downloadFile);
		
		// 파일 포맷으로 MIME를 결정한다.
		ServletContext context = request.getServletContext();
		String mimeType = context.getMimeType(downloadFile.getName());
		if (mimeType != null) {			
			this.contentType = mimeType;
		}
		
		// response 수정.
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());		

		String headerKey = "Content-Disposition";
		// 한글깨짐 방지 : ISO-8859-1
		String sendFileName= downloadFile.getName().split("\\$\\$")[1];

		String header = request.getHeader("User-Agent");
		if (header.contains("MSIE")) {
			sendFileName = URLEncoder.encode(sendFileName, "UTF-8");
		} else {
			sendFileName = new String(sendFileName.getBytes("utf-8"), "ISO-8859-1");
		}
		String headerValue = String.format("attachment; filename=\"%s\"", sendFileName);
		response.setHeader(headerKey, headerValue);
		
		// 파일 내보내기
		OutputStream outStream = response.getOutputStream();
		
		try {
			FileCopyUtils.copy(inStream,outStream);
		}finally {		
			if(inStream!=null) inStream.close();
			outStream.flush();
		}
		
	}

}
