package com.bs.housing.core.config.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/12/7 23:26</p>
 */
@Configuration
public class HashedCredentialsMatcherConfig {
    @Bean()
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    @Bean()
    public SecurityManager securityManager(RealmConfig authRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        return manager;
    }

    @Bean()
    public Realm realm() {
        Realm manager = new RealmConfig();
        return manager;
    }

    @Bean()
    public RealmConfig authRealm(HashedCredentialsMatcher matcher) {
        RealmConfig authRealm = new RealmConfig();
        authRealm.setCredentialsMatcher(matcher);
        return authRealm;
    }

  //  @Bean()
    public ShiroFilterFactoryBean shiroFilter(SecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置securityManager
        bean.setSecurityManager(manager);
        //设置登录页面
        //可以写路由也可以写jsp页面的访问路径
        bean.setLoginUrl("/static/login.html");
        //设置登录成功跳转的页面
        bean.setSuccessUrl("/static/index.html");
        //设置未授权跳转的页面
        bean.setUnauthorizedUrl("/static/404.html");
        //定义过滤器
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();


        filterChainDefinitionMap.put("/account/logout", "logout");

        filterChainDefinitionMap.put("/account/login", "anon");
        filterChainDefinitionMap.put("/static/images/**", "anon");
        filterChainDefinitionMap.put("/static/scripts/**", "anon");
        filterChainDefinitionMap.put("/static/style/**", "anon");
        filterChainDefinitionMap.put("/druid/**", "anon");

//        filterChainDefinitionMap.put("/admin", "roles[admin]");
//        filterChainDefinitionMap.put("/edit", "perms[delete]");
        //需要登录访问的资源 , 一般将/**放在最下边
        filterChainDefinitionMap.put("/**", "authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

}
