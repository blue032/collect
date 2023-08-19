package com.nkia.collect.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class condition extends Common { //common클래스 상속받음

    private String conditionCode; //condition만 갖는 데이터 저장하는 문자열 변수 생성
}
