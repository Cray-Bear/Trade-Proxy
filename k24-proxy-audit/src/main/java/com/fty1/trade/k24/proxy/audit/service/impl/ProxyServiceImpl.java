package com.fty1.trade.k24.proxy.audit.service.impl;

import com.fty1.trade.k24.proxy.audit.service.ProxyService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;

/**
 * @author 24KBear
 * @date 2019-12-21 20:02
 * @describe //TODO
 */
@Service
public class ProxyServiceImpl implements ProxyService {

    @Override
    public boolean check(String host, String port) {

        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, Integer.valueOf(port)));
            Connection connection = Jsoup.connect("http://www.fty1.com/").proxy(proxy);
            return !Objects.isNull(connection);
        } catch (Exception e) {
        }
        return false;
    }
}
