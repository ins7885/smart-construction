package com.zkjd.business.mapper;

import com.zkjd.business.domain.AppVersion;

import java.util.List;


/**
 * app版本配置Mapper接口
 *
 * @author zkjd
 * @date 2022-02-21
 */
public interface AppVersionMapper {
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
     * 将非当前数据的app版本设置为2(代表非当前版本)
     * @param appVersion
     * @return
     */
    int updateAppOldVersion(AppVersion appVersion);

    /**
     * 删除app版本配置
     *
     * @param id app版本配置主键
     * @return 结果
     */
    public int deleteAppVersionById(Long id);

    /**
     * 批量删除app版本配置
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppVersionByIds(Long[] ids);
}
