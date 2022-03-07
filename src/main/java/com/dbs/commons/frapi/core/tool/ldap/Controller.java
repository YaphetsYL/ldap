package com.dbs.commons.frapi.core.tool.ldap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lei
 * @version 1.0
 * @date 2022/3/7 - 03 - 07 - 16:53
 * @Description com.dbs.commons.frapi.core.tool.ldap
 */

@RestController
public class Controller {

    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }
}
