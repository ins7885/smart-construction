package com.zkjd.business.service.impl;

import java.util.List;

import com.zkjd.business.domain.AppVersion;
import com.zkjd.business.mapper.AppVersionMapper;
import com.zkjd.business.service.IAppVersionService;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * app版本配置Service业务层处理
 *
 * @author zkjd
 * @date 2022-02-21
 */
@Service
public class AppVersionServiceImpl implements IAppVersionService {
    @Autowired
    private AppVersionMapper appVersionMapper;

    /**
     * 查询app版本配置
     *
     * @param id app版本配置主键
     * @return app版本配置
     */
    @Override
    public AppVersion selectAppVersionById(Long id) {
        return appVersionMapper.selectAppVersionById(id);
    }

    /**
     * 查询app版本配置列表
     *
     * @param appVersion app版本配置
     * @return app版本配置
     */
    @Override
    public List<AppVersion> selectAppVersionList(AppVersion appVersion) {
        return appVersionMapper.selectAppVersionList(appVersion);
    }

    /**
     * 新增app版本配置
     *
     * @param appVersion app版本配置
     * @return 结果
     */
    @Override
    public int insertAppVersion(AppVersion appVersion) {
        appVersion.setCreateTime(DateUtils.getNowDate());
        int idResult = appVersionMapper.insertAppVersion(appVersion);
        if (appVersion.getIsCurrent() == 1) {
            // 将其他设为当前版本的数据的isCurrent设置为2
            appVersionMapper.updateAppOldVersion(appVersion);
        }
        return idResult;
    }

    /**
     * 修改app版本配置
     *
     * @param appVersion app版本配置
     * @return 结果
     */
    @Override
    public int updateAppVersion(AppVersion appVersion) {
        appVersion.setUpdateTime(DateUtils.getNowDate());
        if (appVersion.getIsCurrent() == 1) {
            // 将其他设为当前版本的数据的isCurrent设置为2
            appVersionMapper.updateAppOldVersion(appVersion);
        }
        return appVersionMapper.updateAppVersion(appVersion);
    }

    /**
     * 批量删除app版本配置
     *
     * @param ids 需要删除的app版本配置主键
     * @return 结果
     */
    @Override
    public int deleteAppVersionByIds(Long[] ids) {
        return appVersionMapper.deleteAppVersionByIds(ids);
    }

    /**
     * 删除app版本配置信息
     *
     * @param id app版本配置主键
     * @return 结果
     */
    @Override
    public int deleteAppVersionById(Long id) {
        return appVersionMapper.deleteAppVersionById(id);
    }
}
