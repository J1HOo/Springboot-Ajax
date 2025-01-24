package com.kht.ecommerce.service;

import com.kht.ecommerce.dto.User;

import java.util.List;

public interface UserService {

    // 사용자 목록 조회
    List<User> getAllUsers();

    // 사용자 저장
    void insertUser(User user);

    // 이메일 존재 유무 확인
    // Map<String, Object> existByEmail(String email);
    boolean existByEmail(String email);

    User getByUserId(int id);
}
