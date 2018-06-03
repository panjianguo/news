package com.zhangyaobin.news.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 一句话功能简述
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsReq implements Serializable {

    private Integer id;

    private String title;

    private String summary;

    // 内容
    private String content;

    // 类型
    private Short typeId;

    // 类型名称
    private String typeName;

    // 添加人编号
    private Integer addUserId;

    // 添加人姓名
    private String addUserName;

    // 添加时间
    private Date addTime;
}
