package com.zkjd.business.mapper;

import com.zkjd.business.domain.Monomer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2021-11-17 10:50
 * @Description:
 */
public interface MonomerMapper {

    /**
     * 批量新增楼栋信息
     *
     * @param list 角色部门列表
     * @return 结果
     */
    int batchMonomer(List<Monomer> list);

    /**
     * 根据项目ID查询楼顶信息
     * @param projectId
     * @return
     */
    List<Monomer> getListByProjectId(Long projectId);

    /**
     * 批量更新
     * @param list
     * @return
     */
    int updateBatch(List<Monomer> list);

    /**
     * 根据项目Id删除楼栋信息
     * @param projectId
     * @return
     */
    int deleteMonomer(Long projectId);

    /**
     * 根据多个项目Id删除楼栋信息
     * @param projectIds
     * @return
     */
    int deleteBatch(Long[] projectIds);

    /**
     * 根据Id删除楼栋信息
     * @param monomerIds
     * @return
     */
    int deleteBatchByIds(List<Long> monomerIds);
}
