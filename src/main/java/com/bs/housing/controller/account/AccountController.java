package com.bs.housing.controller.account;

import com.bs.housing.base.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
@RequestMapping(value = "account")
public class AccountController extends BaseController {

    @RequestMapping(method = RequestMethod.POST, value = "login")
    public View login(String username, String password, HttpServletResponse response, HttpServletRequest request) {
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        if (user.isAuthenticated()) {//已经认证
            user.login(usernamePasswordToken);
        }

        return null;
    }
}
