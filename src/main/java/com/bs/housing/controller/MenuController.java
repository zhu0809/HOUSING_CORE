package com.bs.housing.controller;

import com.bs.housing.base.BaseController;
import com.bs.housing.utils.WebUtils;
import com.bs.housing.core.exception.ServiceException;
import com.bs.housing.core.mapper.DozerMapper;
import com.bs.housing.dto.MenuDTO;
import com.bs.housing.po.MenuPO;
import com.bs.housing.service.MenuService;
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
import java.util.Map;
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
