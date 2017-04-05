package com.roger.util;

import com.roger.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by zx on 2017/4/5.
 */
public class SessionUtils {

    public static boolean isLogin(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        return httpSession.getAttribute("userId") != null;
    }

    public static void login(HttpServletRequest request,User user){
        HttpSession httpSession = request.getSession();
        httpSession.setMaxInactiveInterval(30);
        String tokenId = UUID.randomUUID().toString();
        httpSession.setAttribute("userId",tokenId);
    }
}
