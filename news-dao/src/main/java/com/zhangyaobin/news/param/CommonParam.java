package com.zhangyaobin.news.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 一句话功能简述
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonParam extends BaseParam {

    private String name;
}
