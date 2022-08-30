package com.lmf.elm.dao.factory;

import com.lmf.elm.dao.CartDao;
import com.lmf.elm.dao.impl.CartDaoImpl;

public class CartDaoFactory {
    public static CartDao getCartDao(){
        return new CartDaoImpl();
    }
}
