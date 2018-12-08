package com.bs.housing.controller.account;

import com.bs.housing.base.BaseController;
import com.bs.housing.utils.WebUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/12/8 13:55</p>
 */
@RestController
@RequestMapping("user")
public class AccountController extends BaseController {

    @RequestMapping(name = "login", method = RequestMethod.POST)
    public View login(String username, String password, HttpServletResponse response, HttpServletRequest request) {
        return WebUtils.VIEW;
    }
}
