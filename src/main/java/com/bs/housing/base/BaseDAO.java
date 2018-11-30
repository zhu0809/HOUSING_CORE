package com.bs.housing.base;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/22 16:42</p>
 */
public interface BaseDAO<PO extends BasePO> extends JpaRepository<PO, Long> {
}
