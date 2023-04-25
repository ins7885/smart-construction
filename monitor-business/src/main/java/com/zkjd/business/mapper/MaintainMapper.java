package com.zkjd.business.mapper;

import com.zkjd.business.domain.AcceptRecord;
import com.zkjd.business.domain.Maintain;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 附着式升降脚手架提升及维护保养记录(app中的维护保养)Mapper接口
 *
 * @author zkjd
 * @date 2021-12-02
 */
public interface MaintainMapper {
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
     * 删除附着式升降脚手架提升及维护保养记录(app中的维护保养)
     *
     * @param id 附着式升降脚手架提升及维护保养记录(app中的维护保养)主键
     * @return 结果
     */
    public int deleteMaintainById(Long id);

    /**
     * 批量删除附着式升降脚手架提升及维护保养记录(app中的维护保养)
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMaintainByIds(Long[] ids);

    /**
     * 技术人员 - 附着式升降脚手架提升及维护保养记录分页查询
     * @param page
     * @param pageSize
     * @return
     */
    List<Maintain> getMaintainPage(@Param("page") Integer page, @Param("pageSize") Integer pageSize,@Param("climbFrameId") Long climbFrameId);
}
