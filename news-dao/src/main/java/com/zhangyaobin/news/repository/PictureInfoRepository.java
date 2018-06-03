package com.zhangyaobin.news.repository;

import com.zhangyaobin.news.entity.PictureInfoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 图片
 */
@Repository
public interface PictureInfoRepository extends CrudRepository<PictureInfoEntity, Integer> {

    PictureInfoEntity findById(String fileId);
}
