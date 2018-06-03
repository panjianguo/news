package com.zhangyaobin.news.service;

import com.zhangyaobin.news.entity.PictureInfoEntity;

import java.io.FileNotFoundException;

/**
 */
public interface PictureInfoService {

    /**
     * 保存文件
     *
     * @param name
     * @param data
     * @return
     */
    String savePic(String name, byte[] data) throws Exception;

    /**
     * 查询文件
     *
     * @param fileId
     * @return
     */
    PictureInfoEntity queryFIle(String fileId);
}
