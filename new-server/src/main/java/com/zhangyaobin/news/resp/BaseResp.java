package com.zhangyaobin.news.resp;

import lombok.*;

/**
 * 返回消息
 *
 * @author Chenlm
 * @version 2016-04-19-09:30
 */
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BaseResp<T> {
    @Getter
    private Integer retCode;
    @Getter
    private String retMsg;
    @Getter
    private T data;

    public static <T> BaseResp<T> ok(T data) {
        return BaseResp.<T>builder()
                .data(data)
                .retCode(0)
                .retMsg("操作成功")
                .<T>build();
    }

    public static BaseResp ok() {
        return ok(null);
    }

    public static BaseResp fail(Integer failCode, String failMsg) {
        return BaseResp.builder().retCode(failCode).retMsg(failMsg).build();
    }

}
