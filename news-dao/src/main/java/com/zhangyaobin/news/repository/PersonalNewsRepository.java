package com.zhangyaobin.news.repository;

import com.zhangyaobin.news.entity.PersonalNewsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 个人新闻表
 */
@Repository
public interface PersonalNewsRepository extends CrudRepository<PersonalNewsEntity, Integer> {
}
