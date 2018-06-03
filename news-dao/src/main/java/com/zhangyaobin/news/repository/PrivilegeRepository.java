package com.zhangyaobin.news.repository;

import com.zhangyaobin.news.entity.PrivilegeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 权限
 */
public interface PrivilegeRepository extends CrudRepository<PrivilegeEntity, Integer> {

    List<PrivilegeEntity> findByIdIn(List<Integer> privilegeIds);


}
