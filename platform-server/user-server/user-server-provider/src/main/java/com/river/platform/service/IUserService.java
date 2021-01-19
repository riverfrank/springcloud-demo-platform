package com.river.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.river.platform.entity.User;
import com.river.platform.userapi.dto.RegisterDTO;
import com.river.platform.userapi.dto.UserUpdateDTO;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author river
 * @since 2020-12-16
 */
public interface IUserService extends IService<User> {

    @Transactional(rollbackFor = Exception.class)
    Long register(RegisterDTO registerDTO, String regIp, Long regPlatform);

    boolean enableUser(Long id, Long platform);

    boolean disableUser(Long id, Long platform);

    @Transactional(rollbackFor = Exception.class)
    boolean update(Long id, UserUpdateDTO userUpdateDTO, Long platform);

    User findUserByMobile(String mobile);

    boolean isRegisteredUser(String mobile);
}
