package com.bs.housing.utils;

import com.bs.housing.App;
import org.springframework.context.ConfigurableApplicationContext;
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
    View VIEW = new MappingJackson2JsonView();
    String MESSAGE = "message";
    String DATA = "data";
    String STATUS = "status";
    /*返回数据 end*/
    /*全局数据核心配置*/
    ConfigurableApplicationContext CONTEXT = App.CONTEXT;
}
