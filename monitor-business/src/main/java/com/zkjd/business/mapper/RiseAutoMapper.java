package com.zkjd.business.mapper;

import com.zkjd.business.domain.RiseAuto;
import com.zkjd.business.vo.RiseAutoVO;

import java.util.List;


/**
 * 系统自动获取的提升记录Mapper接口
 *
 * @author zkjd
 * @date 2022-04-06
 */
public interface RiseAutoMapper {
    /**
     * 查询系统自动获取的提升记录
     *
     * @param id 系统自动获取的提升记录主键
     * @return 系统自动获取的提升记录
     */
    public RiseAuto selectRiseAutoById(Long id);

    /**
     * 查询系统自动获取的提升记录列表
     *
     * @param riseAuto 系统自动获取的提升记录
     * @return 系统自动获取的提升记录集合
     */
    public List<RiseAuto> selectRiseAutoList(RiseAuto riseAuto);

    /**
     * 查询系统自动获取的提升记录列表
     * @param riseAuto
     * @return
     */
    public List<RiseAutoVO> listByAuto(RiseAuto riseAuto);


    /**
     * 新增系统自动获取的提升记录
     *
     * @param riseAuto 系统自动获取的提升记录
     * @return 结果
     */
    public int insertRiseAuto(RiseAuto riseAuto);

    /**
     * 修改系统自动获取的提升记录
     *
     * @param riseAuto 系统自动获取的提升记录
     * @return 结果
     */
    public int updateRiseAuto(RiseAuto riseAuto);

    /**
     * 删除系统自动获取的提升记录
     *
     * @param id 系统自动获取的提升记录主键
     * @return 结果
     */
    public int deleteRiseAutoById(Long id);

    /**
     * 批量删除系统自动获取的提升记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRiseAutoByIds(Long[] ids);
}
