package com.springbook.biz;

import org.springframework.stereotype.Component;

//@Component("apple")
public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {
		System.out.println("apple--��ü����");
	}
	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker--- �Ҹ�����");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("AppleSpeaker--- �Ҹ�����");
	}

}
