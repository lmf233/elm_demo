package com.lmf.elm.dao.impl;

import com.lmf.elm.dao.DeliveryAddressDao;
import com.lmf.elm.util.DBUtil;
import com.lmf.elm.vo.DeliveryAddress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeliveryAddressDaoImpl implements DeliveryAddressDao {
    @Override
    public DeliveryAddress getDeliveryAddressByUserId(Connection conn, int userId) throws Exception {
        DeliveryAddress deliveryAddress = null;
        String sql = "SELECT * FROM deliveryaddress WHERE userId = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userId);
            rs=ps.executeQuery();
            while(rs.next()){
                deliveryAddress = new DeliveryAddress();
                deliveryAddress.setDaId(rs.getInt("daId"));
                deliveryAddress.setContactName(rs.getString("contactName"));
                deliveryAddress.setContactSex(rs.getInt("contactSex"));
                deliveryAddress.setContactTel(rs.getString("contactTel"));
                deliveryAddress.setAddress(rs.getString("address"));
                deliveryAddress.setUserId(userId);
            }
        }finally {
            DBUtil.close(rs,ps);
        }
        return deliveryAddress;
    }

    @Override
    public int insertDeliveryAddress(Connection conn, DeliveryAddress deliveryAddress) throws Exception{
        int result = 0;
        String sql = "INSERT INTO deliveryaddress VALUES(NULL,?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,deliveryAddress.getContactName());
            ps.setInt(2,deliveryAddress.getContactSex());
            ps.setString(3,deliveryAddress.getContactTel());
            ps.setString(4,deliveryAddress.getAddress());
            ps.setInt(5,deliveryAddress.getUserId());
            result = ps.executeUpdate();
        }finally {
            DBUtil.close(ps);
        }
        return result;
    }
    @Override
    public int updateDeliveryAddress(Connection conn, DeliveryAddress deliveryAddress) throws Exception{
        int result = 0;
        String sql = "UPDATE deliveryaddress SET contactName = ?, contactSex = ?,contactTel=?,address=? WHERE userId = ?";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,deliveryAddress.getContactName());
            ps.setInt(2,deliveryAddress.getContactSex());
            ps.setString(3,deliveryAddress.getContactTel());
            ps.setString(4,deliveryAddress.getAddress());
            ps.setInt(5,deliveryAddress.getUserId());
            result = ps.executeUpdate();
        }finally {
            DBUtil.close(ps);
        }
        return result;
    }
}
