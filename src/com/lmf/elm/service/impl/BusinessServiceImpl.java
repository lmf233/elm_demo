package com.lmf.elm.service.impl;

import com.lmf.elm.dao.BusinessDao;
import com.lmf.elm.dao.OrderTypeDao;
import com.lmf.elm.dao.factory.BusinessDaoFactory;
import com.lmf.elm.dao.factory.OrderTypeDaoFactory;
import com.lmf.elm.service.BusinessService;
import com.lmf.elm.util.DBUtil;
import com.lmf.elm.vo.Business;
import com.lmf.elm.vo.OrderType;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class BusinessServiceImpl implements BusinessService {
    Connection conn = DBUtil.getConnection();
    @Override
    public List<Business> findBusinessesByOrderTypeId(int orderTypeId) {
        List<Business> businessList = new ArrayList<>();
        BusinessDao dao = BusinessDaoFactory.getBusinessDao();
        try {
            DBUtil.beginTransaction();
            businessList = dao.getBusinessesByOrderTypeId(conn,orderTypeId);
            DBUtil.commitTransaction();
        } catch (Exception e) {
            try {
                DBUtil.rollbackTransaction();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return businessList;
    }
    @Override
    public Business findBusinessById(int businessId) {
        Business business = null;
        BusinessDao dao = BusinessDaoFactory.getBusinessDao();
        try {
            DBUtil.beginTransaction();
            business = dao.getBusinessById(conn,businessId);
            DBUtil.commitTransaction();
        } catch (Exception e) {
            try {
                DBUtil.rollbackTransaction();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return business;
    }
}
