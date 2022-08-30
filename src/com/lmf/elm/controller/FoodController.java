package com.lmf.elm.controller;

import com.lmf.elm.service.BusinessService;
import com.lmf.elm.service.FoodService;
import com.lmf.elm.service.impl.BusinessServiceImpl;
import com.lmf.elm.service.impl.FoodServiceImpl;
import com.lmf.elm.vo.Business;
import com.lmf.elm.vo.Food;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FoodController {
    public List<Food> findFoodsById(HttpServletRequest req) {
        int businessId = Integer.parseInt(req.getParameter("id"));
        FoodService fs = new FoodServiceImpl();
        List<Food> foodList = fs.findFoodsByBusinessId(businessId);
        return foodList;
    }
}
