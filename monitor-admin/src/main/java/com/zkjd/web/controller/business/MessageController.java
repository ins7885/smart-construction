package com.zkjd.web.controller.business;

import java.util.List;

import com.zkjd.business.domain.Message;
import com.zkjd.business.service.IMessageService;
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
import com.zkjd.common.utils.poi.ExcelUtil;
import com.zkjd.common.core.page.TableDataInfo;

/**
 * 消息Controller
 *
 * @author zkjd
 * @date 2021-11-22
 */
@RestController
@RequestMapping("/business/message")
public class MessageController extends BaseController {
    @Autowired
    private IMessageService messageService;

    /**
     * 查询消息列表
     *
     */
    @PreAuthorize("@ss.hasPermi('business:message:list')")
    @GetMapping("/list")
    public TableDataInfo list(Message message) {
        startPage();
        List<Message> list = messageService.selectMessageList(message);
        return getDataTable(list);
    }

    /**
     * 导出消息列表
     */
    @PreAuthorize("@ss.hasPermi('business:message:export')")
    @Log(title = "消息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Message message) {
        List<Message> list = messageService.selectMessageList(message);
        ExcelUtil<Message> util = new ExcelUtil<Message>(Message.class);
        return util.exportExcel(list, "消息数据");
    }

    /**
     * 获取消息详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:message:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(messageService.selectMessageById(id));
    }

    /**
     * 新增消息
     */
    @PreAuthorize("@ss.hasPermi('business:message:add')")
    @Log(title = "消息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Message message) {
        return toAjax(messageService.insertMessage(message));
    }

    /**
     * 修改消息
     */
    @PreAuthorize("@ss.hasPermi('business:message:edit')")
    @Log(title = "消息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Message message) {
        return toAjax(messageService.updateMessage(message));
    }

    /**
     * 删除消息
     */
    @PreAuthorize("@ss.hasPermi('business:message:remove')")
    @Log(title = "消息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(messageService.deleteMessageByIds(ids));
    }
}
