package com.lmf.elm.dao.factory;

import com.lmf.elm.dao.BusinessDao;
import com.lmf.elm.dao.impl.BusinessDaoImpl;

public class BusinessDaoFactory {
    public static BusinessDao getBusinessDao(){
        return new BusinessDaoImpl();
    }
}
