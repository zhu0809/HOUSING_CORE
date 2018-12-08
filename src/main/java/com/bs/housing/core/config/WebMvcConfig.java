package com.bs.housing.core.config;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/12/7 9:23</p>
 */
public class WebMvcConfig extends WebMvcConfigurationSupport {

    private static final Logger logger = Logger
            .getLogger(WebMvcConfig.class);

    /**
     * 描述 : <注册视图处理器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        logger.info("ViewResolver");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/views/jsp/function/");
//        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * 描述 : <注册消息资源处理器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        logger.info("MessageSource");
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("config.messages.messages");

        return messageSource;
    }

    /**
     * 描述 : <注册servlet适配器>. <br>
     * <p>
     * <只需要在自定义的servlet上用@Controller("映射路径")标注即可>
     * </p>
     *
     * @return
     */
    @Bean
    public HandlerAdapter servletHandlerAdapter() {
        logger.info("HandlerAdapter");
        return new SimpleServletHandlerAdapter();
    }

    /**
     * 描述 : <本地化拦截器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @return
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        logger.info("LocaleChangeInterceptor");
        return new LocaleChangeInterceptor();
    }

    /**
     * 描述 : <基于cookie的本地化资源处理器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @return
     */
    @Bean(name = "localeResolver")
    public CookieLocaleResolver cookieLocaleResolver() {
        logger.info("CookieLocaleResolver");
        return new CookieLocaleResolver();
    }

    /**
     * 描述 : <添加拦截器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        logger.info("addInterceptors start");
        registry.addInterceptor(localeChangeInterceptor());
        logger.info("addInterceptors end");
    }

    /**
     * 描述 : <资源访问处理器>. <br>
     * <p>
     * <可以在jsp中使用/static/**的方式访问/WEB-INF/static/下的内容>
     * </p>
     *
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("addResourceHandlers");
        registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
    }

    /**
     * 描述 : <文件上传处理器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @return
     */
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver() {
        logger.info("CommonsMultipartResolver");
        return new CommonsMultipartResolver();
    }

    /**
     * 描述 : <异常处理器>. <br>
     * <p>
     * <系统运行时遇到指定的异常将会跳转到指定的页面>
     * </p>
     *
     * @return
     */
    @Bean(name = "exceptionResolver")
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        logger.info("CP_SimpleMappingExceptionResolver");
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        simpleMappingExceptionResolver.setDefaultErrorView("common_error");
        simpleMappingExceptionResolver.setExceptionAttribute("exception");
        Properties properties = new Properties();
        properties.setProperty("java.lang.RuntimeException", "common_error");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }

}

