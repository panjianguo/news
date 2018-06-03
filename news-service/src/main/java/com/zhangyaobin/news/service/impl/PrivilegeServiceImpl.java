package com.zhangyaobin.news.service.impl;

import com.zhangyaobin.news.common.CommonUtils;
import com.zhangyaobin.news.entity.RolePrivilegeEntity;
import com.zhangyaobin.news.entity.PrivilegeEntity;
import com.zhangyaobin.news.mapper.PrivilegeMapper;
import com.zhangyaobin.news.param.CommonParam;
import com.zhangyaobin.news.repository.RolePrivilegeRepository;
import com.zhangyaobin.news.repository.PrivilegeRepository;
import com.zhangyaobin.news.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private RolePrivilegeRepository rolePrivilegeRepository;

    @Override
    public List<PrivilegeEntity> listPrivilege(CommonParam param) {
        return privilegeMapper.listPrivilege(param);
    }

    @Override
    public List<PrivilegeEntity> listAll() {
        return (List<PrivilegeEntity>)privilegeRepository.findAll();
    }

    @Override
    public List<PrivilegeEntity> listPersonalPrivilege(Integer userId) {
        List<RolePrivilegeEntity> personalPrivilegeEntities = rolePrivilegeRepository.findByRoleId(userId);
        if (CommonUtils.isEmpty(personalPrivilegeEntities)) {
            return null;
        }
        List<Integer> privilegeIds = personalPrivilegeEntities.stream().map(RolePrivilegeEntity::getPrivilegeId).collect(Collectors.toList());
        return privilegeRepository.findByIdIn(privilegeIds);
    }

    @Override
    public void modifyRolePrivilege(Integer roleId, List<Integer> privilegeIds) {
        rolePrivilegeRepository.deleteByRoleId(roleId);
        if (CommonUtils.isEmpty(privilegeIds)) {
            return;
        }
        List<RolePrivilegeEntity> privilegeEntities = privilegeIds.stream().map(privilegeId ->
                RolePrivilegeEntity.builder()
                        .privilegeId(privilegeId)
                        .roleId(roleId)
                        .build()
        ).collect(Collectors.toList());
        rolePrivilegeRepository.save(privilegeEntities);
    }
}
