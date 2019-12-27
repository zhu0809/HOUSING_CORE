package com.bs.housing.controller.menu;

import com.alibaba.druid.pool.DruidDataSource;
import com.bs.housing.core.base.BaseController;
import com.bs.housing.core.exception.ServiceException;
import com.bs.housing.dto.MenuDTO;
import com.bs.housing.po.MenuPO;
import com.bs.housing.service.MenuService;
import com.bs.housing.utils.common.DozerMapper;
import com.bs.housing.utils.common.WebUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/29 17:58</p>
 */
@RestController
@RequestMapping("menu")
public class MenuController extends BaseController {
    @Autowired
    MenuService menuService;

    @Autowired
    DruidDataSource druidDataSource;

    public MenuController() {
        JSONObject jsonObject = JSONObject.fromObject(druidDataSource);
        System.out.println(jsonObject);
    }

    @RequestMapping(value = "getAllMenu", method = RequestMethod.GET)
    View getAllMenu(HttpServletResponse response, HttpServletRequest request, ModelMap modelMap) {
        List<MenuPO> all = menuService.menuTree();
        List<MenuDTO> menuDTOS = DozerMapper.mapperList(all, MenuDTO.class);
        modelMap.addAttribute("menuList", menuDTOS);
        return WebUtils.VIEW;
    }

    /**
     * <p> @方法描述：	                </p>
     * <p> @创建人：	ZhuRongguo	        </p>
     * <p> @创建时间：2018/12/5 15:53   	</p>
     * <p> @修改人：	ZhuRongguo	        </p>
     * <p> @修改时间：2018/12/5 15:53	</p>
     * <p> @修改说明：	                </p>
     *
     * @param response
     * @param request
     * @param modelMap
     * @return org.springframework.web.servlet.View
     */
    @RequestMapping(value = "menuTree")
    View menuTree(HttpServletResponse response, HttpServletRequest request, ModelMap modelMap) {
        System.out.println(JSONObject.fromObject(druidDataSource));

        menuService.menuTree(modelMap);
        return WebUtils.VIEW;
    }

    /**
     * <p> @方法描述：	                </p>
     * <p> @创建人：	ZhuRongguo	        </p>
     * <p> @创建时间：2018/12/5 15:54   	</p>
     * <p> @修改人：	ZhuRongguo	        </p>
     * <p> @修改时间：2018/12/5 15:54	</p>
     * <p> @修改说明：	                </p>
     *
     * @param isResource 是否认是资源  否则为文件夹
     * @param dto        目录
     * @param response
     * @param request
     * @param modelMap
     * @return org.springframework.web.servlet.View
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    View fp(boolean isResource, MenuDTO dto, HttpServletResponse response, HttpServletRequest request, ModelMap modelMap) {
        try {
            menuService.save(isResource, dto);
            modelMap.addAttribute(WebUtils.STATUS, true);
        } catch (ServiceException e) {
            modelMap.addAttribute(WebUtils.STATUS, false);
            e.printStackTrace();
        }
        return WebUtils.VIEW;
    }

    /**
     * @param dto      实体
     * @param response 返回信息
     * @param request  请求信息
     * @param modelMap 入参列表
     * @return View
     * 2019-12-27 14:46:24 朱荣果
     */
    @RequestMapping(value = "fp", method = RequestMethod.GET)
    View save(MenuDTO dto, HttpServletResponse response, HttpServletRequest request, ModelMap modelMap) {
        Page<MenuPO> page = menuService.findPage(dto);

        modelMap.addAttribute(WebUtils.DATA, page.stream().collect(Collectors.toList()));
        modelMap.addAttribute("draw", dto.getThisPage());
        modelMap.addAttribute("recordsTotal", page.getTotalElements());
        modelMap.addAttribute("recordsFiltered", page.getTotalElements());

        return WebUtils.VIEW;
    }
}
