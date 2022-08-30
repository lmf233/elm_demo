package com.lmf.elm.dao;

import com.lmf.elm.vo.OrderDetailet;

import java.sql.Connection;

public interface OrderDetailetDao {
    int saveDetailet(Connection conn,OrderDetailet detailet) throws Exception;
}
