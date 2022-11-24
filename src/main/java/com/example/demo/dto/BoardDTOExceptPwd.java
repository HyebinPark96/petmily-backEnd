package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// 비밀번호 제외 DTO
public class BoardDTOExceptPwd {
    private Integer no; // Class형식 Integer로 변경
    private String writer;
    private String subject;
    private String content;
    private Timestamp writeDate;
    private String originFile; // 실제 파일명
    private String saveFileDir; // 스프링부트 프로젝트의 img src에 쓸 파일 저장 경로
    private String saveFileName; // 저장될 유니크한 파일명
    private Integer viewCnt;
}
