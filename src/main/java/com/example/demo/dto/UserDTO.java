package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserDTO {

    /** 아이디 **/
    private String userId;

    /** 비밀번호 **/
    private String userPassword;

    /** 이름 **/
    private String userName;

    /** 주민등록번호 **/
    private String userRrn;
    
}