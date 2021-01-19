package com.river.platform.userapi.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author river
 * @date 2020/12/22 13:41
 */
@Data
@ApiModel("更新用户DTO")
@NoArgsConstructor
public class UserUpdateDTO {

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("生日")
    private Date birthday;

    @ApiModelProperty("0 未知 1 男 2 女")
    private Integer gender;

    public UserUpdateDTO(RegisterDTO registerDTO) {
        this.realName = registerDTO.getRealName();
        this.birthday = registerDTO.getBirthday();
        this.gender = registerDTO.getGender();
    }
}
