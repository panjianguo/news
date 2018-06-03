package com.zhangyaobin.news.controller;

import com.zhangyaobin.news.common.PrivilegeEnum;
import com.zhangyaobin.news.entity.HotNewsEntity;
import com.zhangyaobin.news.entity.NewsEntity;
import com.zhangyaobin.news.param.NewsParam;
import com.zhangyaobin.news.resp.BaseResp;
import com.zhangyaobin.news.service.NewsService;
import com.zhangyaobin.news.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 新闻
 */
@Api(tags = "新闻")
@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "新闻列表")
    @PostMapping(value = "list")
    public ResponseEntity<BaseResp<List<NewsEntity>>> listNews(
            @RequestBody NewsParam newsParam
    ) {
        List<NewsEntity> newsEntities = newsService.listNews(newsParam);
        return ResponseEntity.ok(BaseResp.ok(newsEntities));
    }

    @ApiOperation(value = "查询新闻详情")
    @GetMapping(value = "detail")
    public ResponseEntity<BaseResp<NewsEntity>> queryNews(
            @RequestParam Integer newsId
    ) {
        NewsEntity newsEntity = newsService.queryDetail(newsId);
        return ResponseEntity.ok(BaseResp.ok(newsEntity));
    }

    @ApiOperation(value = "编辑新闻")
    @PostMapping(value = "edit")
    public ResponseEntity<BaseResp<String>> addNews(
            @RequestBody NewsEntity newsEntity,
            @RequestParam Integer userId
    ) throws Exception {
        userService.checkPrivilege(userId, PrivilegeEnum.MODIFY_NEWS);
        newsService.editNews(newsEntity, userId);
        return ResponseEntity.ok(BaseResp.ok("操作成功"));
    }

    @ApiOperation(value = "删除新闻")
    @PostMapping(value = "delete")
    public ResponseEntity<BaseResp<String>> deleteNews(
            @RequestBody NewsEntity newsEntity,
            @RequestParam Integer userId
    ) throws Exception {
        userService.checkPrivilege(userId, PrivilegeEnum.MODIFY_NEWS);
        newsService.deleteNews(newsEntity);
        return ResponseEntity.ok(BaseResp.ok("操作成功"));
    }

    @ApiOperation(value = "设置热点新闻")
    @PostMapping(value = "set/hot")
    public ResponseEntity<BaseResp<String>> setHotNews(
            @RequestParam Integer newsId,
            @RequestParam Short typeId,
            @RequestParam Integer userId
    ) throws Exception {
        userService.checkPrivilege(userId, PrivilegeEnum.MODIFY_NEWS);
        newsService.setHotNews(newsId, typeId);
        return ResponseEntity.ok(BaseResp.ok("操作成功"));
    }

    @ApiOperation(value = "查询热点新闻详情")
    @GetMapping(value = "hot/detail")
    public ResponseEntity<BaseResp<HotNewsEntity>> queryHotNews(
            @RequestParam Short typeId
    ) {
        HotNewsEntity hotNewsEntity = newsService.queryHotNews(typeId);
        return ResponseEntity.ok(BaseResp.ok(hotNewsEntity));
    }

}
