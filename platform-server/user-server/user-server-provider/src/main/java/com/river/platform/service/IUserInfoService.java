package com.river.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.river.platform.entity.UserInfo;
import com.river.platform.userapi.dto.RegisterDTO;
import com.river.platform.userapi.dto.UserUpdateDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author river
 * @since 2020-12-16
 */
public interface IUserInfoService extends IService<UserInfo> {

    UserInfo save(Long id, RegisterDTO registerDTO, Long regPlatform);

    UserInfo update(Long id, UserUpdateDTO userUpdateDTO, Long platform);
}
