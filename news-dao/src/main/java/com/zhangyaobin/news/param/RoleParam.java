package com.zhangyaobin.news.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色查询
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleParam extends BaseParam {

    // 角色编号
    private Integer roleId;

    // 角色名称
    private String roleName;
}
