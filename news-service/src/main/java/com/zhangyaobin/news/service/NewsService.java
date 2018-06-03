package com.zhangyaobin.news.service;

import com.zhangyaobin.news.entity.HotNewsEntity;
import com.zhangyaobin.news.entity.NewsEntity;
import com.zhangyaobin.news.param.NewsParam;
import com.zhangyaobin.news.resp.NewsReq;

import java.util.List;

/**
 * 一句话功能简述
 */
public interface NewsService {

    /**
     * 查询新闻列表
     *
     * @return
     */
    List<NewsEntity> listNews(NewsParam newsParam);

    /**
     * 查询新闻详情
     *
     * @param newsId
     * @return
     */
    NewsEntity queryDetail(Integer newsId);

    /**
     * 添加新闻
     *
     * @param newsEntity
     */
    void editNews(NewsEntity newsEntity, Integer userId);

    /**
     * 设置热点新闻
     *
     * @param newsId 新闻编号
     * @param typeId 新闻类型
     */
    void setHotNews(Integer newsId, Short typeId) throws Exception;

    /**
     * 查询热点新闻
     *
     * @param typeId 新闻类型编号
     * @return
     */
    HotNewsEntity queryHotNews(Short typeId);

    /**
     * 删除新闻
     */
    void deleteNews(NewsEntity newsEntity);
}
