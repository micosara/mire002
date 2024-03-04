package com.jdbc.dto;

public class 고객VO extends VO{
	private String 고객아이디;
	private String 고객이름;
	private int 나이;
	private String 등급;
	private String 직업;
	private int 적립금;
	public String get고객아이디() {
		return 고객아이디;
	}
	public void set고객아이디(String 고객아이디) {
		this.고객아이디 = 고객아이디;
	}
	public String get고객이름() {
		return 고객이름;
	}
	public void set고객이름(String 고객이름) {
		this.고객이름 = 고객이름;
	}
	public int get나이() {
		return 나이;
	}
	public void set나이(int 나이) {
		this.나이 = 나이;
	}
	public String get등급() {
		return 등급;
	}
	public void set등급(String 등급) {
		this.등급 = 등급;
	}
	public String get직업() {
		return 직업;
	}
	public void set직업(String 직업) {
		this.직업 = 직업;
	}
	public int get적립금() {
		return 적립금;
	}
	public void set적립금(int 적립금) {
		this.적립금 = 적립금;
	}
	@Override
	public String toString() {
		return "[" + 고객아이디 + "," + 고객이름 + "," + 나이 + "," + 등급 + "," + 직업 + "," + 적립금
				+ "]";
	}
	
	
}
