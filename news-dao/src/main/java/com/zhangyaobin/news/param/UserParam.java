package com.zhangyaobin.news.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户查询
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserParam extends BaseParam {

    private String name;

    private String phone;

}
