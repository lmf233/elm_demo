package com.lmf.elm.controller;

import com.lmf.elm.service.OrderTypeService;
import com.lmf.elm.service.impl.OrderTypeServiceImpl;
import com.lmf.elm.vo.OrderType;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OrderTypeController {
    OrderTypeService os = new OrderTypeServiceImpl();
    public List<com.lmf.elm.vo.OrderType> findOrderTypeList(HttpServletRequest req){
        List<com.lmf.elm.vo.OrderType> orderTypeList = this.os.findOrderTypes();
        return orderTypeList;
    }
}
