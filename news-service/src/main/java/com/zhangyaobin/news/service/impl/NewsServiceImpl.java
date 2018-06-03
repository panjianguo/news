package com.zhangyaobin.news.service.impl;

import com.zhangyaobin.news.common.CommonUtils;
import com.zhangyaobin.news.entity.HotNewsEntity;
import com.zhangyaobin.news.entity.NewsEntity;
import com.zhangyaobin.news.entity.UserEntity;
import com.zhangyaobin.news.mapper.NewsMapper;
import com.zhangyaobin.news.param.NewsParam;
import com.zhangyaobin.news.repository.HotNewsRepository;
import com.zhangyaobin.news.repository.NewsRepository;
import com.zhangyaobin.news.repository.UserRepository;
import com.zhangyaobin.news.resp.NewsReq;
import com.zhangyaobin.news.service.NewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 新闻
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private HotNewsRepository hotNewsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<NewsEntity> listNews(NewsParam newsParam) {
       return newsMapper.listNews(newsParam);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public NewsEntity queryDetail(Integer newsId) {
        NewsEntity newsEntity = newsRepository.findOne(newsId);
        if (CommonUtils.isNotEmpty(newsEntity)) {
            newsEntity.setNumber(newsEntity.getNumber()+1);
            return newsRepository.save(newsEntity);
        }
        return newsEntity;

    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void editNews(NewsEntity newsEntity, Integer userId) {
        if (CommonUtils.isNotEmpty(newsEntity.getId())) {
            newsEntity.setAddTime(new Date());
            newsEntity.setNumber(0);
        }
        UserEntity userEntity = userRepository.findOne(userId);
        if (CommonUtils.isNotEmpty(newsEntity.getAddUserName())) {
            newsEntity.setAddUserId(userEntity.getId());
            newsEntity.setAddUserName(userEntity.getName());
        }
        newsRepository.save(newsEntity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void setHotNews(Integer newsId, Short typeId) throws Exception {
        hotNewsRepository.deleteByTypeId(typeId);
        NewsEntity newsEntity = newsRepository.findOne(newsId);
        if (CommonUtils.isEmpty(newsEntity)) {
            throw new Exception("新闻不存在");
        }
        if (typeId != newsEntity.getTypeId()) {
            throw new Exception("类型不匹配");
        }
        HotNewsEntity hotNewsEntity = new HotNewsEntity();
        BeanUtils.copyProperties(newsEntity, hotNewsEntity);
        hotNewsRepository.save(hotNewsEntity);
    }

    @Override
    public HotNewsEntity queryHotNews(Short typeId) {
        HotNewsEntity hotNewsEntity = hotNewsRepository.findByTypeId(typeId);
        return hotNewsEntity;
    }


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void deleteNews(NewsEntity newsEntity) {
        NewsEntity entity = newsRepository.findOne(newsEntity.getId());
        if (CommonUtils.isNotEmpty(entity)) {
            newsRepository.delete(entity);
        }
    }
}
