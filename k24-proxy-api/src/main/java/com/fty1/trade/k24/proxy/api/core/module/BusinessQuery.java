package com.fty1.trade.k24.proxy.api.core.module;

import lombok.Data;

import java.util.List;
import java.util.Optional;

/**
 * @author 24KBear
 * @date 2019-11-24 23:57
 * @describe 业务查询参数
 */
@Data
public class BusinessQuery<T> {

    private String taskCode;

    /**
     * 业务处理参数
     */
    T query;
}
