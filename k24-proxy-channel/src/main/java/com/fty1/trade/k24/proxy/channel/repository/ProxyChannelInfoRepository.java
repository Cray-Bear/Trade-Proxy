package com.fty1.trade.k24.proxy.channel.repository;

import com.fty1.trade.k24.proxy.channel.module.ProxyChannelInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 24KBear
 * @date 2019-11-28 23:23
 * @describe
 */
public interface ProxyChannelInfoRepository extends JpaRepository<ProxyChannelInfo, String> {

}
