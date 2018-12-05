package com.bs.housing.base;

import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/12/5 14:58</p>
 */
public class BasePage implements Serializable {

    private int pageSize = 10;
    private int thisPage = 0;
    private static Sort sort = new Sort(Sort.Direction.DESC, "createDate");

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }
}
