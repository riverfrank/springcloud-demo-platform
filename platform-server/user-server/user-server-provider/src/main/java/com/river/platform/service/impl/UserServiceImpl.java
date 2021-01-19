package com.river.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.river.platform.entity.User;
import com.river.platform.entity.UserInfo;
import com.river.platform.mapper.UserMapper;
import com.river.platform.service.IUserInfoService;
import com.river.platform.service.IUserService;
import com.river.platform.userapi.dto.RegisterDTO;
import com.river.platform.userapi.dto.UserUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private IUserInfoService userInfoService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long register(RegisterDTO registerDTO, String regIp, Long regPlatform){
        //如果已经注册了，返回用户的id
        User user = findUserByMobile(registerDTO.getMobile());
        if(user != null){
            //如果已经存在，就更新用户信息
            UserUpdateDTO userUpdateDTO = new UserUpdateDTO(registerDTO);
            update(user, userUpdateDTO, regPlatform);
            return user.getId();
        }
        //创建新用户
        user = this.save(registerDTO, regIp, regPlatform);
        UserInfo userInfo = userInfoService.save(user.getId(),registerDTO, regPlatform);

        return user.getId();
    }

    @Override
    public boolean enableUser(Long id, Long platform){
        User user = getById(id);
//        ValidatedUtil.notNull(user,"未找到该用户");
//        userPlatformRefService.enable(id,platform);
        return true;
    }

    @Override
    public boolean disableUser(Long id, Long platform){
        User user = getById(id);
//        ValidatedUtil.notNull(user,"未找到该用户");
//        userPlatformRefService.disable(id,platform);
        return true;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean update(Long id, UserUpdateDTO userUpdateDTO, Long platform){
        User user = getById(id);
//        ValidatedUtil.notNull(user,"未找到该用户");
        update(user, userUpdateDTO, platform);
        return true;
    }
    public boolean update(User user, UserUpdateDTO userUpdateDTO, Long platform){
        user.setUpdateTime(new Date());
        this.updateById(user);
        UserInfo userInfo = userInfoService.update(user.getId(),userUpdateDTO, platform);
        return true;
    }

    private User save(RegisterDTO registerDTO,String regIp,Long regPlatform){
        User newUser = new User();
        newUser.setId(IdWorker.getId());
        newUser.setCreateTime(new Date());
        newUser.setMobile(registerDTO.getMobile());
        newUser.setRegTime(newUser.getCreateTime());
        newUser.setRegIp(regIp);
        newUser.setRegFrom(registerDTO.getRegFrom());
        newUser.setRegPlatform(regPlatform);
        save(newUser);
        return newUser;
    }

    @Override
    public User findUserByMobile(String mobile){
        User user = baseMapper.selectOne(new QueryWrapper<User>().lambda()
        .eq(User::getMobile,mobile));
        return user;
    }

    @Override
    public boolean isRegisteredUser(String mobile){
        int count = baseMapper.selectCount(new QueryWrapper<User>().lambda()
                .eq(User::getMobile,mobile));
        return count > 0;
    }

}
