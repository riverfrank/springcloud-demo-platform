package com.river.platform.controller;

import cn.hutool.core.lang.Validator;
import com.river.platfom.common.ResultBean;
import com.river.platfom.common.util.ValidatedUtil;
import com.river.platform.service.IUserService;
import com.river.platform.userapi.dto.RegisterDTO;
import com.river.platform.userapi.dto.UserUpdateDTO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author river
 * @date 2021/1/18 10:21
 **/
@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private IUserService userService;

    @ApiOperation(value = "注册用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="appId",paramType="header"),
            @ApiImplicitParam(name="userId",paramType="header")
    })
    @PostMapping("")
    public ResultBean<Long> register(@RequestBody RegisterDTO registerDTO){
        ValidatedUtil.verify(Validator.isMobile(registerDTO.getMobile()),"请输入正确的手机号");
        ValidatedUtil.notNull(registerDTO.getRealName(),"请输入用户真实姓名");
        Long id = userService.register(registerDTO,null, null);
        return ResultBean.success(id);
    }


    @ApiOperation(value = "更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="appId",paramType="header"),
            @ApiImplicitParam(name="userId",paramType="header")
    })
    @PutMapping("/{id}")
    public ResultBean<Boolean> update(@PathVariable(name = "id") Long id,
                                      @RequestBody UserUpdateDTO userUpdateDTO){
        return ResultBean.success(userService.update(id,userUpdateDTO,null ));
    }


    @ApiOperation(value = "启用用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="appId",paramType="header"),
            @ApiImplicitParam(name="userId",paramType="header")
    })
    @PutMapping("/{id}/enable")
    public ResultBean<Boolean> enableUser(@PathVariable(name = "id") Long id){
        return ResultBean.success(userService.enableUser(id,null));
    }

    @ApiOperation(value = "停用用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="appId",paramType="header"),
            @ApiImplicitParam(name="userId",paramType="header")
    })
    @PutMapping("/{id}/disable")
    public ResultBean<Boolean> disableUser(@PathVariable(name = "id") Long id){
        return ResultBean.success(userService.disableUser(id,null));
    }

    @Deprecated
    @ApiOperation(value = "是否已经注册的手机号")
    @ApiImplicitParams({
            @ApiImplicitParam(name="appId",paramType="header"),
            @ApiImplicitParam(name="userId",paramType="header"),
            @ApiImplicitParam(name="mobile",paramType="path")
    })
    @GetMapping("/mobiles/{mobile}/isRegistered")
    public ResultBean<Boolean> isRegisteredUser(@PathVariable(name = "mobile") String mobile){
        return ResultBean.success(userService.isRegisteredUser(mobile));
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello every";
    }



}
