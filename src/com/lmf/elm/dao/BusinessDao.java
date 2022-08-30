package com.lmf.elm.dao;

import com.lmf.elm.vo.Business;

import java.sql.Connection;
import java.util.List;

public interface BusinessDao {
    List<Business> getBusinessesByOrderTypeId(Connection conn,int orderTypeId) throws Exception;
    Business getBusinessById(Connection conn,int businessId) throws Exception;
}
