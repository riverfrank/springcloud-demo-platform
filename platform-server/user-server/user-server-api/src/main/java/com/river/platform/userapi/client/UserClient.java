package com.river.platform.userapi.client;

import com.river.platform.userapi.fallback.UserClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author river
 * @date 2021/1/18 10:24
 **/
@FeignClient(name = "user-server-provider",fallback = UserClientFallBack.class,path = "/users")
public interface UserClient {


    @GetMapping("/hello")
    String hello();
}
