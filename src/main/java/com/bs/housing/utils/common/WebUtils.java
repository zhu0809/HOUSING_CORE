package com.bs.housing.utils.common;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * <p> @类描述：全局常用变量 </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/22 17:44</p>
 */
public interface WebUtils {
    /*返回数据*/
    public static final String RESULT = "result";
    public static final String MESSAGE = "message";
    public static final String DATA = "data";
    public static final String STATUS = "status";
    public static final String DATE = "date";
    /*返回数据 end*/
    View VIEW = new MappingJackson2JsonView();

    /*全局数据核心配置*/
//    ConfigurableApplicationContext CONTEXT = App.CONTEXT;
}
