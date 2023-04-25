package com.zkjd.web.controller.app;


import com.zkjd.business.domain.Project;
import com.zkjd.business.service.ProjectService;
import com.zkjd.business.vo.AppUserVO;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.common.core.domain.entity.SysRole;
import com.zkjd.common.core.domain.model.LoginBody;
import com.zkjd.common.core.domain.model.LoginUser;
import com.zkjd.framework.web.service.AppLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2021-10-23 18:18
 * @Description: APP登录
 */
@RestController
public class AppLoginController {

    @Autowired
    private AppLoginService appLoginService;

    @Autowired
    private ProjectService projectService;

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/appLogin")
    public AjaxResult appLogin(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        // String token = appLoginService.login(loginBody.getUsername(), loginBody.getPassword());
        LoginUser loginUser = appLoginService.login(loginBody.getUsername(), loginBody.getPassword());
        // ajax.put(Constants.TOKEN, loginUser.getToken());
        AppUserVO appUserVO = new AppUserVO();
        appUserVO.setUserId(loginUser.getUserId());
        appUserVO.setNickName(loginUser.getUser().getNickName());
        appUserVO.setPhoneNumber(loginUser.getUser().getPhonenumber());
        appUserVO.setUsername(loginUser.getUsername());
        Long projectId = loginUser.getUser().getProjectId();
        if (projectId != null) {
            appUserVO.setProjectId(projectId);
            Project project = projectService.selectProjectById(projectId);
            if (project != null) {
                appUserVO.setProjectName(project.getProjectName());
            }
        }
        List<SysRole> roles = loginUser.getUser().getRoles();
        if (roles != null && roles.size() > 0) {
            SysRole sysRole = roles.get(0);
            // 默认选择第一个角色-
            appUserVO.setRoleKey(sysRole.getRoleKey());
            appUserVO.setRoleName(sysRole.getRoleName());
        }
        appUserVO.setToken(loginUser.getToken());
        ajax.put("loginUser", appUserVO);
        return ajax;
    }
}
