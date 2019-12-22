package com.fty1.trade.k24.proxy.rest.runner;

import com.fty1.trade.k24.proxy.api.core.executor.BusinessExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 24KBear
 * @date 2019-12-09 22:11
 * @describe //TODO
 */
@Configuration
public class BusinessExecutorConfig {

    @Bean("businessExecutorCollectMap")
    @Primary
    public ConcurrentHashMap<String, BusinessExecutor> businessExecutorCollectMap() {
        return new ConcurrentHashMap<>(16);
    }
}
