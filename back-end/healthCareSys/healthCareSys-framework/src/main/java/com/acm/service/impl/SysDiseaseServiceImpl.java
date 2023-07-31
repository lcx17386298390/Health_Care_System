package com.acm.service.impl;

import java.util.List;

import com.acm.entity.SysDisease;
import com.acm.mapper.SysDiseaseMapper;
import com.acm.service.ISysDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 患者病历Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
@Service
public class SysDiseaseServiceImpl implements ISysDiseaseService
{
    @Autowired
    private SysDiseaseMapper sysDiseaseMapper;

    /**
     * 查询患者病历
     * 
     * @param id 患者病历主键
     * @return 患者病历
     */
    @Override
    public SysDisease selectSysDiseaseById(String id)
    {
        return sysDiseaseMapper.selectSysDiseaseById(id);
    }

    /**
     * 查询患者病历列表
     * 
     * @param sysDisease 患者病历
     * @return 患者病历
     */
    @Override
    public List<SysDisease> selectSysDiseaseList(SysDisease sysDisease)
    {
        return sysDiseaseMapper.selectSysDiseaseList(sysDisease);
    }

    /**
     * 新增患者病历
     * 
     * @param sysDisease 患者病历
     * @return 结果
     */
    @Override
    public int insertSysDisease(SysDisease sysDisease)
    {
        return sysDiseaseMapper.insertSysDisease(sysDisease);
    }

    /**
     * 修改患者病历
     * 
     * @param sysDisease 患者病历
     * @return 结果
     */
    @Override
    public int updateSysDisease(SysDisease sysDisease)
    {
        return sysDiseaseMapper.updateSysDisease(sysDisease);
    }

    /**
     * 批量删除患者病历
     * 
     * @param ids 需要删除的患者病历主键
     * @return 结果
     */
    @Override
    public int deleteSysDiseaseByIds(String[] ids)
    {
        return sysDiseaseMapper.deleteSysDiseaseByIds(ids);
    }

    /**
     * 删除患者病历信息
     * 
     * @param id 患者病历主键
     * @return 结果
     */
    @Override
    public int deleteSysDiseaseById(String id)
    {
        return sysDiseaseMapper.deleteSysDiseaseById(id);
    }
}
