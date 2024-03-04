package com.jdbc.dto;

import java.util.Date;

public class 주문VO extends VO{
	private String 주문번호;
	private String 주문고객;
	private String 주문제품;
	private int 수량;
	private String 배송지;
	private Date 주문일자;
	
	
	public String get주문번호() {
		return 주문번호;
	}
	public void set주문번호(String 주문번호) {
		this.주문번호 = 주문번호;
	}
	public String get주문고객() {
		return 주문고객;
	}
	public void set주문고객(String 주문고객) {
		this.주문고객 = 주문고객;
	}
	public String get주문제품() {
		return 주문제품;
	}
	public void set주문제품(String 주문제품) {
		this.주문제품 = 주문제품;
	}
	public int get수량() {
		return 수량;
	}
	public void set수량(int 수량) {
		this.수량 = 수량;
	}
	public String get배송지() {
		return 배송지;
	}
	public void set배송지(String 배송지) {
		this.배송지 = 배송지;
	}
	public Date get주문일자() {
		return 주문일자;
	}
	public void set주문일자(Date 주문일자) {
		this.주문일자 = 주문일자;
	}
	@Override
	public String toString() {
		return "[" + 주문번호 + ", " + 주문고객 + "," 
				+ 주문제품 + "," + 수량 + "," + 배송지 + ","
				+ 주문일자 + "]";
	}
	
	
	
}
