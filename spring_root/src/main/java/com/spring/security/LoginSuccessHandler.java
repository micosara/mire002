package com.spring.security;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.spring.dto.MemberVO;

public class LoginSuccessHandler  extends SavedRequestAwareAuthenticationSuccessHandler{

	private String loginUserLogSavePath;
	public void setLoginUserLogSavePath(String path) {
		this.loginUserLogSavePath = path;
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
										HttpServletResponse response,
										Authentication authentication) throws ServletException, IOException {
		
		
		User user = (User)authentication.getDetails();	
		MemberVO loginUser = user.getMemberVO();  
		
		// session 저장
		HttpSession session = request.getSession();		
		session.setAttribute("loginUser", loginUser);
		session.setMaxInactiveInterval(6*60);
		
		//apllication context
		ServletContext ctx = request.getServletContext();
		ctx.setAttribute("loginUser", loginUser.getId());
		
		String saveFileName = "login_user_log.csv";
		//로그인 정보를 스트링으로 저장.
		String tag ="[login:user]";
		String log =tag
					+loginUser.getId()+","					
					+loginUser.getPhone()+","
					+loginUser.getEmail()+","
					+request.getRemoteAddr()+","
					+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

		if(loginUserLogSavePath==null) loginUserLogSavePath="c:/log/login_user";
		
		loginUserLogSavePath = loginUserLogSavePath.replace("/",File.separator);
		
		File file=new File(loginUserLogSavePath);
		file.mkdirs();
		
		String logFilePath=loginUserLogSavePath+File.separator+saveFileName;	
		BufferedWriter out=new BufferedWriter(new FileWriter(logFilePath,true));


		//로그를 기록
		out.write(log);
		out.newLine();
		
		out.close();
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

	
}
