package com.kht.ecommerce.controller;

// view -> html 파일 바라보기
// rest -> backend가 db에서 가져온 데이터를 url 주소값으로 전달만 하는 상태

import com.kht.ecommerce.dto.Product;
import com.kht.ecommerce.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UDController {

    @Autowired
    ProductServiceImpl productService;

    // 제품 업데이트
    @PutMapping("/update/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        productService.updateProduct();
    }
}