package com.fty1.trade.k24.proxy.api.core.module;

import lombok.Data;

/**
 * @author 24KBear
 * @date 2019-11-26 02:03
 * @describe 业务逻辑运行期信息
 */
@Data
public class BusinessRunTimeResult {

    /**
     * 业务操作返回码
     */
    private String code;

    /**
     * 业务操作返回信息
     */
    private String message;

}
