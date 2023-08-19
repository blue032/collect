package com.nkia.collect.model;

import lombok.Getter;
import lombok.Setter;

//getter의 역할: 클래스의 private 필드의 값을 외부로 반환
//setter의 역할: 클래스의 private 필드에 값 설정 or 수정, 외부에서도 필드 값 변경 가능
@Getter @Setter //어노테이션 사용으로 매소드 자동 생성
public class Common {

    private String dataId; //위험구간은 없음???
    private String trmnId; //위험구간 없음???
    private String trsmYear; //년도
    private String trsmMt; //월
    private String trsmDy; //일
    private String trsmTm; //시간
    private String trsmMs; 
    private String vhcleLat;
    private String vhcleLot;
}
