package com.zkjd.business.service.impl;

import java.util.List;

import com.zkjd.business.domain.RiseAuto;
import com.zkjd.business.mapper.RiseAutoMapper;
import com.zkjd.business.service.IRiseAutoService;
import com.zkjd.business.vo.RiseAutoVO;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统自动获取的提升记录Service业务层处理
 *
 * @author zkjd
 * @date 2022-04-06
 */
@Service
public class RiseAutoServiceImpl implements IRiseAutoService {
    @Autowired
    private RiseAutoMapper riseAutoMapper;

    /**
     * 查询系统自动获取的提升记录
     *
     * @param id 系统自动获取的提升记录主键
     * @return 系统自动获取的提升记录
     */
    @Override
    public RiseAuto selectRiseAutoById(Long id) {
        return riseAutoMapper.selectRiseAutoById(id);
    }

    /**
     * 查询系统自动获取的提升记录
     * @param riseAuto
     * @return
     */
    @Override
    public List<RiseAutoVO> listByAuto(RiseAuto riseAuto) {
        return riseAutoMapper.listByAuto(riseAuto);
    }

    /**
     * 查询系统自动获取的提升记录列表
     *
     * @param riseAuto 系统自动获取的提升记录
     * @return 系统自动获取的提升记录
     */
    @Override
    public List<RiseAuto> selectRiseAutoList(RiseAuto riseAuto) {
        return riseAutoMapper.selectRiseAutoList(riseAuto);
    }

    /**
     * 新增系统自动获取的提升记录
     *
     * @param riseAuto 系统自动获取的提升记录
     * @return 结果
     */
    @Override
    public int insertRiseAuto(RiseAuto riseAuto) {
        riseAuto.setCreateTime(DateUtils.getNowDate());
        return riseAutoMapper.insertRiseAuto(riseAuto);
    }

    /**
     * 修改系统自动获取的提升记录
     *
     * @param riseAuto 系统自动获取的提升记录
     * @return 结果
     */
    @Override
    public int updateRiseAuto(RiseAuto riseAuto) {
        riseAuto.setUpdateTime(DateUtils.getNowDate());
        return riseAutoMapper.updateRiseAuto(riseAuto);
    }

    /**
     * 批量删除系统自动获取的提升记录
     *
     * @param ids 需要删除的系统自动获取的提升记录主键
     * @return 结果
     */
    @Override
    public int deleteRiseAutoByIds(Long[] ids) {
        return riseAutoMapper.deleteRiseAutoByIds(ids);
    }

    /**
     * 删除系统自动获取的提升记录信息
     *
     * @param id 系统自动获取的提升记录主键
     * @return 结果
     */
    @Override
    public int deleteRiseAutoById(Long id) {
        return riseAutoMapper.deleteRiseAutoById(id);
    }
}
