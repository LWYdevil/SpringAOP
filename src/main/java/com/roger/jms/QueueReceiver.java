package com.roger.jms;

import org.springframework.jms.core.JmsTemplate;

import com.roger.bean.User;

public class QueueReceiver{
	
	private JmsTemplate jmsTemplate;
	
	private String destination;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	//receive中的参数很神奇，在监听器中对接收到的消息转换成对应的对象，然后回调receive这个方法，并将对象传入该方法
	public void receive(User user){
		System.out.println("接收到user名字是："+user.getName());
	}
}
