package com.zkjd.business.vo;

import com.zkjd.business.domain.Warn;

/**
 * @author: Xu Xiang  @createTime: 2021/11/10 10:39
 * Description: 告警信息封装类
 */
public class WarnMessageVO extends Warn {

    /** 楼栋 */
    private String monomer;

    /** 项目名称 */
    private String projectName;

    public WarnMessageVO(String monomer, String projectName) {
        this.monomer = monomer;
        this.projectName = projectName;
    }

    public WarnMessageVO() {
    }

    @Override
    public String toString() {
        return "WarnMessageVO{" +
                "monomer='" + monomer + '\'' +
                ", projectName='" + projectName + '\'' +
                '}';
    }

    public String getMonomer() {
        return monomer;
    }

    public void setMonomer(String monomer) {
        this.monomer = monomer;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
