package com.example.demo.dto.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListDTO {
    // 페이지 번호
    private Long pageNo;
    
    // 한 페이지 결과 수
    private Long numOfRows;
}
