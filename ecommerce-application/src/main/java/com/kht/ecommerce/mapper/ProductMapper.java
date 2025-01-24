package com.kht.ecommerce.mapper;

import com.kht.ecommerce.dto.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
    public interface ProductMapper {
        List<Product> getAllProducts();
        void addProduct();
        void updateProduct();
}
