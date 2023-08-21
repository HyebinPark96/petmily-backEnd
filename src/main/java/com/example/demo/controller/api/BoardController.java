package com.example.demo.controller.api;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/question")
    public boolean insertQuestion(@RequestPart BoardDTO board){
        return boardService.insertQuestion(board);
    }

    @GetMapping("/questionList")
    public List<BoardDTO> selectQuestionList(){
        return boardService.selectQuestionList();
    }

}
