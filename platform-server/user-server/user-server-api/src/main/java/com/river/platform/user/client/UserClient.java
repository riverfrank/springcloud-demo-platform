package com.river.platform.user.client;

import com.river.platform.user.fallback.UserClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author river
 * @date 2021/1/18 10:24
 **/
@FeignClient(name = "user-server-provider",fallback = UserClientFallBack.class,path = "/users")
public interface UserClient {


    @GetMapping("/hello")
    String hello();
}
