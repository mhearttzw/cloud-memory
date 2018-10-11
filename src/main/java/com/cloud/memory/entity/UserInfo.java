package com.cloud.memory.entity;

import com.cloud.memory.common.enums.SexType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/10/7 15:17
 * @description      用户表实体类
 */
@Data
@Entity
@Table(name = "user_info")
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "user_uuid", columnDefinition = "varchar(64) comment '用户唯一标识id'")
    private String userUuid;

    @Column(name = "phone", columnDefinition = "varchar(64) comment '用户手机号码'")
    private String phone;

    @Email
    @Column(name = "email", columnDefinition = "varchar(64) comment '用户邮箱'")
    private String email;

    @Column(name = "password", columnDefinition = "varchar(64) comment '密码(md5+盐)'")
    private String password;

    @Column(name = "salt", columnDefinition = "varchar(64) comment '盐'")
    private String salt;

    @Column(name = "nickname", columnDefinition = "varchar(64) comment '用户昵称'")
    private String nickname;

    @Column(name = "sex", columnDefinition = "tinyint(3) comment '性别'")
    @Convert(converter = SexType.Convert.class)
    private SexType sex;

    @Column(name = "signature", columnDefinition = "varchar(64) comment '个性签名'")
    private String signature;

    @Column(name = "avatar", columnDefinition = "varchar(64) comment '头像地址'")
    private String avatar;

    @Column(name = "ip_address", columnDefinition = "varchar(64) comment '注册ip地址'")
    private String ipAddress;

    @Column(name = "last_login_ip", columnDefinition = "varchar(64) comment '最后登录ip地址'")
    private String lastLoginIp;






}
