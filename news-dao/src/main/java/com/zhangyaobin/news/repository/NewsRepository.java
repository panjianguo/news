package com.zhangyaobin.news.repository;

import com.zhangyaobin.news.entity.NewsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 一句话功能简述
 */
@Repository
public interface NewsRepository extends CrudRepository<NewsEntity, Integer> {
}
