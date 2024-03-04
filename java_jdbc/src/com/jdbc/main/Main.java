package com.jdbc.main;

import com.jdbc.controller.MainController;
import com.jdbc.controller.고객Controller;

public class Main {

	private MainController mainC = new MainController();
	private 고객Controller 고객C = new 고객Controller();
	
	public static void main(String[] args) {
		Main main = new Main();
		while(true) {
			main.start();
		}

	}
	
	private void start() {
		String menu = mainC.menu();
		
		switch(menu) {
		case "1": //고객리스트
			고객C.list();
			break;
		case "2": //제품리스트
			System.out.println("\n서비스 준비 중 입니다.\n");
			break;
		case "3": //주문리스트
			break;
		case "q":case "Q": //종료 
			System.out.println("프로그램을 종료합니다.");
			System.exit(0); 
			break;
		default: // etc
			System.out.println("메뉴선택이 올바르지 않습니다.\n");
		}
	}

}



