package com.springbook.biz;

import org.springframework.stereotype.Component;

//@Component("apple")
public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {
		System.out.println("apple--按眉积己");
	}
	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker--- 家府臭烙");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("AppleSpeaker--- 家府临烙");
	}

}
