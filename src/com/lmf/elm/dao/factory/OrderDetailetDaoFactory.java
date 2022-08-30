package com.lmf.elm.dao.factory;

import com.lmf.elm.dao.OrderDetailetDao;
import com.lmf.elm.dao.impl.OrderDetailetDaoImpl;
import com.lmf.elm.vo.OrderDetailet;

public class OrderDetailetDaoFactory {
    public static OrderDetailetDao getOrderDetailetDao(){
        return new OrderDetailetDaoImpl();
    }
}
