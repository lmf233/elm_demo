package com.lmf.elm.service.impl;

import com.lmf.elm.dao.BusinessDao;
import com.lmf.elm.dao.FoodDao;
import com.lmf.elm.dao.factory.BusinessDaoFactory;
import com.lmf.elm.dao.factory.FoodDaoFactory;
import com.lmf.elm.service.FoodService;
import com.lmf.elm.util.DBUtil;
import com.lmf.elm.vo.Business;
import com.lmf.elm.vo.Food;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class FoodServiceImpl implements FoodService {
    Connection conn = DBUtil.getConnection();
    @Override
    public List<Food> findFoodsByBusinessId(int businessId) {
        List<Food> foodList = new ArrayList<>();
        FoodDao dao = FoodDaoFactory.getFoodDao();
        try {
            DBUtil.beginTransaction();
            foodList = dao.getFoodsByBusinessId(conn,businessId);
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
        return foodList;
    }
}
