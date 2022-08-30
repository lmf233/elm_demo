package com.lmf.elm.dao;

import com.lmf.elm.vo.User;

import java.sql.Connection;

public interface UserDao {
    User getUserByUserIdAndPassword(Connection conn,String userId,String password)throws Exception;
    int saveUser(Connection conn,User user)throws Exception;
    User getUserByUserId(Connection conn,String userId)throws Exception;
}
