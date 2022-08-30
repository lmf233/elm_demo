package com.lmf.elm.dao.impl;

import com.lmf.elm.dao.FoodDao;
import com.lmf.elm.util.DBUtil;
import com.lmf.elm.vo.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    @Override
    public List<Food> getFoodsByBusinessId(Connection conn, int businessId) throws Exception {
        List<Food> foodList = new ArrayList<>();
        String sql = "SELECT * FROM food WHERE businessId=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,businessId);
            rs = ps.executeQuery();
            while(rs.next()){
                Food food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodImg(rs.getString("foodImg"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(businessId);
                food.setRemarks(rs.getString("remarks"));
                foodList.add(food);
            }
        }finally {
            DBUtil.close(rs,ps);
        }
        return foodList;
    }
}
