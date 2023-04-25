package com.zkjd.business.service;

import com.zkjd.business.domain.Message;

import java.util.List;


/**
 * 消息Service接口
 *
 * @author zkjd
 * @date 2021-11-22
 */
public interface IMessageService {
    /**
     * 查询消息
     *
     * @param id 消息主键
     * @return 消息
     */
    public Message selectMessageById(Long id);

    /**
     * 查询消息列表
     *
     * @param message 消息
     * @return 消息集合
     */
    public List<Message> selectMessageList(Message message);

    /**
     * 新增消息
     *
     * @param message 消息
     * @return 结果
     */
    public int insertMessage(Message message);

    /**
     * 修改消息
     *
     * @param message 消息
     * @return 结果
     */
    public int updateMessage(Message message);

    /**
     * 批量删除消息
     *
     * @param ids 需要删除的消息主键集合
     * @return 结果
     */
    public int deleteMessageByIds(Long[] ids);

    /**
     * 删除消息信息
     *
     * @param id 消息主键
     * @return 结果
     */
    public int deleteMessageById(Long id);

    /**
     * 分页获取消息记录
     * @return
     */
    List<Message> getMessageList(Integer page,  Integer pageSize);
}
