package com.zkjd.business.service;

import com.zkjd.business.domain.Monomer;

import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2021-11-17 10:50
 * @Description:
 */
public interface MonomerService {

    /**
     * 根据项目ID查询楼顶信息
     * @param projectId
     * @return
     */
    List<Monomer> getListByProjectId(Long projectId);
}
