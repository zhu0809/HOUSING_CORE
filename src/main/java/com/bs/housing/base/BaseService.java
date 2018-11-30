package com.bs.housing.base;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/22 16:46</p>
 */
public interface BaseService<Dao extends BaseDAO, Dto extends BaseDTO> {
    /**
     * <p> @方法描述：	jpa获取         </p>
     * <p> @创建人：	ZhuRongguo	        </p>
     * <p> @创建时间：2018/11/22 16:51   	</p>
     * <p> @修改人：	ZhuRongguo	        </p>
     * <p> @修改时间：2018/11/22 16:51	</p>
     * <p> @修改说明：	                </p>
     *
     * @return Dao
     */
    Dao getJpa();
}
