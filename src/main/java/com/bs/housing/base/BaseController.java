package com.bs.housing.base;

import com.bs.housing.utils.WebUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/22 17:40</p>
 */
@RestControllerAdvice
public class BaseController {
    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println(binder.getClass().getName());
    }

    /**
     * 把值绑定 到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "Magical Sam");
    }

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public View errorHandler(Exception ex) {
        return WebUtils.VIEW;
    }
}
