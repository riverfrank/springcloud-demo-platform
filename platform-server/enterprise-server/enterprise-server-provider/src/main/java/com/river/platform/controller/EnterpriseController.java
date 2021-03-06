package com.river.platform.controller;

import com.river.platform.userapi.client.UserClient;
import com.river.platform.userapi.dto.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author river
 * @date 2021/1/18 10:58
 **/
@RestController
@RequestMapping("/enterprises")
public class EnterpriseController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/test")
    public String test(){
        new RegisterDTO();
        return userClient.hello();
    }
}
