package com.zhangyaobin.news.service.impl;

import com.zhangyaobin.news.bean.LoginResp;
import com.zhangyaobin.news.common.CommonUtils;
import com.zhangyaobin.news.common.PrivilegeEnum;
import com.zhangyaobin.news.entity.*;
import com.zhangyaobin.news.mapper.UserMapper;
import com.zhangyaobin.news.param.UserParam;
import com.zhangyaobin.news.repository.*;
import com.zhangyaobin.news.resp.UserReq;
import com.zhangyaobin.news.service.PrivilegeService;
import com.zhangyaobin.news.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户
 */
@Service
public class UserServiceImpl implements UserService {

    // 普通人员编号
    public static final Integer PTUSER = 2;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonRoleRepository personRoleRepository;

    @Autowired
    private RolePrivilegeRepository rolePrivilegeRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PrivilegeService privilegeService;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void register(UserReq userReq) throws Exception {
        UserEntity entity = userRepository.findByPhone(userReq.getPhone());
        if (CommonUtils.isNotEmpty(entity)) {
            throw new Exception("手机号码重复");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userReq, userEntity);
        userEntity.setAddTime(new Date());
        userEntity.setLevel(1);
        userEntity.setRoleId(2);
        userEntity = userRepository.save(userEntity);
        personRoleRepository.save(PersonRoleEntity.builder()
                .roleId(PTUSER)
                .userId(userEntity.getId())
                .build());


    }

    @Override
    public LoginResp login(UserReq userReq) throws Exception {
        UserEntity entity = userRepository.findByPhone(userReq.getPhone());
        if (CommonUtils.isEmpty(entity)) {
            throw new Exception("不存在该用户");
        }
        if (!entity.getPassword().equals(userReq.getPassword())) {
            throw new Exception("密码不正确");
        }
        List<PrivilegeEntity> privilegeEntities = privilegeService.listPersonalPrivilege(entity.getId());
        LoginResp resp = LoginResp.builder()
                .userEntity(entity)
                .privilegeEntities(privilegeEntities)
                .build();
        return resp;
    }

    @Override
    public List<UserEntity> listUser(UserParam param) {
        List<UserEntity> userEntities = userMapper.listUser(param);
        return userEntities;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void modifyPersonRole(Integer userId, Integer roleId) throws Exception {
        UserEntity userEntity = userRepository.findOne(userId);
        RoleEntity roleEntity = roleRepository.findOne(roleId);
        if (!CommonUtils.allIsNotEmpty(userEntity, roleEntity)) {
            throw new Exception("请求资源不存在");
        }
        PersonRoleEntity personRoleEntity = personRoleRepository.findByUserId(userId);
        if (CommonUtils.isEmpty(personRoleEntity)) {
            throw new Exception("请求资源不存在");
        }
        personRoleEntity.setRoleId(roleId);
        userEntity.setRoleId(roleId);
        personRoleRepository.save(personRoleEntity);
        userRepository.save(userEntity);
    }

    @Override
    public void checkPrivilege(Integer userId, PrivilegeEnum privilegeEnum) throws Exception {
        PersonRoleEntity personRoleEntity = personRoleRepository.findByUserId(userId);
        if (CommonUtils.isEmpty(personRoleEntity)) {
            throw new Exception("没有权限");
        }
        List<RolePrivilegeEntity> privilegeEntities = rolePrivilegeRepository.findByRoleId(personRoleEntity.getRoleId());
        if (CommonUtils.isEmpty(privilegeEntities)) {
            throw new Exception("没有权限");
        }
        List<Integer> privilegeIds = privilegeEntities.stream().map(RolePrivilegeEntity::getPrivilegeId).collect(Collectors.toList());
        List<PrivilegeEntity> privilegeEntityList = privilegeRepository.findByIdIn(privilegeIds);
        List<String> privilegeValues = privilegeEntityList.stream().map(PrivilegeEntity::getPrivilegeValue).collect(Collectors.toList());
        if (!privilegeValues.contains(privilegeEnum.getValue())) {
            throw new Exception("没有权限");
        }
    }
}