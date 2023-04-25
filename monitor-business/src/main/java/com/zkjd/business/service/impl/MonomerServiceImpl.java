package com.zkjd.business.service.impl;

import com.zkjd.business.domain.Monomer;
import com.zkjd.business.mapper.MonomerMapper;
import com.zkjd.business.service.MonomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2021-11-17 10:50
 * @Description:
 */
@Service
public class MonomerServiceImpl implements MonomerService {

    @Autowired
    private MonomerMapper monomerMapper;

    @Override
    public List<Monomer> getListByProjectId(Long projectId) {
        return monomerMapper.getListByProjectId(projectId);
    }
}
