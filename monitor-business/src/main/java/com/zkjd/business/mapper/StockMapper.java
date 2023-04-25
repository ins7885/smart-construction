package com.zkjd.business.mapper;

import java.util.List;
import com.zkjd.business.domain.Stock;
import org.apache.ibatis.annotations.Param;

/**
 * 存货信息Mapper接口
 * 
 * @author wangtao
 * @date 2021-11-04
 */
public interface StockMapper 
{
    /**
     * 查询存货信息
     * 
     * @param stockId 存货信息主键
     * @return 存货信息
     */
    public Stock selectStockByStockId(Long stockId);

    /**
     * 查询存货信息列表
     * 
     * @param stock 存货信息
     * @return 存货信息集合
     */
    public List<Stock> selectStockList(Stock stock);

    /**
     * 新增存货信息
     * 
     * @param stock 存货信息
     * @return 结果
     */
    public int insertStock(Stock stock);

    /**
     * 修改存货信息
     * 
     * @param stock 存货信息
     * @return 结果
     */
    public int updateStock(Stock stock);

    /**
     * 删除存货信息
     * 
     * @param stockId 存货信息主键
     * @return 结果
     */
    public int deleteStockByStockId(Long stockId);

    /**
     * 批量删除存货信息
     * 
     * @param stockIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStockByStockIds(Long[] stockIds);

    /**
     * 分页获取出货记录
     * @param page
     * @param pageSize
     * @return
     */
    List<Stock> getStockList(@Param("page") Integer page, @Param("pageSize") Integer pageSize);
}
