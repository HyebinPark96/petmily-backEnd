package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private List<BoardDTOExceptPwd> result; // 전체 게시글 목록
    private Integer postCnt; // 전체 게시글 수
}
