package com.fty1.trade.k24.proxy.api.core.executor;

import com.fty1.trade.k24.proxy.api.core.module.BusinessQuery;
import com.fty1.trade.k24.proxy.api.core.module.BusinessResult;
import com.fty1.trade.k24.proxy.api.utils.BusinessResults;
import com.fty1.trade.k24.proxy.api.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 24KBear
 * @date 2019-11-30 18:13
 * @describe 业务处理器
 */
@Component
@Slf4j
public class BusinessServerHandle {


    @Autowired
    private ConcurrentHashMap<String, BusinessExecutor> businessExecutorCollectMap;


    public BusinessResult handle(String handle, BusinessQuery query) {
        log.info("业务服务-{}-{}", handle, query);
        BusinessResult result = BusinessResults.failure();
        BusinessExecutor executor = businessExecutorCollectMap.get(handle);
        if (Objects.isNull(executor)) {
            log.error("业务服务-业务逻辑【{}】不支持", handle);
            return result;
        }
        try {
            Type[] interfacesType = executor.getClass().getGenericInterfaces();
            String queryClassName = ((ParameterizedType) interfacesType[0]).getActualTypeArguments()[0].getTypeName();
            String resultClassName = ((ParameterizedType) interfacesType[0]).getActualTypeArguments()[1].getTypeName();
            Class<?> queryClass = ClassUtils.getClass(queryClassName);
            Class<?> resultClass = ClassUtils.getClass(resultClassName);
            query.setQuery(JsonUtils.toAJavaObject(query.getQuery(), queryClass).get());
            result = executor.execute(query);
            if (!Objects.isNull(result.getData())) {
                result.setData(JsonUtils.toAJavaObject(result.getData(), resultClass).get());
            }
        } catch (Exception e) {
            log.error("业务服务-业务逻辑【{}】执行异常", handle, e);
        }
        log.info("鉴权服务-{}-{}-{}", handle, query, result);
        return result;
    }
}
