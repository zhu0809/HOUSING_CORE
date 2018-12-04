package com.bs.housing.service;

import com.bs.housing.base.BaseService;
import com.bs.housing.core.exception.ServiceException;
import com.bs.housing.dao.MenuDAO;
import com.bs.housing.dto.MenuDTO;
import org.springframework.ui.ModelMap;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/29 18:25</p>
 */
public interface MenuService extends BaseService<MenuDAO, MenuDTO> {
    /**
     * <p> @方法描述：菜单树             </p>
     * <p> @创建人：	ZhuRongguo	        </p>
     * <p> @创建时间：2018/11/30 19:53   	</p>
     * <p> @修改人：	ZhuRongguo	        </p>
     * <p> @修改时间：2018/11/30 19:53	</p>
     * <p> @修改说明：	                </p>
     *
     * @param modelMap
     * @return void
     */
    void menuTree(ModelMap modelMap);

    /**
     * <p> @方法描述：	                </p>
     * <p> @创建人：	ZhuRongguo	        </p>
     * <p> @创建时间：2018/11/30 23:17   	</p>
     * <p> @修改人：	ZhuRongguo	        </p>
     * <p> @修改时间：2018/11/30 23:17	</p>
     * <p> @修改说明：	                </p>
     *
     *
     * @param isResource 是否是资源
     * @param dto 菜单实体
     * @return void
     */
    void save(boolean isResource, MenuDTO dto) throws ServiceException;
}
