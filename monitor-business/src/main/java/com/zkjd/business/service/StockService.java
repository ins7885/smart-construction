package com.zkjd.business.service;

import java.util.List;

import com.zkjd.business.domain.Stock;
import com.zkjd.business.domain.Warn;

/**
 * 存货信息Service接口
 *
 * @author wangtao
 * @date 2021-11-04
 */
public interface StockService {
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
     * 批量删除存货信息
     *
     * @param stockIds 需要删除的存货信息主键集合
     * @return 结果
     */
    public int deleteStockByStockIds(Long[] stockIds);

    /**
     * 删除存货信息信息
     *
     * @param stockId 存货信息主键
     * @return 结果
     */
    public int deleteStockByStockId(Long stockId);

    /**
     * 分页获取出货记录
     * @param page
     * @param pageSize
     * @return
     */
    List<Stock> getStockList( Integer page, Integer pageSize);
}
