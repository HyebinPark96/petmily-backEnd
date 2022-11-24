package com.example.demo.service;

import com.example.demo.dto.ChartDTO;
import com.example.demo.mapper.ChartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChartService {
    @Autowired
    ChartMapper chartMapper;

    // 작성일자별 게시글 개수 컬럼차트
    public ChartDTO getPostCntByWriteDate() {
        ChartDTO chartDTO = new ChartDTO();
        chartDTO.setWriteDate(chartMapper.getWriteDate());
        chartDTO.setPostCntByWriteDate(chartMapper.getPostCntByWriteDate());
        return chartDTO;
    }

}
