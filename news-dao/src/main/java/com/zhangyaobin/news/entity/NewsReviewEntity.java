package com.zhangyaobin.news.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 评论
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review")
public class NewsReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 新闻Id
    @Column
    private Integer newsId;

    // 评论
    @Column
    private String content;

    // 添加人
    @Column
    private Integer addUserId;

    // 添加人名称
    @Column
    private String addUserName;



}
