package com.bs.housing.controller;

import com.bs.housing.base.BaseController;
import com.bs.housing.core.WebUtils;
import com.bs.housing.core.exception.ServiceException;
import com.bs.housing.core.mapper.DozerMapper;
import com.bs.housing.dto.MenuDTO;
import com.bs.housing.po.MenuPO;
import com.bs.housing.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    View getAllMenu(
            HttpServletResponse response,
            HttpServletRequest request,
            // MenuDTO dto,
            ModelMap modelMap) {
        List<MenuPO> all = menuService.getJpa().findAll();
        List<MenuDTO> menuDTOS = DozerMapper.mapperList(all, MenuDTO.class);
        modelMap.addAttribute("menuList", menuDTOS);
        return WebUtils.VIEW;
    }

    @RequestMapping(value = "menuTree")
    View menuTree(
            HttpServletResponse response,
            HttpServletRequest request,
            ModelMap modelMap) {
        menuService.menuTree(modelMap);
        return WebUtils.VIEW;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    View save(
            boolean isResource,
            MenuDTO dto,
            HttpServletResponse response,
            HttpServletRequest request,
            ModelMap modelMap) {
        try {
            menuService.save(isResource, dto);
            modelMap.addAttribute(WebUtils.STATUS, true);
        } catch (ServiceException e) {
            modelMap.addAttribute(WebUtils.STATUS, false);
            e.printStackTrace();
        }
        return WebUtils.VIEW;
    }
}
