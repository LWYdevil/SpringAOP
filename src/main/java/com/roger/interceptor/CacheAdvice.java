package com.roger.interceptor;

import com.roger.util.CacheUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by luoweiyi on 2016/12/14.
 */
public class CacheAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        String key = methodInvocation.getThis().getClass().toString() +"_"+ methodInvocation.getMethod().getName();
        Object[] args = methodInvocation.getArguments();
        if(args != null){
            for(Object arg : args){
                key += arg.toString();
            }
        }
        if(CacheUtils.containsKey(key)){
            return CacheUtils.get(key);
        }

        Object retVal = methodInvocation.proceed();
        if(retVal != null){
            CacheUtils.put(key,retVal);
        }

        return retVal;
    }
}
