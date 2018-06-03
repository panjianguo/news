package com.zhangyaobin.news.service.impl;

import com.zhangyaobin.news.entity.NewsReviewEntity;
import com.zhangyaobin.news.repository.NewsReviewRepository;
import com.zhangyaobin.news.service.NewsReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsReviewServiceImpl implements NewsReviewService {

    @Autowired
    private NewsReviewRepository newsReviewRepository;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void editNewsReview(NewsReviewEntity newsReviewEntity) {
        newsReviewRepository.save(newsReviewEntity);
    }


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public List<NewsReviewEntity> queryNewsReview(Integer newsId) {
        return newsReviewRepository.findByNewsId(newsId);
    }
}
