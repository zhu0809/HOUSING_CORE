package com.bs.housing.core;


import com.bs.housing.core.base.BasePO;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/22 16:29</p>
 */
public class EntityListener {

    @PreUpdate
    public void update(BasePO basePO) {
        basePO.setUpdateDate(new Date());
    }

    @PrePersist
    public void persist(BasePO basePO) {
        basePO.setUpdateDate(new Date());
        basePO.setCreateDate(new Date());
        basePO.setValid(true);
    }
}
