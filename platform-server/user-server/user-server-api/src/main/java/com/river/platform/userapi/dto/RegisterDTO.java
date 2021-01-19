package com.river.platform.userapi.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author river
 * @date 2020/12/22 13:41
 */
@Data
@ApiModel("注册DTO")
public class RegisterDTO {

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty(value = "生日，格式 yyyy-MM-dd HH:mm:ss",example = "2018-10-01 12:18:48")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    @ApiModelProperty("web/app")
    private String regFrom;

    @ApiModelProperty("0 未知 1 男 2 女")
    private Integer gender;

}
