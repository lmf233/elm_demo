package com.lmf.elm.service.impl;

import com.lmf.elm.dao.CartDao;
import com.lmf.elm.dao.UserDao;
import com.lmf.elm.dao.factory.CartDaoFactory;
import com.lmf.elm.dao.factory.UserDaoFactory;
import com.lmf.elm.service.CartService;
import com.lmf.elm.util.DBUtil;
import com.lmf.elm.vo.Cart;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartServiceImpl implements CartService {
    Connection conn = DBUtil.getConnection();
    @Override
    public int insertCart(Cart cart) {
        int result = 0;
        CartDao dao = CartDaoFactory.getCartDao();
        try {
            DBUtil.beginTransaction();
            result  = dao.saveCart(this.conn,cart);
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

    @Override
    public int updateCart(Cart cart) {
        int result = 0;
        CartDao dao = CartDaoFactory.getCartDao();
        try {
            DBUtil.beginTransaction();
            result  = dao.changeCart(this.conn,cart);
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

    @Override
    public int deleteCart(Cart cart) {
        int result = 0;
        CartDao dao = CartDaoFactory.getCartDao();
        try {
            DBUtil.beginTransaction();
            result  = dao.removeCart(this.conn,cart);
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

    @Override
    public List<Cart> getCartsByBusinessIdAndUserId(int businessId, String userId) {
        List<Cart> cartList = new ArrayList<>();
        CartDao dao = CartDaoFactory.getCartDao();
        try {
            DBUtil.beginTransaction();
            cartList  = dao.getCartsByBusinessIdAndUserId(this.conn,businessId,userId);
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
        return cartList;
    }

}
