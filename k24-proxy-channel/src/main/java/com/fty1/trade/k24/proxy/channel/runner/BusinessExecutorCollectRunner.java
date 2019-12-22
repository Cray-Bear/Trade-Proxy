package com.fty1.trade.k24.proxy.channel.runner;

import com.fty1.trade.k24.proxy.channel.crawler.ProxyChannelCrawler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author 24KBear
 * @date 2019/7/23 上午6:32
 * @describe 系统启动之后收集执行器
 */
@Component
@Slf4j
public class BusinessExecutorCollectRunner implements ApplicationRunner {

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${crawler.exector}")
    private String exector;

    private String tem = "https://www.xicidaili.com/nn/%s";

    @Override
    public void run(ApplicationArguments args) {
        log.info("系统指令初始化开始...");
        try {
            ProxyChannelCrawler bean = applicationContext.getBean(exector, ProxyChannelCrawler.class);
            for (int i = 1; i < 3968; i++) {
                String url = String.format(tem, i);
                try {
                    bean.crawler(url);
                    Thread.sleep(2000);
                } catch (Exception e) {
                    log.error("爬取异常-{}", url, e);
                }
            }
        } catch (Exception e) {
            log.error("执行异常", e);
        }
        log.info("系统指令初始化结束.");
    }
}
