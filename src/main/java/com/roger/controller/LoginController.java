package com.roger.controller;

import com.roger.bean.User;
import com.roger.util.SessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by zx on 2017/4/5.
 */
@Controller
public class LoginController {

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request,HttpServletResponse response,String name){

        return "/login";
    }

    @RequestMapping(value="/doLogin",method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request,HttpServletResponse response,User user){

        if(!SessionUtils.isLogin(request)) {
            SessionUtils.login(request, user);
        }
        return "/login";
    }
}
