package com.springbook.biz;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{
	public SonySpeaker() {
		System.out.println("Sony ��ü����");
	}
	public void volumeUp() {
		System.out.println("<-- �Ҹ� �ø���.");
	}
	public void volumeDown() {
		System.out.println("<-- �Ҹ� ������.");
	}
}
