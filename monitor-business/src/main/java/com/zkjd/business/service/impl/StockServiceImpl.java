package com.zkjd.business.service.impl;

import java.util.List;

import com.zkjd.business.service.StockService;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zkjd.business.mapper.StockMapper;
import com.zkjd.business.domain.Stock;

/**
 * 存货信息Service业务层处理
 *
 * @author wangtao
 * @date 2021-11-04
 */
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;

    /**
     * 查询存货信息
     *
     * @param stockId 存货信息主键
     * @return 存货信息
     */
    @Override
    public Stock selectStockByStockId(Long stockId) {
        return stockMapper.selectStockByStockId(stockId);
    }

    /**
     * 查询存货信息列表
     *
     * @param stock 存货信息
     * @return 存货信息
     */
    @Override
    public List<Stock> selectStockList(Stock stock) {
        return stockMapper.selectStockList(stock);
    }

    /**
     * 新增存货信息
     *
     * @param stock 存货信息
     * @return 结果
     */
    @Override
    public int insertStock(Stock stock) {
        stock.setCreateTime(DateUtils.getNowDate());
        return stockMapper.insertStock(stock);
    }

    /**
     * 修改存货信息
     *
     * @param stock 存货信息
     * @return 结果
     */
    @Override
    public int updateStock(Stock stock) {
        stock.setUpdateTime(DateUtils.getNowDate());
        return stockMapper.updateStock(stock);
    }

    /**
     * 批量删除存货信息
     *
     * @param stockIds 需要删除的存货信息主键
     * @return 结果
     */
    @Override
    public int deleteStockByStockIds(Long[] stockIds) {
        return stockMapper.deleteStockByStockIds(stockIds);
    }

    /**
     * 删除存货信息信息
     *
     * @param stockId 存货信息主键
     * @return 结果
     */
    @Override
    public int deleteStockByStockId(Long stockId) {
        return stockMapper.deleteStockByStockId(stockId);
    }

    @Override
    public List<Stock> getStockList(Integer page, Integer pageSize) {
        return stockMapper.getStockList(page, pageSize);
    }
}
