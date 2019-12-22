package com.fty1.trade.k24.proxy.audit.module;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 24KBear
 * @date 2019-11-28 22:18
 * @describe 文件信息
 */
@Entity
@Data
@Table(name = "ProxyInfo")
@EntityListeners(AuditingEntityListener.class)
@IdClass(ProxyInfoPK.class)
public class ProxyInfo {

    /**
     * 主机
     */
    @Id
    @Column(length = 64, unique = true, nullable = false)
    private String host;

    /**
     * 端口
     */
    @Id
    @Column(length = 64, unique = true, nullable = false)
    private String port;


    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date ctime;

    @LastModifiedDate
    @Column(nullable = false)
    private Date utime;

    @Version
    private Long ver;
}
