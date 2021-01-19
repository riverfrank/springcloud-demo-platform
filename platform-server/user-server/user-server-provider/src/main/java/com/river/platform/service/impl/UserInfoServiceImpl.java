package com.river.platform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.river.platform.entity.UserInfo;
import com.river.platform.mapper.UserInfoMapper;
import com.river.platform.service.IUserInfoService;
import com.river.platform.user.dto.RegisterDTO;
import com.river.platform.user.dto.UserUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author river
 * @since 2020-12-16
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Override
    public UserInfo save(Long id, RegisterDTO registerDTO, Long regPlatform){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setBirthday(registerDTO.getBirthday());
        userInfo.setRealName(registerDTO.getRealName());
        userInfo.setUpdateTime(new Date());
        userInfo.setGender(registerDTO.getGender());
        userInfo.setUpdatePlatform(regPlatform);
        save(userInfo);
        return userInfo;
    }

    @Override
    public UserInfo update(Long id, UserUpdateDTO userUpdateDTO, Long platform){
        UserInfo userInfo = this.getById(id);
        userInfo.setUpdateTime(new Date());
        userInfo.setRealName(userUpdateDTO.getRealName());
        userInfo.setBirthday(userUpdateDTO.getBirthday());
        userInfo.setUpdatePlatform(platform);
        userInfo.setGender(userUpdateDTO.getGender());
        updateById(userInfo);
        return userInfo;
    }

}
