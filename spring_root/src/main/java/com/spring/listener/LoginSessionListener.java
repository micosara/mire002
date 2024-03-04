package com.spring.listener;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LoginSessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  { 
        System.out.println("Session created at : "+new Date());
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("Session destroyed at  : "+new Date());
    	se.getSession().getServletContext().removeAttribute("loginUser");
    }
	
}
