package com.lmf.elm.controller;

import com.lmf.elm.service.DeliveryAddressService;
import com.lmf.elm.service.impl.DeliveryAddressServiceImpl;
import com.lmf.elm.vo.DeliveryAddress;

import javax.servlet.http.HttpServletRequest;

public class DeliveryAddressController {
    public DeliveryAddress findDeliveryAddress(HttpServletRequest req){
        DeliveryAddressService ds = new DeliveryAddressServiceImpl();
        int userId = Integer.parseInt(req.getParameter("id"));
        return ds.findDeliveryByUserId(userId);
    }
    public int addDeliveryAddress(HttpServletRequest req){
        DeliveryAddressService ds = new DeliveryAddressServiceImpl();
        String contactName = req.getParameter("contactName");
        int contactSex = Integer.parseInt(req.getParameter("contactSex"));
        String contactTel = req.getParameter("contactTel");
        String address = req.getParameter("address");
        int userId = Integer.parseInt(req.getParameter("userId"));
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setContactName(contactName);
        deliveryAddress.setContactSex(contactSex);
        deliveryAddress.setContactTel(contactTel);
        deliveryAddress.setAddress(address);
        deliveryAddress.setUserId(userId);
        return ds.addDeliveryAddress(deliveryAddress);
    }
    public int changeDeliveryAddress(HttpServletRequest req){
        DeliveryAddressService ds = new DeliveryAddressServiceImpl();
        String contactName = req.getParameter("contactName");
        int contactSex = Integer.parseInt(req.getParameter("contactSex"));
        String contactTel = req.getParameter("contactTel");
        String address = req.getParameter("address");
        int userId = Integer.parseInt(req.getParameter("userId"));
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setContactName(contactName);
        deliveryAddress.setContactSex(contactSex);
        deliveryAddress.setContactTel(contactTel);
        deliveryAddress.setAddress(address);
        deliveryAddress.setUserId(userId);
        return ds.changeDeliveryAddress(deliveryAddress);
    }

}
