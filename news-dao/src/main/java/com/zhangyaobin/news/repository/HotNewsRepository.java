package com.zhangyaobin.news.repository;

import com.zhangyaobin.news.entity.HotNewsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 热点新闻
 */
@Repository
public interface HotNewsRepository extends CrudRepository<HotNewsEntity, Integer> {

    void deleteByTypeId(Short typeId);

    HotNewsEntity findByTypeId(Short typeId);
}
