package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String userId; // 아이디
    private String userPassword; // 비번
    private String userName; // 이름
    private String userRrn; // 주민등록번호
}