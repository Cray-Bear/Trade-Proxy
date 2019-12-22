package com.fty1.trade.k24.proxy.audit.schedule;

import com.fty1.trade.k24.proxy.audit.module.ProxyChannelInfo;
import com.fty1.trade.k24.proxy.audit.repository.ProxyChannelInfoRepository;
import com.fty1.trade.k24.proxy.audit.service.ProxyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author 24KBear
 * @date 2019-12-21 20:00
 * @describe //TODO
 */
@Component
@Slf4j
public class ScheduleProxy {

    @Autowired
    private ProxyService proxyService;


    @Autowired
    private ProxyChannelInfoRepository proxyChannelInfoRepository;

    @Scheduled(fixedDelay = 1000)
    public void check() {
        try {
            ProxyChannelInfo data = proxyChannelInfoRepository.single();
            if (!Objects.isNull(data)) {
                boolean res = proxyService.check(data.getHost(), data.getPort());
                if (res) {
                    log.info("{}-{}", data.getHost(), data.getPort());
                }
            }
        } catch (Exception e) {

        }
    }

}
