package com.lmf.elm.dao;

import com.lmf.elm.vo.Food;

import java.sql.Connection;
import java.util.List;

public interface FoodDao {
    List<Food> getFoodsByBusinessId(Connection conn,int businessId)throws Exception;
}
