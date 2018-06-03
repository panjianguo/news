package com.zhangyaobin.news.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 人员
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_info")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 12)
    private String name;

    // 年龄
    @Column
    private Integer age;

    @Column
    private Date addTime;

    // 手机号码
    @Column
    private String phone;

    @Column
    private Integer level;

    // 角色编号
    @Column
    private Integer roleId;

    // 密码
    @Column
    private String password;
}
