package com.lmf.elm.dao;

import com.lmf.elm.vo.DeliveryAddress;

import java.sql.Connection;

public interface DeliveryAddressDao {
    DeliveryAddress getDeliveryAddressByUserId(Connection conn,int userId)throws Exception;

    int insertDeliveryAddress(Connection conn, DeliveryAddress deliveryAddress)throws Exception;
    int updateDeliveryAddress(Connection conn, DeliveryAddress deliveryAddress)throws Exception;

}
