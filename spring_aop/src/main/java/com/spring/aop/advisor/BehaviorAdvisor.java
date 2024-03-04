package com.spring.aop.advisor;

import org.aspectj.lang.ProceedingJoinPoint;

public class BehaviorAdvisor {

	public void chikachika() {

		System.out.println("열심히 양치질을 합니다.");
	}

	// joinpoint : around
	public void chikachikaAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("한번 닦았는데...");

		joinPoint.proceed();

		System.out.println("또 닦아요!!!!!!!");
	}

}
