package com.zhangyaobin.news.mapper;

import com.zhangyaobin.news.entity.RoleEntity;
import com.zhangyaobin.news.param.RoleParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 一句话功能简述
 */
@Repository
public interface RoleMapper {

    List<RoleEntity> listRole(RoleParam roleParam);
}
