package com.lmf.elm.service;

import com.lmf.elm.vo.Cart;

import java.util.List;
import java.util.Map;

public interface CartService {
    int insertCart(Cart cart);
    int updateCart(Cart cart);
    int deleteCart(Cart cart);
    List<Cart> getCartsByBusinessIdAndUserId(int businessId,String userId);
}
