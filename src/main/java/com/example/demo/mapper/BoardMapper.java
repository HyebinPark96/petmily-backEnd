package com.example.demo.mapper;

import com.example.demo.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository("com.example.demo.mapper.BoardMapper") // XML 위치
@Mapper
public interface BoardMapper {

    Integer insertQuestion(BoardDTO boardDTO);

    List<BoardDTO> selectQuestionList();

}
