package com.roger.interceptor;

import com.roger.util.CalculateUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by luoweiyi on 2016/12/8.
 */
public class CalculateAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        Object retVal = null;
        Long start = System.currentTimeMillis();
        try {
            retVal = methodInvocation.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Long time = System.currentTimeMillis()-start;
        System.out.println(methodInvocation.getMethod().toString()+"  "+time);
        CalculateUtils.callService(methodInvocation.getMethod().toString(), time);

        return retVal;
    }
}
