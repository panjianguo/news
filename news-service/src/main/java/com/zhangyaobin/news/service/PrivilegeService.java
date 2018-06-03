package com.zhangyaobin.news.service;

import com.zhangyaobin.news.entity.PrivilegeEntity;
import com.zhangyaobin.news.param.CommonParam;

import java.util.List;

/**
 * 权限
 */
public interface PrivilegeService {

    /**
     * 分页查询权限列表
     *
     * @param param
     * @return
     */
    List<PrivilegeEntity> listPrivilege(CommonParam param);

    /**
     * 查询所有权限列表
     *
     * @return
     */
    List<PrivilegeEntity> listAll();

    /**
     * 查询个人权限列表
     *
     * @param userId
     * @return
     */
    List<PrivilegeEntity> listPersonalPrivilege(Integer userId);

    /**
     * 变更角色全新啊
     *
     * @param roleId       人员编号
     * @param privilegeIds 权限编号列表
     */
    void modifyRolePrivilege(Integer roleId, List<Integer> privilegeIds);
}
