package com.zkjd.business.service.impl;

import java.util.List;

import com.zkjd.business.domain.Message;
import com.zkjd.business.mapper.MessageMapper;
import com.zkjd.business.service.IMessageService;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消息Service业务层处理
 *
 * @author zkjd
 * @date 2021-11-22
 */
@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 查询消息
     *
     * @param id 消息主键
     * @return 消息
     */
    @Override
    public Message selectMessageById(Long id) {
        return messageMapper.selectMessageById(id);
    }

    /**
     * 查询消息列表
     *
     * @param message 消息
     * @return 消息
     */
    @Override
    public List<Message> selectMessageList(Message message) {
        return messageMapper.selectMessageList(message);
    }

    /**
     * 新增消息
     *
     * @param message 消息
     * @return 结果
     */
    @Override
    public int insertMessage(Message message) {
        message.setCreateTime(DateUtils.getNowDate());
        return messageMapper.insertMessage(message);
    }

    /**
     * 修改消息
     *
     * @param message 消息
     * @return 结果
     */
    @Override
    public int updateMessage(Message message) {
        message.setUpdateTime(DateUtils.getNowDate());
        return messageMapper.updateMessage(message);
    }

    /**
     * 批量删除消息
     *
     * @param ids 需要删除的消息主键
     * @return 结果
     */
    @Override
    public int deleteMessageByIds(Long[] ids) {
        return messageMapper.deleteMessageByIds(ids);
    }

    /**
     * 删除消息信息
     *
     * @param id 消息主键
     * @return 结果
     */
    @Override
    public int deleteMessageById(Long id) {
        return messageMapper.deleteMessageById(id);
    }

    @Override
    public List<Message> getMessageList(Integer page, Integer pageSize) {
        return messageMapper.getMessageList(page, pageSize);
    }
}
