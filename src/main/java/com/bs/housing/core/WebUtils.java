package com.bs.housing.core;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/22 17:44</p>
 */
public interface WebUtils {
    View VIEW = new MappingJackson2JsonView();

    String RESULT = "result";
    String MESSAGE = "message";
    String DATA = "data";
    String STATUS = "status";
//    String OBJECT = "object";
}
