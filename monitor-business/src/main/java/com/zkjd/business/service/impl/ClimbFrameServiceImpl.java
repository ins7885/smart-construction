package com.zkjd.business.service.impl;

import com.zkjd.business.domain.ClimbFrame;
import com.zkjd.business.domain.Order;
import com.zkjd.business.mapper.ClimbFrameMapper;
import com.zkjd.business.mapper.OrderMapper;
import com.zkjd.business.service.ClimbFrameService;
import com.zkjd.business.vo.ClimbFrameVO;
import com.zkjd.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2021-11-01 19:27
 * @Description: 爬架业务层接口实现类
 */
@Service
public class ClimbFrameServiceImpl implements ClimbFrameService {

    @Autowired
    private ClimbFrameMapper climbFrameMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ClimbFrame selectClimbFrameById(Long climbFrameId) {
        return climbFrameMapper.selectClimbFrameById(climbFrameId);
    }

    @Override
    public List<ClimbFrame> selectClimbFrameList(ClimbFrame climbFrame) {
        return climbFrameMapper.selectClimbFrameList(climbFrame);
    }

    @Override
    public int insertClimbFrame(ClimbFrame climbFrame) {
        return climbFrameMapper.insertClimbFrame(climbFrame);
    }

    @Override
    public int updateClimbFrame(ClimbFrame climbFrame) {
        return climbFrameMapper.updateClimbFrame(climbFrame);
    }

    @Override
    public int deleteClimbFrameById(Long climbFrameId) {
        return climbFrameMapper.deleteClimbFrameById(climbFrameId);
    }

    @Override
    public int deleteClimbFrameByIds(Long[] climbFrameIds) {
        return climbFrameMapper.deleteClimbFrameByIds(climbFrameIds);
    }

    @Override
    public List<ClimbFrameVO> selectCurrentYear() {
        return climbFrameMapper.selectCurrentYear();
    }

    @Override
    public List<ClimbFrame> getListByProjectId(Long projectId) {
        return climbFrameMapper.getListByProjectId(projectId);
    }

    @Override
    public Integer getClimbFrameCount() {
        return climbFrameMapper.getClimbFrameCount();
    }

    @Override
    @Transactional
    public int lockClimbFrame(ClimbFrame climbFrame) {
        try {
            Order order = new Order();
            order.setCreateTime(new Date());
            order.setOperate(climbFrame.getLockState());
            order.setCreateBy(climbFrame.getCreateBy());
            order.setClimbFrameId(climbFrame.getClimbFrameId());
            orderMapper.insertOrder(order);
            climbFrameMapper.updateClimbFrame(climbFrame);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer checkDeviceSerialUnique(String deviceSerial) {
        return climbFrameMapper.checkDeviceSerialUnique(deviceSerial);
    }
}
