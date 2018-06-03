package com.zhangyaobin.news.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 分页
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseParam implements Serializable {

    private Integer index;

    private Integer pageNumber;
}
