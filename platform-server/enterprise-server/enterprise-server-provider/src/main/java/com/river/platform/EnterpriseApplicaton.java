package com.river.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author river
 * @date 2021/1/18 10:23
 **/
@EnableEurekaClient
@SpringCloudApplication
//@SpringBootApplication
@EnableFeignClients
public class EnterpriseApplicaton {
    public static void main(String[] args) {

        SpringApplication.run(EnterpriseApplicaton.class, args);
    }
}
