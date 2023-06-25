package com.ytx.springcloud.config;

import com.ytx.springcloud.realm.MyRealm;
import jakarta.annotation.Resource;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    @Resource
    private MyRealm myRealm;

    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(3);
        //3将加密对象存储到myRealm中
        myRealm.setCredentialsMatcher(matcher);
        //4将myRealm存入defaultWebSecurityManager对象
        securityManager.setRealm(myRealm);
        return securityManager;
    }


    @Bean
    public DefaultShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        definition.addPathDefinition("/myController/userLogin", "anon");
        definition.addPathDefinition("/login", "anon");
        definition.addPathDefinition("/**", "authc");
        return definition;
    }
}
