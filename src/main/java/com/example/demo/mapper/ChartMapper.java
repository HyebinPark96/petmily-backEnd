package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository("com.example.demo.mapper.ChartMapper") // XML 위치
@Mapper
public interface ChartMapper {
    public List<Date> getWriteDate();
    public List<Integer> getPostCntByWriteDate();
}
