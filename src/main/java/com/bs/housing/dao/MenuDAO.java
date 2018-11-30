package com.bs.housing.dao;

import com.bs.housing.base.BaseDAO;
import com.bs.housing.po.MenuPO;

import java.util.List;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/29 18:27</p>
 */

public interface MenuDAO extends BaseDAO<MenuPO> {

    List<MenuPO> findByParentID(Integer parentID);
}
