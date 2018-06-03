package com.zhangyaobin.news.controller;

/**
 * 一句话功能简述
 */

import com.zhangyaobin.news.common.PrivilegeEnum;
import com.zhangyaobin.news.entity.RoleEntity;
import com.zhangyaobin.news.param.ModifyPrivilegeReq;
import com.zhangyaobin.news.param.RoleParam;
import com.zhangyaobin.news.resp.BaseResp;
import com.zhangyaobin.news.service.RoleService;
import com.zhangyaobin.news.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "角色")
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "角色列表")
    @GetMapping(value = "list")
    public ResponseEntity<BaseResp<List<RoleEntity>>> listRole(
            @RequestBody @Valid RoleParam roleParam
    ) {
        List<RoleEntity> roleEntities = roleService.listRole(roleParam);
        return ResponseEntity.ok(BaseResp.ok(roleEntities));
    }

    @ApiOperation(value = "角色列表")
    @GetMapping(value = "list/all")
    public ResponseEntity<BaseResp<List<RoleEntity>>> listAll(
    ) {
        List<RoleEntity> roleEntities = roleService.listAll();
        return ResponseEntity.ok(BaseResp.ok(roleEntities));
    }

    @ApiOperation(value = "编辑角色")
    @PostMapping(value = "edit")
    public ResponseEntity<BaseResp<String>> editRole(
            @RequestBody @Valid RoleEntity roleEntity,
            @RequestParam Integer userId
    ) throws Exception {
        userService.checkPrivilege(userId, PrivilegeEnum.MODIFY_USER_ROLE);
        roleService.editRole(roleEntity);
        return ResponseEntity.ok(BaseResp.ok("操作成功"));
    }

    @ApiOperation(value = "修改角色权限")
    @PostMapping(value = "modify/privilege")
    public ResponseEntity<BaseResp<String>> modifyPrivilege(
            @RequestBody ModifyPrivilegeReq modifyPrivilegeReq,
            @RequestParam Integer userId
    ) throws Exception {
        userService.checkPrivilege(userId, PrivilegeEnum.MODIFY_ROLE_PRIVILEGE);
        roleService.modifyRolePrivilege(modifyPrivilegeReq);
        return ResponseEntity.ok(BaseResp.ok("操作成功"));
    }

}
