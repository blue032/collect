package com.nkia.collect.controller.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Danger extends Common {

    private String itisCd;
    private String detcLot;
    private String detcLat;
    
    public String getItisCd() {
        return itisCd;
    }
    
    public String getDetcLot() {
        return detcLot;
    }
    
    public String getDetcLat() {
        return detcLat;
    }
}
