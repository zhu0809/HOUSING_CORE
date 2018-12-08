package com.bs.housing.constant;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/12/8 14:30</p>
 */
public enum AccountStatusEnum {
    NORMAL(1, "正常"), ABNORMAL(0, "冻结账户"), DOUBTFUL(-1, "存疑账户");

    AccountStatusEnum(long id, String description) {
        this.id = id;
        this.description = description;
    }

    long id;
    String description;


    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public static AccountStatusEnum getAccountStatusEnum(Long id) {
        if (id == 1) {
            return AccountStatusEnum.NORMAL;
        } else if (id == 0) {
            return AccountStatusEnum.ABNORMAL;
        } else if (id == -1) {
            return AccountStatusEnum.DOUBTFUL;
        }
        return AccountStatusEnum.DOUBTFUL;
    }
}
