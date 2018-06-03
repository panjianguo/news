package com.zhangyaobin.news.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 角色
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleReq implements Serializable {

    // 角色编号
    private Integer id;

    // 角色名称
    private String name;

}
