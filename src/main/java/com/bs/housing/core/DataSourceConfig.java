package com.bs.housing.core;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/12/4 9:39</p>
 */
@Configuration
public class DataSourceConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean
    public ServletRegistrationBean statviewServlet() {
        //设置访问路径
        ServletRegistrationBean bean
                = new ServletRegistrationBean(
                new StatViewServlet(), "/druid/*");
        Map<String, String> parms = new HashMap<>();
        parms.put("loginPassword", "root");
        parms.put("loginUsername", "root");//账号 密码
//        parms.put("allow", "localhost");//允许访问的地址
//        parms.put("deny", "www.baidu.com");//不允许访问的地址
        bean.setInitParameters(parms);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        Map<String, String> parms = new HashMap<>();
        parms.put("exclusions", "*.js,*.css,/druid");//放行的资源
        bean.setInitParameters(parms);
        bean.setUrlPatterns(Arrays.asList("/druid", "/**"));
        return bean;
    }
}
