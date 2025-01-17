package com.kh.AjaxSpringProject.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@AllArgsConstructor //필수생성자
@Getter
@NoArgsConstructor
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String phone;
    private String city;
    private String street;
    private String streetNumber;
    private String zipcode;
    private String geolocationLat;
    private String geolocationLong;

}
