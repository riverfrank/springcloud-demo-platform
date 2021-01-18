package com.river.platform.user.fallback;

import com.river.platform.user.client.UserClient;
import org.springframework.stereotype.Component;

/**
 * @author river
 * @date 2021/1/18 11:42
 **/
@Component
public class UserClientFallBack implements UserClient {
    @Override
    public String hello() {
        return "您好，提供者调用失败！可能是服务未启用";
    }
}
