package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {

    /** 순번 **/
    private Integer no;
    
    /** 작성자 **/
    private String writer;

    /** 제목 **/
    private String subject;

    /** 내용 **/
    private String content;

    /** 작성일자 **/
    private String writeDate;

    /** 논리 파일명 **/
    private String originFile;
    
    /** 저장 경로 **/
    private String saveFileDir;

    /** 물리 파일명 **/
    private String saveFileName;
    
    /** 게시글 비밀번호 **/
    private String password;

    /** 조회수 **/
    private Integer viewCnt;

}
