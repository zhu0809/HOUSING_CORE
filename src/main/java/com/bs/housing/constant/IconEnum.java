package com.bs.housing.constant;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/12/7 9:52</p>
 */
public enum IconEnum {

    FILE(1, "文件", "/static/images/icon/file.png"), LIB(2, "文件夹", "/static/images/icon/lib.png");

    IconEnum(long id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }


    long id;
    String name;
    String path;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
