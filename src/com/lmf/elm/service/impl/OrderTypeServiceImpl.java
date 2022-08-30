package com.lmf.elm.service.impl;

import com.lmf.elm.dao.OrderTypeDao;
import com.lmf.elm.dao.factory.OrderTypeDaoFactory;
import com.lmf.elm.service.OrderTypeService;
import com.lmf.elm.util.DBUtil;
import com.lmf.elm.vo.OrderType;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class OrderTypeServiceImpl implements OrderTypeService {
    Connection conn = DBUtil.getConnection();
    @Override
    public List<OrderType> findOrderTypes() {
        List<OrderType> orderTypeList = new ArrayList<>();
        OrderTypeDao dao = OrderTypeDaoFactory.getOrderTypeDao();
        try {
            DBUtil.beginTransaction();
            orderTypeList = dao.getOrderTypes(conn);
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
        return orderTypeList;
    }
}
