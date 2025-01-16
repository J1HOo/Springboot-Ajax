package com.kh.AjaxSpringProject.controller;

import com.kh.AjaxSpringProject.service.CafeService;
import com.kh.AjaxSpringProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// ---------------------------- INDEX -----------------------------------------------
@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Ajax 와 별개로 /detail/원하는회원정보번호를 통해서
    // userInfo.html을 보여줄 수 있도록 설정하는 controller
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUserId(id));

        return "userInfo";
    }

// ---------------------------- CAFE -----------------------------------------------

    @Autowired
    private CafeService cafeService;

    @GetMapping("/cafe")
    public String cafe() {
        return "cafe";
    }

    @GetMapping("/cafe/detail/{id}")
    public String cafeDetail(@PathVariable int id, Model model) {
        model.addAttribute("cafe", cafeService.getCafeId(id));

        return "cafeDetail";
    }

// ---------------------------- AVATAR -----------------------------------------------

    @GetMapping("/avatar")
    public String avatar() {
        return "Avatar";
    }
}
