package com.springbook.biz;

public class SamsungTV implements TV{
	
	private Speaker speaker;
	private int price;
	public void setSpeaker(Speaker speaker) {
		System.out.println("setter speaker");
		this.speaker = speaker;
	}
	public void setPrice(int price) {
		System.out.println("setter price");
		this.price = price;
	}
	public SamsungTV() {
		System.out.println("SamsungTV 객체생성");
	}
	public SamsungTV(Speaker speaker) {
		System.out.println("SamsungTV2 객체생성");
		this.speaker = speaker;
	}
	public SamsungTV(Speaker speaker,int price) {
		System.out.println("SamsungTV3 객체생성");
		this.speaker = speaker;
		this.price = price;
	}

	public void initMethod() {
		System.out.println("객체 초기화 작업중...");
	}
	public void destroyMethod() {
		System.out.println("객체 삭제 작업중...");
	}
	public void powerOn() {
		System.out.println("SamsungTV---전원킨다 가격:"+price);
	}
	public void powerOff() {
		System.out.println("SamsungTV---전원끈다");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
