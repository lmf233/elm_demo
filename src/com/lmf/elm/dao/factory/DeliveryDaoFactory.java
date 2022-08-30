package com.lmf.elm.dao.factory;

import com.lmf.elm.dao.DeliveryAddressDao;
import com.lmf.elm.dao.impl.DeliveryAddressDaoImpl;

public class DeliveryDaoFactory {
    public static DeliveryAddressDao getDeliveryAddressDao(){
        return new DeliveryAddressDaoImpl();
    }
}
