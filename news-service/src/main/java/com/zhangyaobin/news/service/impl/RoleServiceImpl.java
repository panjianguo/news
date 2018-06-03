package com.zhangyaobin.news.service.impl;

import com.zhangyaobin.news.common.CommonUtils;
import com.zhangyaobin.news.entity.RoleEntity;
import com.zhangyaobin.news.entity.RolePrivilegeEntity;
import com.zhangyaobin.news.mapper.RoleMapper;
import com.zhangyaobin.news.param.ModifyPrivilegeReq;
import com.zhangyaobin.news.param.RoleParam;
import com.zhangyaobin.news.repository.RolePrivilegeRepository;
import com.zhangyaobin.news.repository.RoleRepository;
import com.zhangyaobin.news.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RolePrivilegeRepository rolePrivilegeRepository;

    @Override
    public List<RoleEntity> listRole(RoleParam param) {
        return roleMapper.listRole(param);
    }

    @Override
    public List<RoleEntity> listAll() {
        Iterable<RoleEntity> all = roleRepository.findAll();
        if (CommonUtils.isEmpty(all)) {
            return null;
        }
        return (List<RoleEntity>) all;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void editRole(RoleEntity roleEntity) {
        roleRepository.save(roleEntity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void modifyRolePrivilege(ModifyPrivilegeReq modifyPrivilegeReq) {
        Integer roleId = modifyPrivilegeReq.getRoleId();
        rolePrivilegeRepository.deleteByRoleId(roleId);
        List<Integer> privilegeIds = modifyPrivilegeReq.getPrivilegeIds();
        if (CommonUtils.isNotEmpty(privilegeIds)) {
            List<RolePrivilegeEntity> rolePrivilegeEntities = privilegeIds.stream().map(privilegeId ->
                    RolePrivilegeEntity.builder()
                            .roleId(roleId)
                            .privilegeId(privilegeId)
                            .build()
            ).collect(Collectors.toList());
            rolePrivilegeRepository.save(rolePrivilegeEntities);
        }

    }
}
