package com.zhangyaobin.news.controller;

import com.zhangyaobin.news.entity.NewsReviewEntity;
import com.zhangyaobin.news.resp.BaseResp;
import com.zhangyaobin.news.service.NewsReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "新闻评论")
@RestController
@RequestMapping("news/review")
public class NewsReviewController {

    @Autowired
    private NewsReviewService newsReviewService;

    @ApiOperation(value = "编辑评论")
    @PostMapping(value = "edit")
    public ResponseEntity<BaseResp<String>> editReview(
            @RequestBody NewsReviewEntity newsReviewEntity
    ) {
        newsReviewService.editNewsReview(newsReviewEntity);
        return ResponseEntity.ok(BaseResp.ok("操作成功"));
    }

    @ApiOperation(value = "查询评理列表")
    @GetMapping(value = "list")
    public ResponseEntity<BaseResp<List<NewsReviewEntity>>> listNewsReview(
            @RequestParam Integer newsId
    ) {
        List<NewsReviewEntity> newsReviewEntities = newsReviewService.queryNewsReview(newsId);
        return ResponseEntity.ok(BaseResp.ok(newsReviewEntities));
    }




}
