package com.zhangyaobin.news.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * 新闻
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "news")
public class NewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 标题
    @Column(length = 64)
    private String title;

    // 概要
    @Column
    private String summary;

    // 内容
    @Column
    private String content;

    // 类型
    @Column
    private Short typeId;

    // 类型名称
    @Column
    private String typeName;

    // 阅读次数
    @Column
    private Integer number;

    // 添加人编号
    @Column
    private Integer addUserId;

    // 添加人姓名
    @Column
    private String addUserName;

    // 图片编号
    @NotEmpty(message = "必须有图片")
    @Column
    private String picId;

    // 添加时间
    @Column
    private Date addTime;
}
