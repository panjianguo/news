package com.zhangyaobin.news.common;

import lombok.Getter;

import java.util.Arrays;

/**
 * 权限枚举
 */
@Getter
public enum PrivilegeEnum {

    NEW_LIST("news_list", "新闻列表"),
    USER_LIST("user_list", "用户列表"),
    MODIFY_USER_ROLE("modify_user_role", "变更人员角色"),
    MODIFY_ROLE_PRIVILEGE("modify_role_privilege","修改角色权限"),
    MODIFY_NEWS("modify_news","添加修改新闻")
    ;

    private String value;
    private String name;

    PrivilegeEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public static PrivilegeEnum valueOfEnum(String value) {
        if (null == value) {
            return null;
        }
        return Arrays.stream(PrivilegeEnum.values())
                .filter(privilegeEnum -> privilegeEnum.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }



}
