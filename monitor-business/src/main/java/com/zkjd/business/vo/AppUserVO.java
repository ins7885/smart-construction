package com.zkjd.business.vo;

import java.io.Serializable;

/**
 * @author: Xu Xiang  @createTime: 2021/11/1 15:17
 * Description: app端用户需要的信息,包含基础信息及token信息
 */
public class AppUserVO implements Serializable {
    /** 用户ID */
    private Long userId;

    /** 用户昵称 */
    private String nickName;

    /** 手机号 */
    private String phoneNumber;

    /** 令牌 */
    private String token;

    /** 角色 */
    private String roleKey;

    /** 用户名 */
    private String username;

    /** 项目ID */
    private Long projectId;

    /** 角色名称 */
    private String roleName;

    /** 项目名称 */
    private String projectName;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public AppUserVO() {
    }

    public AppUserVO(Long userId, String nickName, String phoneNumber, String token, String roleKey, String username, Long projectId) {
        this.userId = userId;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.token = token;
        this.roleKey = roleKey;
        this.username = username;
        this.projectId = projectId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "AppUserVO{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", token='" + token + '\'' +
                ", roleKey='" + roleKey + '\'' +
                ", username='" + username + '\'' +
                ", projectId=" + projectId +
                ", roleName=" + roleName +
                '}';
    }
}
