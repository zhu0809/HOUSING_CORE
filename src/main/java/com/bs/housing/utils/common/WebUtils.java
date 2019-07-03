package com.bs.housing.utils.common;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/22 17:44</p>
 */
public interface WebUtils {
    /*返回数据*/
    String RESULT = "result";
    String MESSAGE = "message";
    String DATA = "data";
    String STATUS = "status";
    String DATE = "date";
    /*返回数据 end*/
    View VIEW = new MappingJackson2JsonView();

    /*全局数据核心配置*/
//    ConfigurableApplicationContext CONTEXT = App.CONTEXT;
}
