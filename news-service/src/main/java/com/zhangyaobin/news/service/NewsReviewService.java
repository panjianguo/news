package com.zhangyaobin.news.service;

import com.zhangyaobin.news.entity.NewsReviewEntity;

import java.util.List;

public interface NewsReviewService {

    /**
     * 编辑新闻评论
     *
     * @param newsReviewEntity
     */
    void editNewsReview(NewsReviewEntity newsReviewEntity);

    /**
     * 查询新闻评论
     * @param newsId
     * @return
     */
    List<NewsReviewEntity> queryNewsReview(Integer newsId);
}
