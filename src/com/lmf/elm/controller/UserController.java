package com.lmf.elm.controller;

import com.lmf.elm.service.UserService;
import com.lmf.elm.service.impl.UserServiceImpl;
import com.lmf.elm.vo.User;

import javax.servlet.http.HttpServletRequest;

public class UserController {
    public User findUserByUserIdAndPassword(HttpServletRequest req){
        User user = new User();
        UserService us = new UserServiceImpl();
        String userId = req.getParameter("uid");
        String password = req.getParameter("password");
        return us.findUserByUserIdAndPassword(userId,password);
    }
    public int registerUser(HttpServletRequest req){
        int result = 0;
        UserService us = new UserServiceImpl();
        String userId = req.getParameter("uid");
        String password = req.getParameter("password");
        String userName = req.getParameter("userName");
        int sex = Integer.parseInt(req.getParameter("sex"));
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        user.setUserName(userName);
        user.setUserSex(sex);
        result = us.registerUser(user);
        return result;
    }
}
