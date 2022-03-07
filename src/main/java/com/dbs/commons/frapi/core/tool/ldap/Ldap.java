package com.dbs.commons.frapi.core.tool.ldap;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lei
 * @version 1.0
 * @date 2022/3/3 - 03 - 03 - 19:40
 * @Description com.dbs.commons.frapi.core.tool.ldap
 */
@ConfigurationProperties(prefix = "ldap")
@Configuration("ldapProperties")
@Getter
@Setter
public class Ldap {
    private String url;

    private String base;

    private String username;

    private String password;
}
