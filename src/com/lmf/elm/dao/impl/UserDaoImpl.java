package com.lmf.elm.dao.impl;

import com.lmf.elm.dao.UserDao;
import com.lmf.elm.util.DBUtil;
import com.lmf.elm.vo.Business;
import com.lmf.elm.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUserByUserIdAndPassword(Connection conn, String userId, String password) throws Exception {
        User user = null;
        String sql = "SELECT * FROM user WHERE userId=? AND password = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,userId);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserId(userId);
                user.setPassword(password);
                user.setUserName(rs.getString("userName"));
                user.setUserSex(rs.getInt("userSex"));
                user.setUserImg(rs.getString("userImg"));
                user.setDelTag(rs.getInt("delTag"));
            }
        }finally {
            DBUtil.close(rs,ps);
        }
        return user;
    }

    @Override
    public int saveUser(Connection conn, User user) throws Exception {
        int result = 0;
        String sql = "INSERT INTO user(userId,password,userName,userSex,userImg) VALUES(?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUserId());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getUserName());
            ps.setInt(4,user.getUserSex());
            ps.setString(5,user.getUserImg());
            result = ps.executeUpdate();
        }finally {
            DBUtil.close(ps);
        }
        return result;
    }

    @Override
    public User getUserByUserId(Connection conn, String userId) throws Exception {
        User user = null;
        String sql = "SELECT * FROM user WHERE userId=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,userId);
            rs = ps.executeQuery();
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserId(userId);
                user.setPassword(rs.getString("password"));
                user.setUserName(rs.getString("userName"));
                user.setUserSex(rs.getInt("userSex"));
                user.setUserImg(rs.getString("userImg"));
                user.setDelTag(rs.getInt("delTag"));
            }
        }finally {
            DBUtil.close(rs,ps);
        }
        return user;
    }

}
