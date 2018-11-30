package com.bs.housing.service;

import com.bs.housing.base.BaseService;
import com.bs.housing.dao.MenuDAO;
import com.bs.housing.dto.MenuDTO;
import org.springframework.ui.ModelMap;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/29 18:25</p>
 */
public interface MenuService extends BaseService<MenuDAO, MenuDTO> {
    void menuTree(ModelMap modelMap);
}
