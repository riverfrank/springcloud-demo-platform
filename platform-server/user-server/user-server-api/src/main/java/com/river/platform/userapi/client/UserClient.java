package com.river.platform.userapi.client;

import com.river.platfom.common.ResultBean;
import com.river.platform.userapi.dto.RegisterDTO;
import com.river.platform.userapi.dto.UserDTO;
import com.river.platform.userapi.dto.UserUpdateDTO;
import com.river.platform.userapi.fallback.UserClientFallBack;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author river
 * @date 2021/1/18 10:24
 **/
@FeignClient(name = "user-server-provider",path = "/users")
public interface UserClient {

    @ApiOperation(value = "注册用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="appId",paramType="header"),
            @ApiImplicitParam(name="userId",paramType="header")
    })
    @PostMapping("")
    ResultBean<Long> register(@RequestBody RegisterDTO registerDTO);

    @ApiOperation(value = "更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="appId",paramType="header"),
            @ApiImplicitParam(name="userId",paramType="header")
    })
    @PutMapping("/{id}")
    ResultBean<Boolean> update(@PathVariable(name = "id") Long id,
                               @RequestBody UserUpdateDTO userUpdateDTO);

    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="appId",paramType="header"),
            @ApiImplicitParam(name="userId",paramType="header")
    })
    @GetMapping("/{id}")
    ResultBean<UserDTO> find(@PathVariable(name = "id") Long id);

    @GetMapping("/hello")
    String hello();
}
