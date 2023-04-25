package com.zkjd.business.service;

import com.zkjd.business.domain.Maintain;

import java.util.List;


/**
 * 附着式升降脚手架提升及维护保养记录(app中的维护保养)Service接口
 *
 * @author zkjd
 * @date 2021-12-02
 */
public interface IMaintainService {
    /**
     * 查询附着式升降脚手架提升及维护保养记录(app中的维护保养)
     *
     * @param id 附着式升降脚手架提升及维护保养记录(app中的维护保养)主键
     * @return 附着式升降脚手架提升及维护保养记录(app中的维护保养)
     */
    public Maintain selectMaintainById(Long id);

    /**
     * 查询附着式升降脚手架提升及维护保养记录(app中的维护保养)列表
     *
     * @param maintain 附着式升降脚手架提升及维护保养记录(app中的维护保养)
     * @return 附着式升降脚手架提升及维护保养记录(app中的维护保养)集合
     */
    public List<Maintain> selectMaintainList(Maintain maintain);

    /**
     * 新增附着式升降脚手架提升及维护保养记录(app中的维护保养)
     *
     * @param maintain 附着式升降脚手架提升及维护保养记录(app中的维护保养)
     * @return 结果
     */
    public int insertMaintain(Maintain maintain);

    /**
     * 修改附着式升降脚手架提升及维护保养记录(app中的维护保养)
     *
     * @param maintain 附着式升降脚手架提升及维护保养记录(app中的维护保养)
     * @return 结果
     */
    public int updateMaintain(Maintain maintain);

    /**
     * 批量删除附着式升降脚手架提升及维护保养记录(app中的维护保养)
     *
     * @param ids 需要删除的附着式升降脚手架提升及维护保养记录(app中的维护保养)主键集合
     * @return 结果
     */
    public int deleteMaintainByIds(Long[] ids);

    /**
     * 删除附着式升降脚手架提升及维护保养记录(app中的维护保养)信息
     *
     * @param id 附着式升降脚手架提升及维护保养记录(app中的维护保养)主键
     * @return 结果
     */
    public int deleteMaintainById(Long id);

    /**
     * 技术人员 - 附着式升降脚手架提升及维护保养记录分页查询
     * @param page
     * @param pageSize
     * @return
     */
    List<Maintain> getMaintainPage( Integer page, Integer pageSize,Long climbFrameId);
}
