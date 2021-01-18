package com.river.platform.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author river
 * @date 2021/1/18 10:24
 **/
@FeignClient("user-server-provider")
@RequestMapping("/users")
public interface UserClient {
    @GetMapping("/hello")
    String hello();
}
