package com.lmf.elm.dao.impl;

import com.lmf.elm.dao.BusinessDao;
import com.lmf.elm.util.DBUtil;
import com.lmf.elm.vo.Business;
import com.lmf.elm.vo.OrderType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {
    @Override
    public List<Business> getBusinessesByOrderTypeId(Connection conn,int orderTypeId) throws Exception {
        List<Business> businessList = new ArrayList<>();
        String sql = "SELECT * FROM business WHERE orderTypeId=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,orderTypeId);
            rs = ps.executeQuery();
            while(rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setBusinessImg(rs.getString("businessImg"));
                business.setOrderTypeId(orderTypeId);
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                business.setRemarks(rs.getString("remarks"));
                System.out.println(business);
                businessList.add(business);
            }
        }finally {
            DBUtil.close(rs,ps);
        }
        return businessList;
    }

    @Override
    public Business getBusinessById(Connection conn,int businessId) throws Exception {
        Business business = null;
        String sql = "SELECT * FROM business WHERE businessId=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,businessId);
            rs = ps.executeQuery();
            while(rs.next()){
                business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setBusinessImg(rs.getString("businessImg"));
                business.setOrderTypeId(rs.getInt("orderTypeId"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                business.setRemarks(rs.getString("remarks"));
            }
        }finally {
            DBUtil.close(rs,ps);
        }
        return business;
    }
}
