package com.bs.housing.dto;

import com.bs.housing.base.BaseDTO;

import java.util.Set;


public class MenuDTO extends BaseDTO {

    private String accessPath = "#";//如果节点路径为空或者为"#"，不允许单击操作
    private boolean checked;
    private Integer delFlag;
    private Integer parentID;//父id
    private String resourceCode;//
    private String resourceDesc;//资源描述
    private Integer resourceGrade;//目录级别，最小是二级
    private Integer resourceID;//自身资源id
    private String resourceName;//资源名称
    private Integer resourceOrder;
    private String resourceType;
    private Set<MenuDTO> children;


    public Set<MenuDTO> getChildren() {
        return children;
    }

    public void setChildren(Set<MenuDTO> children) {
        this.children = children;
    }

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