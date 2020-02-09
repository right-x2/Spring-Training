package com.springbook.biz;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{
	public SonySpeaker() {
		System.out.println("Sony 按眉积己");
	}
	public void volumeUp() {
		System.out.println("<-- 家府 棵赴促.");
	}
	public void volumeDown() {
		System.out.println("<-- 家府 郴赴促.");
	}
}
