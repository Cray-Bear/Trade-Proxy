package com.fty1.trade.k24.proxy.api.utils;

import com.fty1.trade.k24.proxy.api.core.module.BusinessResult;

import java.util.Objects;

/**
 * @author 24KBear
 * @date 2019-11-26 00:56
 * @describe BusinessResult工具类
 */
public class BusinessResults {

    private static final BusinessResult<Object> notoken = BusinessResult.<Object>builder().code("30000").message("登录失效").build();
    private static final BusinessResult<Object> failure = BusinessResult.<Object>builder().code("40000").message("操作失败").build();
    private static final BusinessResult<Object> unhappy = BusinessResult.<Object>builder().code("40000").message("服务器小情绪,稍后再试!").build();

    /**
     * 系统异常返回值
     *
     * @param <T> 异常返回参数
     * @return
     */
    public static <T> BusinessResult<T> failure() {
        return (BusinessResult<T>) failure;
    }

    public static <T> BusinessResult<T> unhappy() {
        return (BusinessResult<T>) unhappy;
    }

    /**
     * 无登录态返回值
     *
     * @param <T>
     * @return
     */
    public static <T> BusinessResult<T> notoken() {
        return (BusinessResult<T>) notoken;
    }

    /**
     * 系统正常返回值
     *
     * @param <T> 正常返回参数
     * @return
     */
    public static <T> BusinessResult<T> success(T data) {
        return BusinessResult.<T>builder().code("20000").message("操作成功").data(data).build();
    }

    public static boolean isSuccess(BusinessResult res) {

        return !Objects.isNull(res) && "20000".equals(res.getCode());
    }
}
