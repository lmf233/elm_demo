package com.lmf.elm.dao.factory;

import com.lmf.elm.dao.OrderDao;
import com.lmf.elm.dao.impl.OrderDaoImpl;

public class OrderDaoFactory {
    public static OrderDao getOrderDao(){
        return new OrderDaoImpl();
    }
}
