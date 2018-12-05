package com.bs.housing.po;

import com.bs.housing.base.BasePO;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p> @类描述：	    所有的角色类型</p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/12/5 14:10</p>
 */
@Entity
@Table(name = "t_role_type")
public class RoleTypePO extends BasePO {

    private String description;//描述

    private String type;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
