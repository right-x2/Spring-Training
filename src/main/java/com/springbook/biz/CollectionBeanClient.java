package com.springbook.biz;

import java.util.List;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.springbook.biz.CollectionBean;

public class CollectionBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBean bean = (CollectionBean)  factory.getBean("collectionBean");
		
		Set<String> addressList =  bean.getAddressList();
		
		for(String adress : addressList) {
			System.out.println(adress);
		}
		
		factory.close();
		
	}
}
