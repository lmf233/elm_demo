package com.lmf.elm.dao.factory;

import com.lmf.elm.dao.UserDao;
import com.lmf.elm.dao.impl.UserDaoImpl;

public class UserDaoFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
