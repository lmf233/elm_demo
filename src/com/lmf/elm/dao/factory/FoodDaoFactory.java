package com.lmf.elm.dao.factory;

import com.lmf.elm.dao.FoodDao;
import com.lmf.elm.dao.impl.FoodDaoImpl;

public class FoodDaoFactory {
    public static FoodDao getFoodDao(){
        return new FoodDaoImpl();
    }
}
