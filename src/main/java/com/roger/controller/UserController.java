package com.roger.controller;

import com.roger.bean.User;
import com.roger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zx on 2017/3/13.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/addUser",method = RequestMethod.GET)
    public String addUser(HttpServletRequest request,HttpServletResponse response,String name){
        userService.insert(new User(3l,name));
        return "/print";
    }
}
