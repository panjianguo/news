package com.zhangyaobin.news.repository;

import com.zhangyaobin.news.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 角色
 */
@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {

}
