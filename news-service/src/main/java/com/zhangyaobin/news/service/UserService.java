package com.zhangyaobin.news.service;

import com.zhangyaobin.news.bean.LoginResp;
import com.zhangyaobin.news.common.PrivilegeEnum;
import com.zhangyaobin.news.entity.PrivilegeEntity;
import com.zhangyaobin.news.entity.UserEntity;
import com.zhangyaobin.news.param.UserParam;
import com.zhangyaobin.news.resp.UserReq;

import java.util.List;

/**
 * 用户
 */
public interface UserService {

    /**
     * 注册用户
     */
    void register(UserReq userReq) throws Exception;

    /**
     * 登陆
     *
     * @param userReq
     */
    LoginResp login(UserReq userReq) throws Exception;

    /**
     * 查询用户列表
     *
     * @param param
     * @return
     */
    List<UserEntity> listUser(UserParam param);

    /**
     * 变更人员角色
     *
     * @param userId
     * @param roleId
     */
    void modifyPersonRole(Integer userId, Integer roleId) throws Exception;

    /**
     * 验证人员权限
     *
     * @param userId
     * @param privilegeEnum
     */
    void checkPrivilege(Integer userId, PrivilegeEnum privilegeEnum) throws Exception;
}
