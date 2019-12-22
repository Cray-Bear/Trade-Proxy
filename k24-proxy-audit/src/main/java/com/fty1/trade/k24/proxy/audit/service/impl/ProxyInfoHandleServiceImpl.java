package com.fty1.trade.k24.proxy.audit.service.impl;

import com.fty1.trade.k24.proxy.audit.module.ProxyInfo;
import com.fty1.trade.k24.proxy.audit.repository.ProxyInfoRepository;
import com.fty1.trade.k24.proxy.audit.service.ProxyInfoHandleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * @author 24KBear
 * @date 2019-12-15 18:02
 * @describe //TODO
 */
@Service
@Slf4j
public class ProxyInfoHandleServiceImpl implements ProxyInfoHandleService {


    @Autowired
    private ProxyInfoRepository proxyInfoRepository;

    @Override
    public Optional<ProxyInfo> single() {
        ProxyInfo res = proxyInfoRepository.single();
        if (!Objects.isNull(res)) {
            return Optional.of(res);
        }
        return Optional.empty();
    }
}
