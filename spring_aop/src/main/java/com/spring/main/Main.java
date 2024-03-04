package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.aop.pointcut.Behavior;
import com.spring.aop.pointcut.BehaviorImpl;

public class Main {

	public static void main(String[] args) {
		// Behavior behavior = new BehaviorImpl();
		
		ApplicationContext ctx 	
		= new GenericXmlApplicationContext("classpath:com/spring/context/application-context.xml");

		Behavior behavior = ctx.getBean("behavior",Behavior.class);
		
		behavior.밥먹기();
		behavior.정신수양();		
		behavior.밥먹기();
		behavior.공부하기();
		behavior.놀기();
		behavior.데이트();
		behavior.운동();
		behavior.밥먹기();
		behavior.잠자기();
	}

}
