package com.fty1.trade.k24.proxy.api.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;

import java.util.List;
import java.util.Optional;

/**
 * @author 24KBear
 * @date 2019/7/27 下午5:03
 * @describe TODO //描述
 */
public class JsonUtils {

    public static <T> Optional<T> toObject(Object obj, Class<T> clz) {

        if (obj == null) {
            return Optional.empty();
        }

        if (obj instanceof String) {
            return Optional.ofNullable(JSON.parseObject((String)obj, clz));
        }

        return Optional.ofNullable(JSON.parseObject(JSON.toJSONString(obj), clz));
    }

    public static <T> Optional<List<T>> toArray(Object obj, Class<T> clz) {
        return Optional.ofNullable(JSON.parseArray(JSON.toJSONString(obj), clz));
    }

    public static Optional<String> toJSONString(Object obj) {

        if (obj == null) {
            return Optional.empty();
        }

        if (obj instanceof String) {
            return Optional.of((String) obj);
        }

        return Optional.ofNullable(JSON.toJSONString(obj));
    }


    public static <T> Optional<T> toAJavaObject(Object data, String path, Class<T> cls) {
        Object da = JSONPath.eval(data, path);
        return Optional.ofNullable(JSON.toJavaObject((JSON) JSON.toJSON(da), cls));
    }

    public static <T> Optional<T> toAJavaObject(Object data, Class<T> cls) {
        Object da = JSONPath.eval(data, "$");
        return Optional.ofNullable(JSON.toJavaObject((JSON) JSON.toJSON(da), cls));
    }

    public static <T> Optional<List<T>> toJavaCollect(Object data, String path, Class<T> cls) {
        Object da = JSONPath.eval(data, path);
        return Optional.ofNullable(JSON.parseArray(JSON.toJSONString(da), cls));
    }

}
