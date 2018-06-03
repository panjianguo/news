package com.zhangyaobin.news.controller;

/**
 * 用户
 */

import com.zhangyaobin.news.bean.LoginResp;
import com.zhangyaobin.news.entity.PrivilegeEntity;
import com.zhangyaobin.news.entity.UserEntity;
import com.zhangyaobin.news.param.UserParam;
import com.zhangyaobin.news.resp.BaseResp;
import com.zhangyaobin.news.resp.UserReq;
import com.zhangyaobin.news.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "用户注册")
    @PostMapping(value = "register")
    public ResponseEntity<BaseResp<String>> register(
            @RequestBody @ApiParam("用户注册信息") UserReq userReq
    ) throws Exception {
        userService.register(userReq);
        return ResponseEntity.ok(BaseResp.ok("操作成功"));
    }

    @ApiOperation(value = "用户登陆")
    @PostMapping(value = "login")
    public ResponseEntity<BaseResp<LoginResp>> login(
            @RequestBody @ApiParam("用户登陆") UserReq userReq
    ) throws Exception {
        LoginResp loginResp = userService.login(userReq);
        return ResponseEntity.ok(BaseResp.ok(loginResp));
    }

    @ApiOperation(value = "查询用户列表")
    @GetMapping(value = "list")
    public ResponseEntity<BaseResp<List<UserEntity>>> listUser(
            @ModelAttribute @ApiParam("用户查询") UserParam param
    ) {
        List<UserEntity> userEntities = userService.listUser(param);
        return ResponseEntity.ok(BaseResp.ok(userEntities));
    }

    @ApiOperation(value = "变更人员角色")
    @PostMapping(value = "modify/role")
    public ResponseEntity<BaseResp<String>> modifyPersonRole(
            @RequestParam Integer userId,
            @RequestParam Integer roleId
    ) throws Exception {
        userService.modifyPersonRole(userId, roleId);
        return ResponseEntity.ok(BaseResp.ok("变更成功"));
    }

}
