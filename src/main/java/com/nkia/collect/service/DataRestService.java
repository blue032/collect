package com.nkia.collect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080") // 추가
@RestController
@RequestMapping("/datas")
public class DataRestService {

    @Autowired
    CollectService collectService;

    @GetMapping("/line")
    public String line(){
        return collectService.getApiDate();
    }

}
