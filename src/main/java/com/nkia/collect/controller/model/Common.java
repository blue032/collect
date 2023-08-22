//데이터 중에 공통변수들 정리
package com.nkia.collect.controller.model;

import lombok.Getter;
import lombok.Setter;

//getter의 역할: 클래스의 private 필드의 값을 외부로 반환
//setter의 역할: 클래스의 private 필드에 값 설정 or 수정, 외부에서도 필드 값 변경 가능
@Getter @Setter //어노테이션 사용으로 매소드 자동 생성
public class Common {

    private String dataId; 
    private String trmnId;
    private String trsmYear; //년도
    private String trsmMt; //월
    private String trsmDy; //일
    private String trsmTm; //시간
    private String trsmMs; 
    private String vhcleLat;
    private String vhcleLot;
    private String ldws; 
    private String pcws;
    
    public String getVhcleLot() {
        return vhcleLot;
    }
    
    public String getVhcleLat() {
        return vhcleLat;
    }
    
    public String getLdws() {
        return ldws;
    }
    
    public String getPcws() {
        return pcws;
    }
}
