package com.fty1.trade.k24.proxy.audit.repository;

import com.fty1.trade.k24.proxy.audit.module.ProxyChannelInfo;
import com.fty1.trade.k24.proxy.audit.module.ProxyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author 24KBear
 * @date 2019-11-28 23:23
 * @describe
 */
public interface ProxyChannelInfoRepository extends JpaRepository<ProxyChannelInfo, String> {
    @Query(value = "select * from proxy_channel_info  ORDER BY RAND() LIMIT 1", nativeQuery = true)
    ProxyChannelInfo single();
}
