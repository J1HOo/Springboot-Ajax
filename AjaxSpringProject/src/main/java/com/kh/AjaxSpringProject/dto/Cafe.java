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
public class Cafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;
    private String phoneNumber;
    private String openingTime;
    private String closingTime;
    private String description;
}
