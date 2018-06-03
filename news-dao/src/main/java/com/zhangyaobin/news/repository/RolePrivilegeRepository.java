package com.zhangyaobin.news.repository;

import com.zhangyaobin.news.entity.RolePrivilegeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 角色权限
 */
public interface RolePrivilegeRepository extends CrudRepository<RolePrivilegeEntity, Integer> {

    List<RolePrivilegeEntity> findByRoleId(Integer roleId);


    void deleteByRoleId(Integer userId);
}
