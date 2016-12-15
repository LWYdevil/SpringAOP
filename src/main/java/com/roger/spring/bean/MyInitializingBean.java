package com.roger.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component("myinit")
public class MyInitializingBean implements InitializingBean,ApplicationContextAware{
	
	private ApplicationContext applicationContext;

	public void afterPropertiesSet() throws Exception {
		Long date = applicationContext.getStartupDate();
		
		MessageSource resources = (MessageSource)applicationContext.getBean("messageSource");
		String msg = resources.getMessage("common.button.login", null, null);
		
		System.out.println("applicationContext start date :"+date);
		System.out.println(msg);
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		
	}

}
