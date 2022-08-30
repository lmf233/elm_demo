package com.lmf.elm.service.impl;

import com.lmf.elm.dao.BusinessDao;
import com.lmf.elm.dao.UserDao;
import com.lmf.elm.dao.factory.BusinessDaoFactory;
import com.lmf.elm.dao.factory.UserDaoFactory;
import com.lmf.elm.service.UserService;
import com.lmf.elm.util.DBUtil;
import com.lmf.elm.vo.Business;
import com.lmf.elm.vo.User;

import java.sql.Connection;

public class UserServiceImpl implements UserService {
    Connection conn = DBUtil.getConnection();
    @Override
    public User findUserByUserIdAndPassword(String userId, String password) {
        User user = null;
        UserDao dao = UserDaoFactory.getUserDao();
        try {
            DBUtil.beginTransaction();
            user = dao.getUserByUserIdAndPassword(this.conn, userId, password);
            DBUtil.commitTransaction();
        } catch (Exception e) {
            try {
                DBUtil.rollbackTransaction();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return user;
    }
    @Override
    public int registerUser(User user) {
        int result = 0;
        UserDao dao = UserDaoFactory.getUserDao();
        try {
            DBUtil.beginTransaction();
            if(dao.getUserByUserId(this.conn,user.getUserId())==null){
                result  = dao.saveUser(this.conn, user);
            }else {
                System.out.println("该用户已存在");
            }
            DBUtil.commitTransaction();
        } catch (Exception e) {
            try {
                DBUtil.rollbackTransaction();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }
}
