package com.river.platform.userapi.fallback;

import com.river.platfom.common.ResultBean;
import com.river.platform.userapi.client.UserClient;
import com.river.platform.userapi.dto.RegisterDTO;
import com.river.platform.userapi.dto.UserDTO;
import com.river.platform.userapi.dto.UserUpdateDTO;
import org.springframework.stereotype.Component;

/**
 * @author river
 * @date 2021/1/18 11:42
 **/
//@Component
public class UserClientFallBack implements UserClient {
    @Override
    public ResultBean<Long> register(RegisterDTO registerDTO) {
        return null;
    }

    @Override
    public ResultBean<Boolean> update(Long id, UserUpdateDTO userUpdateDTO) {
        return null;
    }

    @Override
    public ResultBean<UserDTO> find(Long id) {
        return null;
    }

    @Override
    public String hello() {
        return "hello 您好，提供者调用失败！可能是服务未启用";
    }
}
