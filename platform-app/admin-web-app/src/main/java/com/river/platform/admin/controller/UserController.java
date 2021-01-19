package com.river.platform.admin.controller;

import com.river.platfom.common.ResultBean;
import com.river.platform.userapi.client.UserClient;
import com.river.platform.userapi.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author river
 * @date 2021/1/19 15:37
 **/
@RestController
@RequestMapping("/admin-users")
public class UserController {
    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public ResultBean<UserDTO> find(@PathVariable Long id){
        ResultBean<UserDTO> userDTOResultBean = userClient.find(id);
        return userDTOResultBean;
    }

    @GetMapping("/test")
    public ResultBean<String> hello(){
        return ResultBean.success(userClient.hello());
    }
}
