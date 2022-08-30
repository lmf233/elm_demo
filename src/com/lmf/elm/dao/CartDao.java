package com.lmf.elm.dao;

import com.lmf.elm.vo.Cart;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface CartDao {
    int saveCart(Connection conn, Cart cart) throws Exception;
    int changeCart(Connection conn,Cart cart) throws Exception;
    int removeCart(Connection conn,Cart cart) throws Exception;
    List<Cart> getCartsByBusinessIdAndUserId(Connection conn,int businessId,String userId)throws Exception;
}
