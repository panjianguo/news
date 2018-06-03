package com.zhangyaobin.news.mapper;

import com.zhangyaobin.news.entity.PrivilegeEntity;
import com.zhangyaobin.news.param.CommonParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限
 */
@Repository
public interface PrivilegeMapper {

    List<PrivilegeEntity> listPrivilege(CommonParam param);
}
