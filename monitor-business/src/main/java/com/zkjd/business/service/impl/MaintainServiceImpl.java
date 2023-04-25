package com.zkjd.business.service.impl;

import java.util.List;

import com.zkjd.business.domain.Maintain;
import com.zkjd.business.mapper.MaintainMapper;
import com.zkjd.business.service.IMaintainService;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 附着式升降脚手架提升及维护保养记录(app中的维护保养)Service业务层处理
 *
 * @author zkjd
 * @date 2021-12-02
 */
@Service
public class MaintainServiceImpl implements IMaintainService {
    @Autowired
    private MaintainMapper maintainMapper;

    /**
     * 查询附着式升降脚手架提升及维护保养记录(app中的维护保养)
     *
     * @param id 附着式升降脚手架提升及维护保养记录(app中的维护保养)主键
     * @return 附着式升降脚手架提升及维护保养记录(app中的维护保养)
     */
    @Override
    public Maintain selectMaintainById(Long id) {
        return maintainMapper.selectMaintainById(id);
    }

    /**
     * 查询附着式升降脚手架提升及维护保养记录(app中的维护保养)列表
     *
     * @param maintain 附着式升降脚手架提升及维护保养记录(app中的维护保养)
     * @return 附着式升降脚手架提升及维护保养记录(app中的维护保养)
     */
    @Override
    public List<Maintain> selectMaintainList(Maintain maintain) {
        return maintainMapper.selectMaintainList(maintain);
    }

    /**
     * 新增附着式升降脚手架提升及维护保养记录(app中的维护保养)
     *
     * @param maintain 附着式升降脚手架提升及维护保养记录(app中的维护保养)
     * @return 结果
     */
    @Override
    public int insertMaintain(Maintain maintain) {
        maintain.setCreateTime(DateUtils.getNowDate());
        return maintainMapper.insertMaintain(maintain);
    }

    /**
     * 修改附着式升降脚手架提升及维护保养记录(app中的维护保养)
     *
     * @param maintain 附着式升降脚手架提升及维护保养记录(app中的维护保养)
     * @return 结果
     */
    @Override
    public int updateMaintain(Maintain maintain) {
        maintain.setUpdateTime(DateUtils.getNowDate());
        return maintainMapper.updateMaintain(maintain);
    }

    /**
     * 批量删除附着式升降脚手架提升及维护保养记录(app中的维护保养)
     *
     * @param ids 需要删除的附着式升降脚手架提升及维护保养记录(app中的维护保养)主键
     * @return 结果
     */
    @Override
    public int deleteMaintainByIds(Long[] ids) {
        return maintainMapper.deleteMaintainByIds(ids);
    }

    /**
     * 删除附着式升降脚手架提升及维护保养记录(app中的维护保养)信息
     *
     * @param id 附着式升降脚手架提升及维护保养记录(app中的维护保养)主键
     * @return 结果
     */
    @Override
    public int deleteMaintainById(Long id) {
        return maintainMapper.deleteMaintainById(id);
    }

    @Override
    public List<Maintain> getMaintainPage(Integer page, Integer pageSize,Long climbFrameId) {
        return maintainMapper.getMaintainPage(page, pageSize,climbFrameId);
    }
}
