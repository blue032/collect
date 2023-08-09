package com.nkia.collect;

import com.nkia.collect.service.CollectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollectApplication.class, args);
	}

}
