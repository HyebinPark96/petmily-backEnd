package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

@Service
public class FileService {
    // 업로드 경로
    private static  String UPLOAD_DIR = "C:/demo/src/main/resources/static/upload";
    
    // 파일 저장
    public BoardDTO uploadFile(MultipartFile file, BoardDTO boardDTO) { // 중복된 파일 업로드 시 유니크한 파일명 만들어서 저장.  이 때 유니크한 파일명+형식 리턴해주는 메소드
        // String UPLOAD_DIR = "C:/demo/src/main/resources/static/upload";

        // 현재 날짜와 랜덤 정수값으로 새로운 파일명 만들기
        String saveFileName = (new Date().getTime()) + "" + (new Random().ints(1000, 9999).findAny().getAsInt());

        // 확장자 포함 기존 파일명
        String originFile = file.getOriginalFilename();

        // 확장자 // saveFileExtension 테이블에서 컬럼은 지움
        String saveFileExtension = originFile.substring(originFile.lastIndexOf(".") + 1); // 확장자 : (파일명). 이후부터 끝까지 잘라낸 것
        
        boardDTO.setSaveFileDir("/upload/" + saveFileName + "." + saveFileExtension); // 파일 저장 경로 및 유니크한 파일 저장명과 확장자 set
        boardDTO.setSaveFileName(saveFileName + "." + saveFileExtension); // 유니크한 저장 파일명. 확장자 set
        // 파일 객체 생성
        File saveFile = new File(UPLOAD_DIR, saveFileName + "." + saveFileExtension); // new File(파일경로, 저장할 파일명)

        try {
            file.transferTo(saveFile); // 파일 저장
        } catch (IOException e) {
            throw new RuntimeException(e); // !! 예외처리하기
        }

        return boardDTO; // 파일 저장 및 boardDTO 커맨드 객체에 file 관련 set되어 리턴
    }

    // 파일 삭제
    public void removeFile(BoardDTO boardDTO) { // 매개변수로 saveFileName 가져옴
        // String UPLOAD_DIR = "C:/demo/src/main/resources/static/upload";

        // 삭제할 타깃 파일 경로 및 저장명
        File targetFileForRemove = new File(UPLOAD_DIR + "/" + boardDTO.getSaveFileName()); // 실제 저장된 파일명으로 삭제할 타깃 파일 객체 생성

        try{
            if(targetFileForRemove.exists()) { // 파일 존재하면
                targetFileForRemove.delete(); // 로컬 파일 삭제
            }
        } catch(Exception e) {
            e.getStackTrace();
        }
    }




}
