package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChartDTO {
    // 작성일자 리스트
    private List<Date> writeDate;
    // 작성일자별 게시글 수 리스트
    private List<Integer> postCntByWriteDate;
}
