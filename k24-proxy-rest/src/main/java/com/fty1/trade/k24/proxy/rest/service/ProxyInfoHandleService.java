package com.fty1.trade.k24.proxy.rest.service;

import com.fty1.trade.k24.proxy.rest.module.ProxyInfo;

import java.util.Optional;

/**
 * @author 24KBear
 * @date 2019-12-15 17:59
 * @describe 代理操作
 */
public interface ProxyInfoHandleService {
    Optional<ProxyInfo> single();
}
