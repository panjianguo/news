package com.zhangyaobin.news.mapper;

import com.zhangyaobin.news.entity.NewsEntity;
import com.zhangyaobin.news.param.NewsParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NewsMapper {

    List<NewsEntity> listNews(NewsParam newsParam);

}
