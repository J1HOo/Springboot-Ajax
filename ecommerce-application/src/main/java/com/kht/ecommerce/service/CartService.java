package com.kht.ecommerce.service;

import com.kht.ecommerce.dto.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getCartByUserId(int userId);
}
