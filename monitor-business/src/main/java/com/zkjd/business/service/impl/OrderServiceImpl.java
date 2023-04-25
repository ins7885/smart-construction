package com.zkjd.business.service.impl;

import com.zkjd.business.domain.Order;
import com.zkjd.business.mapper.OrderMapper;
import com.zkjd.business.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wangtao
 * @Description: 指令业务层接口实现类
 * @Date: create in 2022/4/19 0:03
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }
}
