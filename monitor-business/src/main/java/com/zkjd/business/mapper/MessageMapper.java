package com.zkjd.business.mapper;

import com.zkjd.business.domain.Message;
import com.zkjd.business.domain.RiseRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 消息Mapper接口
 *
 * @author zkjd
 * @date 2021-11-22
 */
public interface MessageMapper {
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
     * 删除消息
     *
     * @param id 消息主键
     * @return 结果
     */
    public int deleteMessageById(Long id);

    /**
     * 批量删除消息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMessageByIds(Long[] ids);

    /**
     * 分页获取消息记录
     * @param page
     * @param pageSize
     * @return
     */
    List<Message> getMessageList(@Param("page") Integer page, @Param("pageSize") Integer pageSize);
}
