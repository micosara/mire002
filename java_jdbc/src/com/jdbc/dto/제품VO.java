package com.jdbc.dto;

public class 제품VO extends VO {
	private String 제품번호;
	private String 제품명;
	private int 재고량;
	private int 단가;
	private String 제조업체;
	public String get제품번호() {
		return 제품번호;
	}
	public void set제품번호(String 제품번호) {
		this.제품번호 = 제품번호;
	}
	public String get제품명() {
		return 제품명;
	}
	public void set제품명(String 제품명) {
		this.제품명 = 제품명;
	}
	public int get재고량() {
		return 재고량;
	}
	public void set재고량(int 재고량) {
		this.재고량 = 재고량;
	}
	public int get단가() {
		return 단가;
	}
	public void set단가(int 단가) {
		this.단가 = 단가;
	}
	public String get제조업체() {
		return 제조업체;
	}
	public void set제조업체(String 제조업체) {
		this.제조업체 = 제조업체;
	}
	@Override
	public String toString() {
		return "[" + 제품번호 + "," + 제품명 + "," + 재고량 + "," + 단가 + "," + 제조업체 + "]";
	}
	
	
	
}
