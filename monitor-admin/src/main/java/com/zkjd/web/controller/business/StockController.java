package com.zkjd.web.controller.business;

import java.util.List;

import com.zkjd.business.service.StockService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zkjd.common.annotation.Log;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.common.enums.BusinessType;
import com.zkjd.business.domain.Stock;
import com.zkjd.common.utils.poi.ExcelUtil;
import com.zkjd.common.core.page.TableDataInfo;

/**
 * 存货信息Controller
 * 
 * @author wangtao
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/business/stock")
public class StockController extends BaseController
{
    @Autowired
    private StockService stockService;

    /**
     * 查询存货信息列表
     */
    @PreAuthorize("@ss.hasPermi('business:stock:list')")
    @GetMapping("/list")
    public TableDataInfo list(Stock stock)
    {
        startPage();
        List<Stock> list = stockService.selectStockList(stock);
        return getDataTable(list);
    }

    /**
     * 导出存货信息列表
     */
    @PreAuthorize("@ss.hasPermi('business:stock:export')")
    @Log(title = "存货信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Stock stock)
    {
        List<Stock> list = stockService.selectStockList(stock);
        ExcelUtil<Stock> util = new ExcelUtil<Stock>(Stock.class);
        return util.exportExcel(list, "存货信息数据");
    }

    /**
     * 获取存货信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:stock:query')")
    @GetMapping(value = "/{stockId}")
    public AjaxResult getInfo(@PathVariable("stockId") Long stockId)
    {
        return AjaxResult.success(stockService.selectStockByStockId(stockId));
    }

    /**
     * 新增存货信息
     */
    @PreAuthorize("@ss.hasPermi('business:stock:add')")
    @Log(title = "存货信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Stock stock)
    {
        return toAjax(stockService.insertStock(stock));
    }

    /**
     * 修改存货信息
     */
    @PreAuthorize("@ss.hasPermi('business:stock:edit')")
    @Log(title = "存货信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Stock stock)
    {
        return toAjax(stockService.updateStock(stock));
    }

    /**
     * 删除存货信息
     */
    @PreAuthorize("@ss.hasPermi('business:stock:remove')")
    @Log(title = "存货信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stockIds}")
    public AjaxResult remove(@PathVariable Long[] stockIds)
    {
        return toAjax(stockService.deleteStockByStockIds(stockIds));
    }
}
