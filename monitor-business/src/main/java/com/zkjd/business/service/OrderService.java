package com.zkjd.business.service;

import com.zkjd.business.domain.Order;

/**
 * @Author: wangtao
 * @Description: 指令业务层接口
 * @Date: create in 2022/4/19 0:00
 */
public interface OrderService {

    /**
     * 新增指令
     *
     * @param order 指令信息
     * @return 结果
     */
    int insertOrder(Order order);
}
