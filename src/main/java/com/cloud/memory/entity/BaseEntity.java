package com.cloud.memory.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/10/7 15:07
 * @description      基础实体类
 */
@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(10) comment '主键id'")
    protected Long id;

    @Column(columnDefinition = "int(10) comment '创建用户id'")
    private Long createUser;//创建用户id

    @Column(columnDefinition = "int(10) comment '更新用户id'")
    private Long updateUser;//更新用户id

    @Column(columnDefinition = "datetime comment '创建时间'")
    private Timestamp createTime;//创建时间

    @Column(columnDefinition = "datetime comment '更新时间'")
    private Timestamp updateTime;//更新时间

    @PrePersist
    public void prePersist() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        createTime = timestamp;
        updateTime = timestamp;
    }

    @PreUpdate
    public void preUpdate() {
        updateTime = new Timestamp(System.currentTimeMillis());
    }

}
