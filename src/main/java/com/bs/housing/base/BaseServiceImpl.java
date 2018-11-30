package com.bs.housing.base;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/22 16:46</p>
 */
public abstract class BaseServiceImpl<Dao extends BaseDAO, DTO extends BaseDTO> implements BaseService<Dao, DTO> {

    @Autowired
    protected Dao dao;

    @Override
    public Dao getJpa() {
        return dao;
    }
}
