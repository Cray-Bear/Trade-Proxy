package com.fty1.trade.k24.proxy.api.core.executor;

import com.fty1.trade.k24.proxy.api.core.module.BusinessQuery;
import com.fty1.trade.k24.proxy.api.core.module.BusinessResult;

/**
 * @author 24KBear
 * @date 2019-11-26 01:48
 * @describe 业务执行器
 */
public interface BusinessExecutor<Q, R> {
    /**
     * 业务执行器，只关注某业务的输入与输出
     * @param query
     * @return
     */
    BusinessResult<R> execute(BusinessQuery<Q> query);
}
