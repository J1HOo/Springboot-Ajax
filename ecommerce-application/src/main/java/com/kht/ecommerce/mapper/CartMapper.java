package com.kht.ecommerce.mapper;

import com.kht.ecommerce.dto.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    List<Cart> getCartByUserId(int userId);
}
