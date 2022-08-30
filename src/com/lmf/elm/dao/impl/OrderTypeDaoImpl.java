package com.lmf.elm.dao.impl;

import com.lmf.elm.dao.OrderTypeDao;
import com.lmf.elm.util.DBUtil;
import com.lmf.elm.vo.OrderType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderTypeDaoImpl implements OrderTypeDao {
    @Override
    public List<OrderType> getOrderTypes(Connection conn) throws Exception{
        List<OrderType> orderTypeList = new ArrayList<>();
        String sql = "SELECT * FROM ordertype";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                OrderType orderType = new OrderType();
                orderType.setOrderTypeId(rs.getInt(1));
                orderType.setOrderTypeImg(rs.getString(2));
                orderType.setOrderTypeName(rs.getString(3));
                orderTypeList.add(orderType);
            }
        }finally {
            DBUtil.close(rs,ps);
        }
        return orderTypeList;
    }
}
