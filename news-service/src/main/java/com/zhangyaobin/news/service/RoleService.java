package com.zhangyaobin.news.service;

import com.zhangyaobin.news.entity.RoleEntity;
import com.zhangyaobin.news.param.ModifyPrivilegeReq;
import com.zhangyaobin.news.param.RoleParam;

import java.util.List;

/**
 * 角色
 */
public interface RoleService {

    /**
     * 查询角色列表
     *
     * @param param
     * @return
     */
    List<RoleEntity> listRole(RoleParam param);

    /**
     * 查询所有角色
     * @return
     */
    List<RoleEntity> listAll();

    /**
     * 编辑角色
     * @param roleEntity
     */
    void editRole(RoleEntity roleEntity);

    /**
     * 编辑角色权限
     * @param modifyPrivilegeReq
     */
    void modifyRolePrivilege(ModifyPrivilegeReq modifyPrivilegeReq);


}
