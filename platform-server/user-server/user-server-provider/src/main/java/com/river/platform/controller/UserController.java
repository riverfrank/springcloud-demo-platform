package com.river.platform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author river
 * @date 2021/1/18 10:21
 **/
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        return "hello every";
    }

}
