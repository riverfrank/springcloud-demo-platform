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
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String mobile;

    /**
     * 注册来源平台 1 雅集商户/ 2 钬花/3 钬花星球/4 朋来商城/5 水镝/6 有朋人脉/7 朋来/8用户平台
     */
    private Long regPlatform;

    private String regIp;

    private String regFrom;

    private Date regTime;

    private Date updateTime;

    private Date createTime;

    private Boolean valid;


}
