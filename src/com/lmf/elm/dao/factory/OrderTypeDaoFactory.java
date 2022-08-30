package com.lmf.elm.dao.factory;

import com.lmf.elm.dao.OrderTypeDao;
import com.lmf.elm.dao.impl.OrderTypeDaoImpl;

public class OrderTypeDaoFactory {
    public static OrderTypeDao getOrderTypeDao(){
        return new OrderTypeDaoImpl();
    }
}
