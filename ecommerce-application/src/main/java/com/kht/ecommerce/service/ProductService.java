package com.kht.ecommerce.service;

import com.kht.ecommerce.dto.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void addProduct();
}
