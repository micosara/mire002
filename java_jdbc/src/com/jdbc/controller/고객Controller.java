package com.jdbc.controller;

import java.util.List;

import com.jdbc.dto.고객VO;
import com.jdbc.service.Service;
import com.jdbc.service.고객Service;

public class 고객Controller {

	private Service service = new 고객Service();
	
	public void list() {
		try {
			List<고객VO> 고객리스트 = service.list();
			

			for(int i=0;i<고객리스트.size();i++) {
				고객VO 고객 = 고객리스트.get(i);
				System.out.println(고객);
			}
			
		} catch (Exception e) {
			System.out.println("서버장애로 인해 서비스가 불가합니다.");
		}
	}
}




