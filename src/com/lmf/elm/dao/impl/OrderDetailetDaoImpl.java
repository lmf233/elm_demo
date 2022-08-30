package com.lmf.elm.dao.impl;

import com.lmf.elm.dao.OrderDetailetDao;
import com.lmf.elm.util.DBUtil;
import com.lmf.elm.vo.OrderDetailet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderDetailetDaoImpl implements OrderDetailetDao {
    @Override
    public int saveDetailet(Connection conn, OrderDetailet detailet) throws Exception {
        String sql = "insert into orderdetailet values(null,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,detailet.getOrderId());
            ps.setInt(2,detailet.getFoodId());
            ps.setInt(3,detailet.getQuantity());
            ps.executeUpdate();
        }finally {
            DBUtil.close(ps);
        }
        return 1   ;
    }
}
