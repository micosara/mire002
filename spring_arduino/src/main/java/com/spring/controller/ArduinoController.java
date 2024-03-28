package com.spring.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArduinoController {

	@GetMapping("/camera/stream")
	public void camera() {}
	
	@GetMapping("/led/form")
	public String form() {
		String url = "/arduinoForm";

		return url;
	}

	@GetMapping("/motorForm")
	public String motor_form() {
		String url = "motorForm";
		return url;
	}
	@GetMapping("/motor/{direct}")
	@ResponseBody
	public String motor(@PathVariable("direct") String direct) {
		String result="";
		System.out.println(direct);
		String url = "/motor/"+direct;
		String method ="GET";
		
		HttpURLConnection conn = getHttpURLConnection(url,method);

		result = getHttpRespons(conn);
		
		return result;
	}
	
	@GetMapping("/led/built_in/{num}")
	@ResponseBody
	public String built_in(@PathVariable int num) {
		String result = "";
		
		System.out.println(num);
		String url = "/led/built_in/"+num;
		String method = "GET";
		HttpURLConnection conn = getHttpURLConnection(url,method);

		result = getHttpRespons(conn);
		 
		return result;
	}

	public HttpURLConnection getHttpURLConnection(String target_url, String method) {
		HttpURLConnection conn = null;
		URL url = null;
		String arduinoIP = "192.168.137.100";
		try {

			url = new URL("http://" + arduinoIP+target_url);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(method); // Method 방식 설정.
			conn.setConnectTimeout(5000);
			conn.setRequestProperty("Content-Type", "text/html;charset=UTF-8");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return conn;
	}

	private String getHttpRespons(HttpURLConnection conn) {
		String result = null;

		try {
			if (conn.getResponseCode() == 200) { // 정상적으로 데이터를 받았을 경우
				result = "http 200 OK";
			} else { // 에러 응답인경우
				result = conn.getResponseCode()+"\n";
				result += conn.getResponseMessage();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			conn.disconnect(); //연결 해제
		}
		
		return result;
	}
}
