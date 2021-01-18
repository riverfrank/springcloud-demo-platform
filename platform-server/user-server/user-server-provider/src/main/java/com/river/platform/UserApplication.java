package com.river.platform;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author river
 * @date 2021/1/18 9:48
 **/

@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(UserApplication.class).run(args);
    }

}
