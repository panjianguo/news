package com.zhangyaobin.news.repository;

import com.zhangyaobin.news.entity.NewsReviewEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 评论
 */
public interface NewsReviewRepository extends CrudRepository<NewsReviewEntity, Integer> {

    List<NewsReviewEntity> findByNewsId(Integer newsId);
}
