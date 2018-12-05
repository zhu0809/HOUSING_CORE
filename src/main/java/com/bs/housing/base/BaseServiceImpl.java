package com.bs.housing.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/22 16:46</p>
 */
public abstract class BaseServiceImpl<PO
        extends BasePO, Dao extends BaseDAO<PO>, DTO extends BaseDTO>
        implements BaseService<PO, Dao, DTO> {

    @Autowired
    protected Dao dao;

    @Override
    public Dao getJpa() {
        return dao;
    }

    @Override
    public Page<PO> findPage(Integer page, Integer pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "parentID"); //创建时间降序排序
        Pageable pageable = new PageRequest(page - 1, pageSize, sort);
        Page<PO> all = dao.findAll(pageable);
        return all;
    }
}
