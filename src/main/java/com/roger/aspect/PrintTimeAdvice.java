package com.roger.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import com.roger.annotation.PrintTime;

public class PrintTimeAdvice{

	public Object printTime(ProceedingJoinPoint pjp,PrintTime printTime){
		Object retVal = null;
		Long start = System.currentTimeMillis();
		try {
			retVal = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(printTime.serviceName()+"###"+printTime.methodName()+"###"+(System.currentTimeMillis()-start)+"###");
		return retVal;
	}
}
