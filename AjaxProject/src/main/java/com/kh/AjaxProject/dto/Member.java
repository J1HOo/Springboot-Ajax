package com.kh.AjaxProject.dto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString
public class Member  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mySQL 번호 일반적으로 자동 증가 설정
    private int id;
    private String nickname;
    private String password;
    private String username;
    private String email;
}
