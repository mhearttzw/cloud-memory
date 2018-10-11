package com.cloud.memory.repository;

import com.cloud.memory.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/10/7 16:06
 * @description      用户信息表dao层
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>, JpaSpecificationExecutor<UserInfo> {


}
