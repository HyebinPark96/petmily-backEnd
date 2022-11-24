package com.example.demo.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Integer no; // Integer로 변경
    private String writer;
    private String subject;
    private String content;
    private Timestamp writeDate;
    private String originFile; // 실제 파일명
    private String saveFileDir; // 스프링부트 프로젝트의 img src에 쓸 파일 저장 경로
    private String saveFileName; // 저장될 유니크한 파일명
    private String password;
    private Integer viewCnt;
}

/* a {
    List<BoardDTO> result;
    Long count;
}*/
