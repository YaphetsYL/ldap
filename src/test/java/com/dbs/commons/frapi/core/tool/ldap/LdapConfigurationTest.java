package com.dbs.commons.frapi.core.tool.ldap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lei
 * @version 1.0
 * @date 2022/3/3 - 03 - 03 - 19:49
 * @Description com.dbs.commons.frapi.core.tool.ldap
 */
class LdapConfigurationTest {

    @Autowired
    private LdapTemplate ldapTemplate;


    @Test
    public void findUser(){

        //uid=123,ou=internal,ou=People,o=xxx.com,o=xxx
        DirContextAdapter obj = (DirContextAdapter) ldapTemplate.lookup("uid=123,ou=internal,ou=People");//BASE_DC 不用填
        System.out.println(obj);
    }

    @Test
    public void findDept(){
        //o=abcd,ou=Organizations,ou=People,o=xxx.com,o=xxx
        DirContextAdapter obj = (DirContextAdapter) ldapTemplate.lookup("o=abcd,ou=People");//BASE_DC 不用填
        System.out.println(obj);
    }
}