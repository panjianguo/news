package com.zhangyaobin.news.mapper;

import com.zhangyaobin.news.entity.UserEntity;
import com.zhangyaobin.news.param.UserParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 一句话功能简述
 */
@Repository
public interface UserMapper {

    List<UserEntity> listUser(UserParam userParam);
}
