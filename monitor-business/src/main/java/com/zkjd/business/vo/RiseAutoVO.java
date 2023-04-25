package com.zkjd.business.vo;

import com.zkjd.business.domain.RiseAuto;

/**
 * @author: Xu Xiang  @createTime: 2021/11/17 14:10
 * Description: 后台管理系统 - 提升次数
 */
public class RiseAutoVO extends RiseAuto {
    private String projectName;
    private String monomer;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getMonomer() {
        return monomer;
    }

    public void setMonomer(String monomer) {
        this.monomer = monomer;
    }

    @Override
    public String toString() {
        return "RiseAutoVO{" +
                "projectName='" + projectName + '\'' +
                ", monomer='" + monomer + '\'' +
                '}';
    }
}
