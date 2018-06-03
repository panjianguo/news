package com.zhangyaobin.news.bean;

import com.zhangyaobin.news.entity.PrivilegeEntity;
import com.zhangyaobin.news.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 登陆
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResp implements Serializable {

    private List<PrivilegeEntity> privilegeEntities;

    private UserEntity userEntity;
}
