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
		System.out.println("SamsungTV ��ü����");
	}
	public SamsungTV(Speaker speaker) {
		System.out.println("SamsungTV2 ��ü����");
		this.speaker = speaker;
	}
	public SamsungTV(Speaker speaker,int price) {
		System.out.println("SamsungTV3 ��ü����");
		this.speaker = speaker;
		this.price = price;
	}

	public void initMethod() {
		System.out.println("��ü �ʱ�ȭ �۾���...");
	}
	public void destroyMethod() {
		System.out.println("��ü ���� �۾���...");
	}
	public void powerOn() {
		System.out.println("SamsungTV---����Ų�� ����:"+price);
	}
	public void powerOff() {
		System.out.println("SamsungTV---��������");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
