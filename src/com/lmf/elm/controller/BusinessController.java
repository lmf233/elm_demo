package com.lmf.elm.controller;

import com.lmf.elm.service.BusinessService;
import com.lmf.elm.service.impl.BusinessServiceImpl;
import com.lmf.elm.vo.Business;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BusinessController {
    public String findList(HttpServletRequest req){
        System.out.println("查询所有商家信息");
        return "hello";
    }
    public List<Business> findById(HttpServletRequest req) {
        int orderTypeId = Integer.parseInt(req.getParameter("id"));
        BusinessService bs = new BusinessServiceImpl();
        List<Business> businessList = bs.findBusinessesByOrderTypeId(orderTypeId);
        return businessList;
    }
    public Business findByBusinessId(HttpServletRequest req) {
        int businessId = Integer.parseInt(req.getParameter("id"));
        BusinessService bs = new BusinessServiceImpl();
        Business business = bs.findBusinessById(businessId);
        return business;
    }

}