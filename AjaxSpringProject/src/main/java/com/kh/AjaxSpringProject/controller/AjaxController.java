package com.kh.AjaxSpringProject.controller;


import com.kh.AjaxSpringProject.dto.Cafe;
import com.kh.AjaxSpringProject.dto.Person;
import com.kh.AjaxSpringProject.dto.User;
import com.kh.AjaxSpringProject.service.CafeService;
import com.kh.AjaxSpringProject.service.PersonServiceImpl;
import com.kh.AjaxSpringProject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* @Controller
* 뷰(View, html)을 반환하거나 데이터와 뷰를 조합해서 클라이언트에 응답할 때 사용
* 기본 동작 : return 값이 기본으로 html 파일명으로 간주
* Model 함께 사용 : 데이터를 뷰에 전달하기 위해 Model 객체를 사용
* 직접적인 JSON 반환을 위해 @ResponseBody 를 메서드에 추가해야 함
*
* @RestController
* JSON 또는 XML 데이터를 반환하는 RESTful 웹 서비스를 작성할 때 사용
* 기본 동작 : 메서드의 반환 값이 뷰가 아니라, 데이터로 처리
* @ResponseBody가 자동으로 추가된 것처럼 작동
* 주로 API 개발에 주로 사용
* */

@Slf4j //Lombok 에서 지원하는 log = 기록
@RestController // html 파일을 바라보는 것이 아니라 데이터를 전달 전송
public class AjaxController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    public List<User> getAllUsers(){
        List<User> users = userService.getAllUsers();
        log.info(users.toString());// 데이터의 정보가 어떻게 나오는지 확인하는 info
        return users;
    }

    // id = 유동적으로 사용자가 선택하는 id값으로 변경
    // jQuery {} 를 사용해서 변수이름이나 특정 값을 가져옴
    // controller는 {} 만 사용해도 가능
    //  @PathVariable("id") int id   @GetMapping 에서 {id} 값을 바라봄
    @GetMapping("/api/user/{id}")
    public User getUserById(@PathVariable("id") int id){
        return   userService.getUserId(id)  ;
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "hello";
    }


    @GetMapping("/api/data")
    public Map<String,String> data() {
        Map<String,String> map = new HashMap<>();
        map.put("msg","hello");
        map.put("status","200");
        return map;
    }

 // ---------------------------- CAFE -----------------------------------------------

    @Autowired
    private CafeService cafeService;

    @GetMapping("/api/cafes")
    public List<Cafe> getAllCafes(){
        List<Cafe> cafes = cafeService.getAllCafes();
        log.info(cafes.toString());
        return cafes;
    }

    @GetMapping("/api/cafe/{id}")
    public Cafe getCafeById(@PathVariable("id") int id){
        return cafeService.getCafeId(id);
    }


    // ---------------------------- PERSON -----------------------------------------------

    @Autowired
    PersonServiceImpl personService;

    @GetMapping("/api/person")
    public List<Person> getAllPerson() {return personService.getAllPerson(); }
}
