package com.kht.ecommerce.service;

import com.kht.ecommerce.dto.Cart;
import com.kht.ecommerce.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;
    @Override
    public List<Cart> getCartByUserId(int userId) {
        return cartMapper.getCartByUserId(userId);
    }
}
