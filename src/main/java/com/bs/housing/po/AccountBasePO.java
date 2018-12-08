package com.bs.housing.po;

import com.bs.housing.base.BasePO;
import com.bs.housing.constant.AccountStatusEnum;

import javax.persistence.*;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/12/7 23:08</p>
 */
@Entity
@Table(name = "t_core_base_account")
public class AccountBasePO extends BasePO {

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String description;//描述
    @Column
    @MapKeyEnumerated(EnumType.STRING)
    private AccountStatusEnum type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccountStatusEnum getType() {
        return type;
    }

    public void setType(AccountStatusEnum type) {
        this.type = type;
    }
}
