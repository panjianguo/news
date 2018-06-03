package com.zhangyaobin.news.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 修改权限
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModifyPrivilegeReq implements Serializable {

    // 角色编号
    private Integer roleId;

    // 权限编号列表
    private List<Integer> privilegeIds;
}
