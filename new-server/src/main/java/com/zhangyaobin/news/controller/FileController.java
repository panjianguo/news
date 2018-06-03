package com.zhangyaobin.news.controller;

import com.zhangyaobin.news.entity.PictureInfoEntity;
import com.zhangyaobin.news.resp.BaseResp;
import com.zhangyaobin.news.service.PictureInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

@Api(tags = "文件")
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private PictureInfoService pictureInfoService;

    @Autowired
    private ServletContext servletContext;

    @ApiOperation(value = "<s style=\"color:red\">上传文件</s>")
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResponseEntity<BaseResp<String>> upload(MultipartFile file) throws Exception {

        String pic = pictureInfoService.savePic(file.getOriginalFilename(), file.getBytes());
        return ResponseEntity.ok(BaseResp.ok(pic));

    }

    @ApiOperation(value = "查询图片")
    @RequestMapping(value = "query/{fileId}", method = RequestMethod.GET)
    public void queryFile(
            @PathVariable String fileId,
            HttpServletResponse response
    ) throws Exception {
        PictureInfoEntity pictureInfoEntity = pictureInfoService.queryFIle(fileId);
        File file = new File("./src/pic/" + pictureInfoEntity.getId() + pictureInfoEntity.getExtend());
        FileInputStream fileInputStream = new FileInputStream(file);
        IOUtils.copy(fileInputStream, response.getOutputStream());
    }


}
