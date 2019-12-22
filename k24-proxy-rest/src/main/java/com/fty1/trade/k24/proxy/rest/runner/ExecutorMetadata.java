package com.fty1.trade.k24.proxy.rest.runner;

import com.fty1.trade.k24.proxy.api.core.executor.BusinessExecutor;
import lombok.Data;

/**
 * @author 24KBear
 * @date 2019/7/21 下午7:38
 * @describe 执行器元数据
 */
@Data
public class ExecutorMetadata {
    /**
     * 执行器请求参数
     */
    private Class query;
    /**
     * 执行器响应参数
     */
    private Class result;
    private BusinessExecutor execute;
    private String method;
}
