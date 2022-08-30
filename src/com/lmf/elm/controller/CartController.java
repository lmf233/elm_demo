package com.lmf.elm.controller;

import com.lmf.elm.service.CartService;
import com.lmf.elm.service.impl.CartServiceImpl;
import com.lmf.elm.vo.Cart;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class CartController {
    public int saveCart(HttpServletRequest req){
        CartService cs = new CartServiceImpl();
        Cart cart = new Cart();
        cart.setFoodId(Integer.parseInt(req.getParameter("foodId")));
        cart.setBusinessId(Integer.parseInt(req.getParameter("businessId")));
        cart.setUserId(req.getParameter("userId"));
        cart.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        return cs.insertCart(cart);
    }
    public int changeCart(HttpServletRequest req){
        CartService cs = new CartServiceImpl();
        Cart cart = new Cart();
        cart.setFoodId(Integer.parseInt(req.getParameter("foodId")));
        cart.setBusinessId(Integer.parseInt(req.getParameter("businessId")));
        cart.setUserId(req.getParameter("userId"));
        cart.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        return cs.updateCart(cart);
    }
    public int removeCart(HttpServletRequest req){
        CartService cs = new CartServiceImpl();
        Cart cart = new Cart();
        cart.setFoodId(Integer.parseInt(req.getParameter("foodId")));
        cart.setBusinessId(Integer.parseInt(req.getParameter("businessId")));
        cart.setUserId(req.getParameter("userId"));
        cart.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        return cs.deleteCart(cart);
    }
    public List<Cart> findCartsByBusinessIdAndUserId(HttpServletRequest req){
        CartService cs = new CartServiceImpl();
        int businessId = Integer.parseInt(req.getParameter("businessId"));
        String userId = req.getParameter("userId");
        return cs.getCartsByBusinessIdAndUserId(businessId,userId);
    }

}
