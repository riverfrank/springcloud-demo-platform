package com.river.platform.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author river
 * @date 2021/1/19 15:35
 **/

@EnableEurekaClient
@SpringCloudApplication
@EnableFeignClients("com.river.platform.**")
@ComponentScan("com.river.platform.**.**")
public class AdminApplication {
    public static void main(String[] args) {

        SpringApplication.run(AdminApplication.class, args);
    }
}
