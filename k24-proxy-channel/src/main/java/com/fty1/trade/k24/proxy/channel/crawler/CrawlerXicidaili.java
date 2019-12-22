package com.fty1.trade.k24.proxy.channel.crawler;

import com.fty1.trade.k24.proxy.channel.module.ProxyChannelInfo;
import com.fty1.trade.k24.proxy.channel.repository.ProxyChannelInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 24KBear
 * @date 2019-12-21 19:08
 * @describe //TODO
 */
@Service("Crawler-xicidaili")
@Slf4j
public class CrawlerXicidaili implements ProxyChannelCrawler {

    int timeOut = 3000;


    @Autowired
    private ProxyChannelInfoRepository proxyChannelInfoRepository;

    @Override
    public void crawler(String url) {
        try {
            List<ProxyChannelInfo> proxys = new ArrayList<>();
            Document doc = Jsoup.parse(new URL(url), timeOut);
            Elements els = doc.select("#ip_list tbody tr");
            for (Element ele : els) {
                String host = ele.child(1).text();
                String port = ele.child(2).text();
                log.info("{}-{}",host,port);
                ProxyChannelInfo proxyChannelInfo = new ProxyChannelInfo();
                proxyChannelInfo.setHost(host);
                proxyChannelInfo.setPort(port);
                proxyChannelInfo.setChannel("Crawler-xicidaili");
                proxys.add(proxyChannelInfo);
            }
            proxyChannelInfoRepository.saveAll(proxys);
        } catch (Exception e) {
            log.error("渠道{}-{}-爬取异常", url, timeOut, e);
        }
    }
}
