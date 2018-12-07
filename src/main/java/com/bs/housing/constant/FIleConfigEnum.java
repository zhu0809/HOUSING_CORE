package com.bs.housing.constant;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/12/7 9:52</p>
 */
public enum FIleConfigEnum {
    abstrac;

    FIleConfigEnum(long id, String name, String path, String description) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.description = description;
    }

    FIleConfigEnum() {
    }

    long id;
    String name;
    String path;//资源路径,配置本机路径，
    String description;
}
