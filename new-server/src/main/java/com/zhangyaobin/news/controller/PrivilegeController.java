package com.zhangyaobin.news.controller;

/**
 * 权限
 */

import com.zhangyaobin.news.entity.PrivilegeEntity;
import com.zhangyaobin.news.param.CommonParam;
import com.zhangyaobin.news.resp.BaseResp;
import com.zhangyaobin.news.service.PrivilegeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "权限")
@RestController
@RequestMapping("privilege")
public class PrivilegeController {

    @Autowired
    private PrivilegeService privilegeService;

    @ApiOperation(value = "分页查询权限列表")
    @GetMapping(value = "list")
    public ResponseEntity<BaseResp<List<PrivilegeEntity>>> listPrivilege(
            @RequestBody @Valid CommonParam param
    ) {
        List<PrivilegeEntity> privilegeEntities = privilegeService.listPrivilege(param);
        return ResponseEntity.ok(BaseResp.ok(privilegeEntities));
    }

    @ApiOperation(value = "查询权限列表")
    @GetMapping(value = "list/all")
    public ResponseEntity<BaseResp<List<PrivilegeEntity>>> listPrivilegeAll(
    ) {
        List<PrivilegeEntity> privilegeEntities = privilegeService.listAll();
        return ResponseEntity.ok(BaseResp.ok(privilegeEntities));
    }

    @ApiOperation(value = "查询个人权限列表")
    @GetMapping(value = "list/personal")
    public ResponseEntity<BaseResp<List<PrivilegeEntity>>> listPersonALPrivilege(
            @RequestParam Integer userId
    ) {
        List<PrivilegeEntity> privilegeEntities = privilegeService.listPersonalPrivilege(userId);
        return ResponseEntity.ok(BaseResp.ok(privilegeEntities));
    }

    @ApiOperation(value = "变更角色权限")
    public ResponseEntity<BaseResp<String>> modifyPersonalPrivilage(
            @RequestParam Integer roleId,
            @RequestParam List<Integer> privilegeIds
    ) {
        privilegeService.modifyRolePrivilege(roleId, privilegeIds);
        return ResponseEntity.ok(BaseResp.ok("变更个人权限成功"));
    }





}
