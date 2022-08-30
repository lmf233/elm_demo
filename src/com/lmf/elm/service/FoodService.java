package com.lmf.elm.service;

import com.lmf.elm.vo.Food;

import java.util.List;

public interface FoodService {
    List<Food> findFoodsByBusinessId(int businessId);
}
