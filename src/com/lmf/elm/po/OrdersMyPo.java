package com.lmf.elm.po;

import com.lmf.elm.vo.OrderDetailet;
import com.lmf.elm.vo.Orders;

import java.util.List;

public class OrdersMyPo {
    private Integer orderId;
    private String userId;
    private String businessName;
    private String orderDate;
    private Double orderTotal;
    private Integer daId;
    private Integer orderState;
    private List<OrdersPo> ordersPos;

    public List<OrdersPo> getOrdersPos() {
        return ordersPos;
    }

    public void setOrdersPos(List<OrdersPo> ordersPos) {
        this.ordersPos = ordersPos;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getDaId() {
        return daId;
    }

    public void setDaId(Integer daId) {
        this.daId = daId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }
}
