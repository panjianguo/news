package com.zhangyaobin.news.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 新闻查询
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsParam extends BaseParam {

    // 新闻标题
    private String title;

    // 添加人名称
    private String addUserName;

    // 类型编号
    private Short typeId;
}
