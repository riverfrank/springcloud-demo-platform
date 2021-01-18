package com.river.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author river
 * @date 2021/1/18 10:23
 **/
@SpringBootApplication
@EnableFeignClients
public class EnterpriseApplicaton {
    public static void main(String[] args) {
        SpringApplication.run(EnterpriseApplicaton.class, args);
    }
}
