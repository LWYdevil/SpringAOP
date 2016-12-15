package com.roger.jms;

import org.apache.activemq.Message;
import org.springframework.jms.core.JmsTemplate;

public class QueueProvider {
	
	private String destination;
	
	private JmsTemplate jmsTemplate;

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void send(Message message){
		System.out.println("send message!");
		jmsTemplate.convertAndSend(destination, message);
	}

}
