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
    /**
     * <p> @方法描述：	                </p>
     * <p> @创建人：	ZhuRongguo	        </p>
     * <p> @创建时间：2018/12/3 9:12   	</p>
     * <p> @修改人：	ZhuRongguo	        </p>
     * <p> @修改时间：2018/12/3 9:12	</p>
     * <p> @修改说明：	                </p>
     *
     * @param parentID
     * @return java.util.List<com.bs.housing.po.MenuPO>
     */
    List<MenuPO> findByParentID(Integer parentID);

    /**
     * <p> @方法描述：	                </p>
     * <p> @创建人：	ZhuRongguo	        </p>
     * <p> @创建时间：2018/12/3 9:13   	</p>
     * <p> @修改人：	ZhuRongguo	        </p>
     * <p> @修改时间：2018/12/3 9:13	</p>
     * <p> @修改说明：	                </p>
     *
     * @return java.lang.Integer
     */
    Integer findByMaxResourceID();
}
