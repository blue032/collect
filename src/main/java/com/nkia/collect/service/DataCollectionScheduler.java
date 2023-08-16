/*DataCollectionScheduler 클래스를 만들었습니다
 스케줄링이용해서 자동수집하는 코드입니다.*/
package com.nkia.collect.service;

import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import com.nkia.collect.service.CollectService;

@Component
public class DataCollectionScheduler {
	private final CollectService collectService;
    private boolean isCollecting = false;

    public DataCollectionScheduler(CollectService collectService) {
        this.collectService = collectService;
    }
 // 매일 한 시간마다 실행
    @Scheduled(cron = "0 0 * * * ?")
    public void collectAndSaveData() {
        if (!isCollecting) {
            isCollecting = true;
            collectService.getApiDate(); // API 데이터 수집 및 MongoDB 저장
            System.out.println("API data collected and saved to MongoDB.");
            isCollecting = false;
        } else {
            System.out.println("Data collection is already in progress.");
        }
    }
}
