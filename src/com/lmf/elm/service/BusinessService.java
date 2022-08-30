package com.lmf.elm.service;

import com.lmf.elm.vo.Business;

import java.util.List;

public interface BusinessService {
    List<Business> findBusinessesByOrderTypeId(int orderTypeId);
    Business findBusinessById(int businessId);
}
