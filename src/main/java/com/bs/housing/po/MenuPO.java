package com.bs.housing.po;

import com.bs.housing.core.base.BasePO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Copyright 2018 bejson.com
 * <p>
 * Auto-generated: 2018-11-29 17:53:47
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Entity
@Table(name = "T_CORE_MENU")
public class MenuPO extends BasePO {

    @Column(nullable = false)
    private String accessPath = "#";//如果节点路径为空或者为"#"，不允许单击操作
    @Column
    private boolean checked;
    @Column
    private Integer delFlag;
    @Column
    private Integer parentID;//父id
    @Column
    private String resourceCode;//
    @Column
    private String resourceDesc;//资源描述

    private Integer resourceGrade;//目录级别，最小是二级
    @Column
    private Integer resourceID;//自身资源id
    @Column(nullable = false)
    private String resourceName;//资源名称
    @Column
    private Integer resourceOrder;
    @Column
    private String resourceType;//1:文件夹，2:资源

    public void setAccessPath(String accessPath) {
        this.accessPath = accessPath;
    }

    public String getAccessPath() {
        return accessPath;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public Integer getParentID() {
        return parentID;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceGrade(Integer resourceGrade) {
        this.resourceGrade = resourceGrade;
    }

    public Integer getResourceGrade() {
        return resourceGrade;
    }

    public void setResourceID(Integer resourceID) {
        this.resourceID = resourceID;
    }

    public Integer getResourceID() {
        return resourceID;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceOrder(Integer resourceOrder) {
        this.resourceOrder = resourceOrder;
    }

    public Integer getResourceOrder() {
        return resourceOrder;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceType() {
        return resourceType;
    }

}