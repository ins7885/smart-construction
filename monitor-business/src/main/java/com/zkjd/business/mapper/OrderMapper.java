package com.zkjd.business.mapper;

import com.zkjd.business.domain.ClimbFrame;
import com.zkjd.business.domain.Order;

/**
 * @Author: wangtao
 * @Description: 指令数据库接口
 * @Date: create in 2022/4/19 0:01
 */
public interface OrderMapper {

    /**
     * 新增指令
     *
     * @param order 指令信息
     * @return 结果
     */
    int insertOrder(Order order);
}
