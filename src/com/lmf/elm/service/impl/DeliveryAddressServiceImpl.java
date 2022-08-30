package com.lmf.elm.service.impl;

import com.lmf.elm.dao.DeliveryAddressDao;
import com.lmf.elm.dao.UserDao;
import com.lmf.elm.dao.factory.DeliveryDaoFactory;
import com.lmf.elm.dao.factory.UserDaoFactory;
import com.lmf.elm.service.DeliveryAddressService;
import com.lmf.elm.util.DBUtil;
import com.lmf.elm.vo.DeliveryAddress;
import com.lmf.elm.vo.User;

import java.sql.Connection;

public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    Connection conn = DBUtil.getConnection();
    @Override
    public DeliveryAddress findDeliveryByUserId(int userId) {
        DeliveryAddress deliveryAddress = null;
        DeliveryAddressDao dao = DeliveryDaoFactory.getDeliveryAddressDao();
        try {
            DBUtil.beginTransaction();
            deliveryAddress = dao.getDeliveryAddressByUserId(this.conn, userId);
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
        return deliveryAddress;
    }

    @Override
    public int addDeliveryAddress(DeliveryAddress deliveryAddress) {
        int result = 0;
        DeliveryAddressDao dao = DeliveryDaoFactory.getDeliveryAddressDao();
        try {
            DBUtil.beginTransaction();
            result = dao.insertDeliveryAddress(this.conn, deliveryAddress);
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
    public int changeDeliveryAddress(DeliveryAddress deliveryAddress) {
        int result = 0;
        DeliveryAddressDao dao = DeliveryDaoFactory.getDeliveryAddressDao();
        try {
            DBUtil.beginTransaction();
            result = dao.updateDeliveryAddress(this.conn, deliveryAddress);
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
