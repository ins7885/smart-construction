package com.zkjd.business.service.impl;

import com.alibaba.fastjson.JSON;
import com.zkjd.business.domain.Monomer;
import com.zkjd.business.domain.Project;
import com.zkjd.business.mapper.ClimbFrameMapper;
import com.zkjd.business.mapper.MonomerMapper;
import com.zkjd.business.mapper.ProjectMapper;
import com.zkjd.business.service.ClimbFrameService;
import com.zkjd.business.service.ProjectService;
import com.zkjd.business.vo.ProjectVO;
import com.zkjd.common.exception.ServiceException;
import com.zkjd.common.utils.MapUtil;
import com.zkjd.common.utils.StringUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: wangtao
 * @CreateTime: 2021-11-01 19:27
 * @Description: 项目业务层接口实现类
 */
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private MonomerMapper monomerMapper;

    @Autowired
    private ClimbFrameMapper climbFrameMapper;

    @Override
    public Project selectProjectById(Long projectId) {
        Project project = projectMapper.selectProjectById(projectId);
        List<Monomer> monomers = monomerMapper.getListByProjectId(projectId);
        project.setMonomers(monomers);
        return project;
    }

    @Override
    public List<Project> selectProjectList(Project project) {
        return projectMapper.selectProjectList(project);
    }

    @Override
    @Transactional
    public int insertProject(Project project) {

        //获取经纬度城市名称
        if(project.getLon() != null && project.getLat() != null){
            String province = MapUtil.getProvince(project.getLon(), project.getLat());
            project.setProvince(province);
        }
        int flag = projectMapper.insertProject(project);

        List<Monomer> monomers = project.getMonomers();
        if(flag == 1 && StringUtils.isNotEmpty(monomers)){
            monomers.forEach(o->{
                o.setCreateTime(new Date());
                o.setCreateBy(project.getCreateBy());
                o.setProjectId(project.getProjectId());
            });
            monomerMapper.batchMonomer(monomers);
        }
        return flag;
    }

    @Override
    @Transactional
    public int updateProject(Project project) {
        List<Monomer> monomers = project.getMonomers();
        List<Monomer> list = monomerMapper.getListByProjectId(project.getProjectId());
        if(StringUtils.isEmpty(monomers)&&StringUtils.isNotEmpty(list)){
            monomerMapper.deleteMonomer(project.getProjectId());
        }
        List<Long> ids = new ArrayList<>();
        if(StringUtils.isNotEmpty(monomers)){
            monomers.forEach(o->{
                o.setCreateTime(new Date());
                o.setCreateBy(project.getCreateBy());
                o.setProjectId(project.getProjectId());
            });
            if(StringUtils.isEmpty(list)){
                monomerMapper.batchMonomer(monomers);
            }
            if(StringUtils.isNotEmpty(list)){
                //新数据
                List<Monomer> inCollect = monomers.stream().filter(o -> o.getMonomerId() == null).collect(Collectors.toList());
                if(StringUtils.isNotEmpty(inCollect)){
                    monomerMapper.batchMonomer(inCollect);
                }
                //存在已删除的数据需要删除
                List<Monomer> collect = monomers.stream().filter(o -> o.getMonomerId() != null).collect(Collectors.toList());
                if(collect!=null&&collect.size()>0){
                    monomerMapper.updateBatch(collect);
                }
//                //需要修改的数据
//                List<Monomer> upCollect = collect.stream()
//                        .filter(item -> !list.stream().map(e -> e.getMonomerId())
//                                .collect(Collectors.toList()).contains(item.getMonomerId()))
//                        .collect(Collectors.toList());
//                if(StringUtils.isNotEmpty(upCollect)){
//                    monomerMapper.updateBatch(upCollect);
//                }
                //需要删除的数据
                List<Monomer> deCollect = list.stream()
                        .filter(item -> !collect.stream().map(e -> e.getMonomerId())
                                .collect(Collectors.toList()).contains(item.getMonomerId()))
                        .collect(Collectors.toList());
                if(StringUtils.isNotEmpty(deCollect)){
                    ids = deCollect.stream().map(Monomer::getMonomerId).collect(Collectors.toList());
                }
            }
        }else{
            ids = list.stream().map(Monomer::getMonomerId).collect(Collectors.toList());
        }
        if(ids.size()>0){
            Integer count = climbFrameMapper.getCountByMonomerIds(ids);
            if(count>0){
                throw new ServiceException("已关联爬架的楼栋，无法删除");
            }
            monomerMapper.deleteBatchByIds(ids);
        }
        //获取经纬度城市名称
        if(project.getLon() != null && project.getLat() != null){
            String province = MapUtil.getProvince(project.getLon(), project.getLat());
            project.setProvince(province);
        }
        return projectMapper.updateProject(project);
    }

    @Override
    public int deleteProjectById(Long projectId) {
        monomerMapper.deleteMonomer(projectId);
        return projectMapper.deleteProjectById(projectId);
    }

    @Override
    public int deleteProjectByIds(Long[] projectIds) {
        monomerMapper.deleteBatch(projectIds);
        return projectMapper.deleteProjectByIds(projectIds);
    }

    @Override
    public Integer getWarnCont() {
        return projectMapper.getWarnCont();
    }

    @Override
    public Integer getProjectCount() {
        return projectMapper.getProjectCount();
    }

    @Override
    public List<ProjectVO> getProjectProvince() {
        return projectMapper.getProjectProvince();
    }
}
