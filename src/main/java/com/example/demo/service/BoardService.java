package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    /** 질문 등록 **/
    public boolean insertQuestion(BoardDTO boardDTO){
        Integer result = boardMapper.insertQuestion(boardDTO);
        return result == 1;
    }

    /** 질문 등록 **/
    public List<BoardDTO> selectQuestionList(){
        List<BoardDTO> result = boardMapper.selectQuestionList();
        return result;
    }
}
