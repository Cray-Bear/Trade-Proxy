package com.fty1.trade.k24.proxy.audit.executor;

import com.fty1.trade.k24.proxy.audit.mode.ProxyInfoQuery;
import com.fty1.trade.k24.proxy.audit.mode.ProxyInfoResult;
import com.fty1.trade.k24.proxy.audit.module.ProxyInfo;
import com.fty1.trade.k24.proxy.api.core.executor.BusinessExecutor;
import com.fty1.trade.k24.proxy.api.core.module.BusinessQuery;
import com.fty1.trade.k24.proxy.api.core.module.BusinessResult;
import com.fty1.trade.k24.proxy.api.utils.BusinessResults;
import com.fty1.trade.k24.proxy.audit.service.ProxyInfoHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 24KBear
 * @date 2019-11-26 02:00
 * @describe 代理信息查询业务执行器
 */
@Service("ProxyInfo")
public class ProxyInfoExecutor implements BusinessExecutor<ProxyInfoQuery, ProxyInfoResult> {


    @Autowired
    private ProxyInfoHandleService proxyInfoHandleService;

    @Override
    public BusinessResult<ProxyInfoResult> execute(BusinessQuery<ProxyInfoQuery> query) {
        Optional<ProxyInfo> resultOptional = proxyInfoHandleService.single();
        if (resultOptional.isPresent()) {
            ProxyInfo proxyInfo = resultOptional.get();
            ProxyInfoResult proxyInfoResult = new ProxyInfoResult();
            proxyInfoResult.setHost(proxyInfo.getHost());
            proxyInfoResult.setPort(proxyInfo.getPort());
            return BusinessResults.success(proxyInfoResult);
        }
        return BusinessResults.failure();
    }
}
