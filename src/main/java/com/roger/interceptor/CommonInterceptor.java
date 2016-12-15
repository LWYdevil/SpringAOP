package com.roger.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.roger.bean.User;
import com.roger.jms.QueueProvider;

/**
 * 自定义拦截器，每一个http请求发送一次消息
 * @author luo
 *
 */
public class CommonInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private QueueProvider queueProvider;
	
	@Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        System.out.println("CommonInterceptor拦截器: preHandle");
        ActiveMQObjectMessage message = new ActiveMQObjectMessage();
        message.setObject(new User("roger"));
        queueProvider.send(message);
        
        return super.preHandle(request, response, handler);
    }

}
