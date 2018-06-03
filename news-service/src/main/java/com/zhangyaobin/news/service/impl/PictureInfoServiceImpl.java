package com.zhangyaobin.news.service.impl;

import com.zhangyaobin.news.common.CommonUtils;
import com.zhangyaobin.news.entity.PictureInfoEntity;
import com.zhangyaobin.news.repository.PictureInfoRepository;
import com.zhangyaobin.news.service.PictureInfoService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.UUID;

/**
 * 文件
 */
@Service
public class PictureInfoServiceImpl implements PictureInfoService {

    @Autowired
    private PictureInfoRepository pictureInfoRepository;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public String savePic(String name, byte[] data) throws Exception {

        String extend = name.substring(name.lastIndexOf("."), name.length());
        String dirUrl = "./src/pic";
        File dir = new File(dirUrl);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        String fileName = dirUrl + "/" + uuidString + extend;
        File file = new File(fileName);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(data);

        PictureInfoEntity pictureInfoEntity = PictureInfoEntity.builder()
                .id(uuidString)
                .extend(extend)
                .build();

        pictureInfoEntity = pictureInfoRepository.save(pictureInfoEntity);
        return pictureInfoEntity.getId();
    }


    public PictureInfoEntity queryFIle(String fileId) {
        PictureInfoEntity pictureInfoEntity = pictureInfoRepository.findById(fileId);
        return pictureInfoEntity;
    }
}
