package com.kh.AjaxProject.controller;


import com.kh.AjaxProject.service.MemberSerivce;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
//@RestController // -> json backend 형식 설정
public class MemberController {

    @Autowired
    private MemberSerivce memberSerivce;

    // ResponseEntity 제대로 데이터를 전달했는지 확인
    /**
     * ResponseEntity<>
     *     ResponseEntity.ok();
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
/*
    @GetMapping("/api/members")
    public  List<Member> getAllMembers() {
        return memberSerivce.getAllMembers()   ;
    }

 */
}
