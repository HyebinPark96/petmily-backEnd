/*
package com.example.demo.pagination;

import lombok.Data;

@Data
public class Page {
    private int nowPage; // 현 페이지

    private int nowBlock; // 현 블록

    private int startNo; // 현 페이지의 시작 레코드
    
    private int blockPerPageCnt = 10; // 한 블럭당 페이지 수 = 10페이지

    private int pagePerRecordCnt = 10; // 한 페이지당 출력할 게시물 개수 = 10개

    private int totalRecord; // 총 레코드 개수

    private int pageCnt; // 총 페이지 개수

    private int startPageNum; // 현 페이지 기준 첫번째 페이지
    private int endPageNum; // 현 페이지 기준 마지막 페이지

    // 블럭 다음, 이전 버튼 유무
    private boolean prev;
    private boolean next;

    public void setTotalRecord(int totalRecord){ // 1. setter와 헷갈릴 수 있음
        this.totalRecord = totalRecord;

        pageCalc(); // 계산 메소드 호출
    }

    public void pageCalc(){
        // 블락당 최대 10페이지씩이므로 디폴트로 마지막 페이지는 10의 배수로.
        endPageNum = (int) (Math.ceil((double)nowPage / (double)blockPerPageCnt) * blockPerPageCnt);
        
        startPageNum = endPageNum - (blockPerPageCnt - 1); // 한 블록당 10페이지이므로 항상 마지막페이지 -9이어야함.

        // 블락 10페이지 안되는 경우 마지막 번호 재계산
        int re_endPageNum = (int) (Math.ceil((double)totalRecord / (double)blockPerPageCnt));

        // 실제 마지막 번호로 변경하기
        if(endPageNum > re_endPageNum) {
            endPageNum = re_endPageNum;
        }

        // 첫 페이지라면
        if(startPageNum == 1)
            prev = false;
        else
            prev = true;

        // 현 페이지의 마지막페이지 * 페이지당 게시글 개수 >= 총 게시글 개수
        if(endPageNum * blockPerPageCnt >= totalRecord)
            next = false;
        else
            next = true;

        startNo = (nowPage - 1) * pagePerRecordCnt;
    }


    */
/* 검색 *//*

    private String searchCategory;
    private String searchText;

    public void setSearchCategoryAndText(String searchCategory, String searchText) {
        if(searchCategory.equals("") || searchText.equals("")) { // 검색 X
            this.searchCategory = "";
            this.searchText = "";
        } else { // 검색 O
            this.searchCategory = searchCategory;
            this.searchText = searchText;
        }
    }


    
}
*/
