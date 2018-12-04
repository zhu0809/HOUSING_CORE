package com.bs.housing.dto;

import java.io.Serializable;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/29 23:55</p>
 */
public class JsTreeDto implements Serializable {
    private Integer pid;
    private Integer id;
    private String text;
    private String icon = "icon02";
    private Boolean resource;//是否是资源，否则是文件夹
    private Integer resourceGrade;//目录级别

    public Integer getResourceGrade() {
        return resourceGrade;
    }

    public void setResourceGrade(Integer resourceGrade) {
        this.resourceGrade = resourceGrade;
    }

    public Boolean getResource() {
        return this.resource;
    }

    public void setResource(Boolean resource) {
        this.resource = resource;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
