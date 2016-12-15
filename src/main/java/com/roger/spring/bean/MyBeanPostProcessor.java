package com.roger.spring.bean;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	public Object postProcessBeforeInstantiation(Class<?> beanClass,
			String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean postProcessAfterInstantiation(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		return true;
	}

	public PropertyValues postProcessPropertyValues(PropertyValues pvs,
			PropertyDescriptor[] pds, Object bean, String beanName)
			throws BeansException {
		System.out.print("Object="+bean+"  String="+beanName+"  PropertyValues="+pvs);
		for(PropertyDescriptor pd : pds){
			System.out.print("PropertyDescriptor="+pd);
		}
		System.out.println();
		return pvs;
	}

	

}
