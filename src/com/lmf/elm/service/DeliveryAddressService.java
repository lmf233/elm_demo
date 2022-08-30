package com.lmf.elm.service;

import com.lmf.elm.vo.DeliveryAddress;

public interface DeliveryAddressService {
    DeliveryAddress findDeliveryByUserId(int userId);

    int addDeliveryAddress(DeliveryAddress deliveryAddress);
    int changeDeliveryAddress(DeliveryAddress deliveryAddress);
}
