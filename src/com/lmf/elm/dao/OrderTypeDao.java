package com.lmf.elm.dao;

import com.lmf.elm.vo.OrderType;

import java.sql.Connection;
import java.util.List;

public interface OrderTypeDao {
    List<OrderType> getOrderTypes(Connection conn) throws Exception;
}
