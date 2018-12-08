package com.bs.housing.controller.account;

import com.bs.housing.base.BaseController;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p> @类描述：	   账号：包括登陆  </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/12/7 23:07</p>
 */
@RequestMapping("account")
@Controller
public class AccountController extends BaseController {

    /**
     * <p> @方法描述：	登陆            </p>
     * <p> @创建人：	ZhuRongguo	        </p>
     * <p> @创建时间：2018/12/7 23:56   	</p>
     * <p> @修改人：	ZhuRongguo	        </p>
     * <p> @修改时间：2018/12/7 23:56	    </p>
     * <p> @修改说明：	                </p>
     *
     * @param username
     * @param password
     * @return void
     */
    @PostMapping(name = "login")
    public void login(@Param(value = "username") String username, @Param(value = "password") String password) {
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        if (user.isAuthenticated()) {//已经认证
            user.login(usernamePasswordToken);
        }
    }
}
