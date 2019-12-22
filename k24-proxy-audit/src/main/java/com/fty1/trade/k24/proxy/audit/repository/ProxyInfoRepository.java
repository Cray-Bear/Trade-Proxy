package com.fty1.trade.k24.proxy.audit.repository;

import com.fty1.trade.k24.proxy.audit.module.ProxyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author 24KBear
 * @date 2019-11-28 23:23
 * @describe
 */
public interface ProxyInfoRepository extends JpaRepository<ProxyInfo, String> {
    @Query(value = "select * from proxy_info  ORDER BY RAND() LIMIT 1", nativeQuery = true)
    ProxyInfo single();
}
