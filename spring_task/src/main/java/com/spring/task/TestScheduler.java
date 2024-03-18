package com.spring.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/*
cron : 정기적로 반복
	Seconds	:	0 ~ 59
	Minutes	:	0 ~ 59
	Hours		:	0 ~ 23
	Day of Month	:	1 ~ 31 (1~28)
 	Month	:	1 ~ 12 
	Day of Week	:	0 ~ 6 (0: 일, 1: 월, 2:화, 3:수, 4:목, 5:금, 6:토)

	* : 모든수를 의미, Minutes 위치에 사용될 경우 매분마다 라는 뜻 
	? : Day of Month, Day of Week에만 사용 가능, 특별한 값이 없다는 뜻 
	- : 기간을 설정, Hour 위치에 10 - 12 라고 쓰면 10, 11, 12dp 동작하라는 뜻 
	, : 특정 시간을 설정. Day of Week 위치에 2, 4, 6 이라고 쓰면 월, 수, 금에만 동작하라는 뜻 
	/ : 증가를 표현, Seconds 위치에 0/15로 설정되어 있으면, 0초에 시작해서 15초 간격으로 동작
	     하라는 뜻 
	L : Day Of Month 에서만 사용하며, 마지막 날의 의미 Day of Month 에 L로 설정되어 있으면 그달
         의 마지막날에 실행하라는 의미 
	W : Day of Month 에만 사용하며, 가장 가까운 평일을 의미. 15W로 설정되어 있고 15일이 토요일
	     이며, 가장 가까운 평일인 14일 금요일에 실행, 15일이 일요일이면 16일 월요일에 실행된다.
       15일이 평일이면 그날 그대로 실행됨 
	LW : L과 W를 결합하여 사용, 그달의 마지막 평일의 의미 
	# : Day of Week에 사용, 6#3 의 경우 3번째 주 금요일에 실행된다. 
 
 	사용 예
	0 0 12 * * *           ==> 매일 12시에 실행
	0 15 10 * * *         ==> 매일 10시 15분에 실행
	0 * 14 * * *           ==> 매일 14시에 매 분마다 실행
	0 0/5 14,18 * * *    ==> 매일 14시, 18시에 시작해서 0분을 시작으로 5분간격으로 실행
	0 0-5 14 * * *        ==> 매일 14시에 시작해서 0~5분동안 1분간격 실행
*/


//@Component("jobTask")
public class TestScheduler {

	//@Scheduled(fixedRate=1000*5)
	//@Scheduled(cron = "*/5 * * * * * ")
	public void testMessage() {
		System.out.println("안녕하세요.!!");
	}
}




