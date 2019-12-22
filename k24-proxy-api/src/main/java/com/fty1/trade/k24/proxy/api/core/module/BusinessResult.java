package com.fty1.trade.k24.proxy.api.core.module;

import lombok.Builder;
import lombok.Data;

/**
 * @author 24KBear
 * @date 2019-11-24 23:57
 * @describe //TODO
 */
@Data
@Builder
public class BusinessResult<T> {
    private String code;
    private String message;
    private T data;
}
