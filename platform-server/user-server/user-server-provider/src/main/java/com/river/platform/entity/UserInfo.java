package com.river.platform.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author river
 * @since 2020-12-16
 * @desc 和产品沟通  用户和 用户字表是 一对一关系，保留最后一次更新记录
 *                   用户和平台关系中 保留 各个平台 数据
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String realName;

    private Date birthday;

    private Date updateTime;

    private Integer gender;

    /**
     * 更新平台 1 雅集商户/ 2 钬花/3 钬花星球/4 朋来商城/5 水镝/6 有朋人脉/7 朋来/8用户平台
     */
    private Long updatePlatform;

}
