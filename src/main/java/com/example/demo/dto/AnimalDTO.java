package com.example.demo.dto;

import com.example.demo.dto.common.ListDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO extends ListDTO {

    /** 공고번호 **/
    private Long desertionNo;

    /** 오류메시지 **/
    private String errorMsg;

    /** 썸네일 파일명 (bird.jpg) **/
    private String filename;

    /** 접수일 **/
    private String happenDt;

    /** 발견장소 **/
    private String happenPlace;

    /** 품종 **/
    private String kindCd;

    /** 색상 **/
    private String colorCd;

    /** 나이 **/
    private String age;

    /** 체중 **/
    private String weight;

    /** 공고번호 **/
    private String noticeNo;

    /** 공고시작일 **/
    private String noticeSdt;

    /** 공고종료일 **/
    private String noticeEdt;

    /** image **/
    private String popfile;

    /** 상태 **/
    private String processState;

    /** 성별 **/
    private String sexCd;

    /** 중성화여부 **/
    private String neuterYn;

    /** 특징 **/
    private String specialMark;

    /** 보호소 이름 **/
    private String careNm;

    /** 보호소 전화번호 **/
    private String careTel;

    /** 보호장소 **/
    private String careAddr;

    /** 관할기관 **/
    private String orgNm;

    /** 담당자 **/
    private String chargeNm;

    /** 담당자 연락처 **/
    private String officetel;

    /** 특이사항 **/
    private String noticeComment;

}
