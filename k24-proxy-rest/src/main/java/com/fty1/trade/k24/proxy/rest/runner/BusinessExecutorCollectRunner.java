package com.fty1.trade.k24.proxy.rest.runner;

import com.fty1.trade.k24.proxy.api.core.executor.BusinessExecutor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 24KBear
 * @date 2019/7/23 上午6:32
 * @describe 系统启动之后收集执行器
 */
@Component
@Slf4j
public class BusinessExecutorCollectRunner implements ApplicationRunner {

    @Autowired
    private ConcurrentHashMap<String, BusinessExecutor> businessExecutorCollectMap;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) {
        log.info("系统指令初始化开始...");
        Map<String, BusinessExecutor> commandBeanMap = applicationContext.getBeansOfType(BusinessExecutor.class);
        if (!MapUtils.isEmpty(commandBeanMap)) {
            businessExecutorCollectMap.putAll(commandBeanMap);
        }
        businessExecutorCollectMap.forEach((k, v) -> log.info("系统指令:{}-{}", k, v));
        log.info("系统指令初始化结束.");
    }
}
