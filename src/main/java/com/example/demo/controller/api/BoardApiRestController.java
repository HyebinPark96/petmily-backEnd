package com.example.demo.controller.api;

import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.BoardDTOExceptPwd;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.SearchDTO;
import com.example.demo.service.BoardService;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

// 예외처리 하기

@RestController // 데이터만 주고받는 컨트롤러
public class BoardApiRestController {

    @Autowired
    BoardService boardService;

    @Autowired
    FileService fileService;

    // 글 목록 가져오기 + 게시글 검색
    @PostMapping("/board")
    // RequestParam 대신 DTO로 받을 수 있도록
    public ResponseDTO getBoardListWithPagingBySearch (@RequestBody SearchDTO searchDTO) {
        return boardService.getBoardListWithPagingBySearch(searchDTO);
        // throw new NullPointerException(); // @RestControllerAdvice TEST
    }

    // 수정, 삭제 시 비밀번호 확인
    @PostMapping("/checkPwd")
    public BoardDTOExceptPwd checkPwd(@RequestBody BoardDTO boardDTO) {
        return boardService.checkPwd(boardDTO);
    }

    // (비밀번호 미포함) 게시글 읽기
    @GetMapping("/board/post/{no}")
    public BoardDTOExceptPwd readPost(@PathVariable int no) {
        return boardService.readPostExceptPwd(no);
    }

    // 게시글 읽을 때 조회수 증가  <= 읽을 때 한번에
/*    @PutMapping("/board/post/{no}/viewCnt")
    public boolean plusViewCnt(@RequestBody BoardDTO boardDTO) {
        System.out.println("boardDTO.getViewCnt() : " + boardDTO.getViewCnt());
        return boardService.plusViewCnt(boardDTO);
    }*/

    // 파일 다운로드
    @PostMapping("/board/post/{no}/download")
    public File downloadFile(@PathVariable int no) {
        return boardService.getFile(no);
    }

    // 게시글 등록
    @PostMapping("/board/post")
    // MultipartFile는 리액트에서 formData에 append 시킨 key로 불러와야 함
    public boolean insertPost(@RequestPart(value = "originFile", required = false)  MultipartFile file, // 파일 업로드 안할 경우를 위해 required=false 속성 추가
                                        @RequestPart(value = "post") BoardDTO boardDTO) {
        if(file != null) { // 파일 업로드 했을 경우
            BoardDTO boardDTOWithUploadFile = fileService.uploadFile(file, boardDTO);  // 파일 저장 및 boardDTO 커맨드 객체에 file 관련 set되어 리턴

            // 파일 업로드 중 실패할 경우 대비
            if(boardDTOWithUploadFile != null) {
                return boardService.insertPost(boardDTOWithUploadFile); // DB INSERT
            }
            return false;
        } else { // 파일 업로드 안했을 경우
            return boardService.insertPost(boardDTO); // DB INSERT
        }
    }

    // 게시글 수정
    @PutMapping("/board/post/{no}")
    public boolean updatePost(@RequestPart(value = "originFile", required = false)  MultipartFile file, // 파일 업로드 안할 경우를 위해 required=false 속성 추가
                                            @RequestPart(value = "post") BoardDTO boardDTO) throws Exception{

            try {
                BoardDTO targetBoardDTOForRemove = boardService.read(boardDTO.getNo()); // 로컬 파일 삭제를 위해 DB 게시글 정보 가져옴

                if(file != null) { // 새로 파일 업로드 했을 경우 => 이전 파일 지워야 함
                    fileService.removeFile(targetBoardDTOForRemove); // 로컬 파일 삭제
                    return boardService.updatePost(fileService.uploadFile(file, boardDTO)); // 파일 저장 및 boardDTO 커맨드 객체에 file 관련 set되어 리턴된 것으로 DB UPDATE
                } else { // 기존 파일로 수정했거나, 파일 지운 경우
                    // 파일 지웠을 경우 이전 파일 지워야 함
                    if(boardDTO.getOriginFile() == null) { // 파일 지운 경우
                        fileService.removeFile(targetBoardDTOForRemove);
                    }
                    // 기존 파일로 수정한 경우
                    return boardService.updatePost(boardDTO); // DB UPDATE
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
            return false;
    }

    // 게시글 삭제
    @DeleteMapping("/board/post/{no}")
    public boolean deletePost(@PathVariable int no) {

        try {
            BoardDTO targetBoardDTOForRemove = boardService.read(no); // 로컬 파일 삭제를 위해 게시글 정보 가져옴
            fileService.removeFile(targetBoardDTOForRemove); // 로컬 파일 삭제
            return boardService.deletePost(no);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

}
