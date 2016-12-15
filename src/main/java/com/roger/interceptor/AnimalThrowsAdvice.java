package com.roger.interceptor;

import org.springframework.aop.ThrowsAdvice;

import javax.servlet.ServletException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;

/**
 * Created by luoweiyi on 2016/12/9.
 */
public class AnimalThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(RemoteException ex) throws Throwable {

    }

    public void afterThrowing(Method m, Object[] args, Object target, ServletException ex) {

    }
}
