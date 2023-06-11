package com.example.demo.mapper;

import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.BoardDTOExceptPwd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("com.example.demo.mapper.BoardMapper") // XML 위치
@Mapper // 매퍼 사용하면 빈으로 등록되므로 Service단에서 Autowired로 사용가능
public interface BoardMapper {

    /*검색X*/
    // 글 목록 가져오기
    public List<BoardDTO> getBoardListWithPaging(@Param("startNo") int startNo, @Param("postCntPerPage") int postCntPerPage);

    // 리스트 페이지 만들기 위한 전체 레코드 개수 가져오기
    public int getPostCnt();

    /*검색 + 정렬*/
    // 글 목록 가져오기 + 게시글 검색 + 정렬
    public List<BoardDTOExceptPwd> getBoardListWithPagingBySearch(Map<String,Object> searchMap);

    // 리스트 페이지 만들기 위한 전체 레코드 개수 가져오기
    public int getPostCntBySearch(Map<String,Object> searchMap);

    // 수정, 삭제 시 비밀번호 확인
    public Boolean checkPwd(BoardDTO boardDTO);

    // (비밀번호 미포함) 게시글 읽기
    public BoardDTOExceptPwd readPostExceptPwd(@Param("no") int no);

    // (비밀번호 포함) 게시글 가져오기
    public BoardDTO read(int no);

    // 게시글 읽을 때 조회수 증가
    public int plusViewCnt(@Param("no") int no);

    // 파일 다운로드
    public String getFile(@Param("no") int no);

    // 게시글 등록
    public int insertPost(BoardDTO boardDTO);

    // 게시글 수정
    public int updatePost(BoardDTO boardDTO) throws Exception;

    // 게시글 삭제
    public int deletePost(@Param("no") int no);


}
