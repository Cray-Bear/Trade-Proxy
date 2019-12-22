package com.fty1.trade.k24.proxy.rest.server;

import com.fty1.trade.k24.proxy.api.core.module.BusinessResult;
import com.fty1.trade.k24.proxy.api.utils.BusinessResults;
import com.fty1.trade.k24.proxy.rest.mode.ProxyInfoResult;
import com.fty1.trade.k24.proxy.rest.module.ProxyInfo;
import com.fty1.trade.k24.proxy.rest.service.ProxyInfoHandleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author 24KBear
 * @date 2019-11-26 00:37
 * @describe 文件服务处理
 */
@Slf4j
@RestController
public class PProxyHandleServer {

    @Autowired
    private ProxyInfoHandleService proxyInfoHandleService;

    /**
     * @param handle 业务处理执行编码
     * @param query  业务处理参数
     * @return
     */
    @PostMapping("/single")
    @ResponseBody
    public BusinessResult<ProxyInfoResult> handle() {
        BusinessResult result = BusinessResults.failure();
        try {
            Optional<ProxyInfo> resultOptional = proxyInfoHandleService.single();
            if (resultOptional.isPresent()) {
                ProxyInfo proxyInfo = resultOptional.get();
                ProxyInfoResult proxyInfoResult = new ProxyInfoResult();
                proxyInfoResult.setHost(proxyInfo.getHost());
                proxyInfoResult.setPort(proxyInfo.getPort());
                return BusinessResults.success(proxyInfoResult);
            }
        } catch (Exception e) {
            log.info("代理服务-处理异常-{}", result, e);
        }
        log.info("代理服务-处理结果-{}", result);
        return result;
    }
}
