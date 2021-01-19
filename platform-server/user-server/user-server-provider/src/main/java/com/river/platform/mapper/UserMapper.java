package com.river.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.river.platform.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author river
 * @since 2020-12-16
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
