package com.zhangyaobin.news.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReq implements Serializable {

    private Integer id;

    private String name;

    // 年龄
    private Integer age;

    // 身份证号
    private String idCard;

    private Date addTime;

    // 手机号码
    private String phone;

    // 密码
    private String password;
}
