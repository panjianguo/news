package com.zhangyaobin.news.repository;

import com.zhangyaobin.news.entity.PersonRoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 人员角色
 */
@Repository
public interface PersonRoleRepository extends CrudRepository<PersonRoleEntity, Integer> {

    PersonRoleEntity findByUserId(Integer userId);
}
