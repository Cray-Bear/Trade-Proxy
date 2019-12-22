package com.fty1.trade.k24.proxy.audit.module;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 24KBear
 * @date 2019-12-21 17:26
 * @describe //TODO
 */
@Data
public class ProxyInfoPK implements Serializable {

    private String host;

    private String port;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProxyInfoPK that = (ProxyInfoPK) o;
        return Objects.equals(host, that.host) && Objects.equals(port, that.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port);
    }
}
