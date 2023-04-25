package com.zkjd.business.service;

import com.zkjd.business.domain.AppVersion;

import java.util.List;


/**
 * app版本配置Service接口
 *
 * @author zkjd
 * @date 2022-02-21
 */
public interface IAppVersionService {
    /**
     * 查询app版本配置
     *
     * @param id app版本配置主键
     * @return app版本配置
     */
    public AppVersion selectAppVersionById(Long id);

    /**
     * 查询app版本配置列表
     *
     * @param appVersion app版本配置
     * @return app版本配置集合
     */
    public List<AppVersion> selectAppVersionList(AppVersion appVersion);

    /**
     * 新增app版本配置
     *
     * @param appVersion app版本配置
     * @return 结果
     */
    public int insertAppVersion(AppVersion appVersion);

    /**
     * 修改app版本配置
     *
     * @param appVersion app版本配置
     * @return 结果
     */
    public int updateAppVersion(AppVersion appVersion);

    /**
     * 批量删除app版本配置
     *
     * @param ids 需要删除的app版本配置主键集合
     * @return 结果
     */
    public int deleteAppVersionByIds(Long[] ids);

    /**
     * 删除app版本配置信息
     *
     * @param id app版本配置主键
     * @return 结果
     */
    public int deleteAppVersionById(Long id);
}
