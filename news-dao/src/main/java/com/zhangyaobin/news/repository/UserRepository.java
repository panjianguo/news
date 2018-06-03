package com.zhangyaobin.news.repository;

import com.zhangyaobin.news.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 人员
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByPhone(String phone);
}
